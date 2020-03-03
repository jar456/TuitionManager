import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class is the user interface class that handles input commands and output
 * messages. It first reads a line of parses it in a string tokenizer to
 * validate input. The user can add, remove, print, delete and quit using the
 * program's command keys.
 * 
 * @author Jared Montalbo, Noah Turbin
 */
public class TuitionManager {
   Scanner stdin = new Scanner(System.in);
   StudentList cs213 = new StudentList();
   StringTokenizer st;
   String command;
   private final int MAX_INPUTS = 5;
   private final int NUM_ADD_INPUTS = 4;
   private final int NUM_REMOVE_INPUTS = 2;
   private final int NUM_PRINT_QUIT_INPUTS = 0;

   /**
    * Begins the program by asking and processing input. This is where user
    * commands are validated and handled. Invalid inputs show an error message
    * while valid inputs call add(), remove(), print() or quit out of the program.
    * 
    */
   public void run() {
      System.out.println("Tuition Manager has started.");

      boolean done = false;
      while (!done) {
         st = new StringTokenizer(stdin.nextLine(), " ");
         if (st.countTokens() == 0 || st.countTokens() > MAX_INPUTS) {
            System.out.println("Invalid number of inputs");
            continue;
         }

         command = st.nextToken();

         switch (command.charAt(0)) {
         case 'I':
            // Are there more than 1 characters in command other than I? (ex. Isd), then
            // print error

            if (command.length() != 1) {
               System.out.println("Command '" + command + "' is not supported");
               break;

            } else if (!(st.countTokens() == NUM_ADD_INPUTS)) {
               // Checks if there is another input other than P
               // It should be 2 because we devoured "A" with String command = nextToken();
               // @Line 29

               System.out.println("Invalid number of inputs - Expected 5 arguments");
               break;
            }

            add();
            break;
         case 'O':
            // Are there more than 1 characters in command other than O? (ex. Asd), then
            // print error

            if (command.length() != 1) {
               System.out.println("Command '" + command + "' is not supported");
               break;

            } else if (!(st.countTokens() == NUM_ADD_INPUTS)) {
               // Checks if there is another input other than P
               // It should be 2 because we devoured "A" with String command = nextToken();
               // @Line 29

               System.out.println("Invalid number of inputs - Expected 5 arguments");
               break;
            }

            add();
            break;
         case 'N':
            // Are there more than 1 characters in command other than A? (ex. Asd), then
            // print error

            if (command.length() != 1) {
               System.out.println("Command '" + command + "' is not supported");
               break;

            } else if (!(st.countTokens() == NUM_ADD_INPUTS)) {
               // Checks if there is another input other than P
               // It should be 2 because we devoured "A" with String command = nextToken();
               // @Line 29

               System.out.println("Invalid number of inputs - Expected 5 arguments");
               break;
            }

            add();
            break;

         case 'R':
            // Are there more than 1 characters in command other than R? (ex. Rad), then
            // print error

            if (command.length() != 1) {
               System.out.println("Command '" + command + "' is not supported");
               break;
            } else if (st.countTokens() != NUM_REMOVE_INPUTS) {
               // Checks if there is another input other than P
               // It should be 2 because we devoured "R" with String command = nextToken();

               System.out.println("Invalid number of inputs - Use Format: R name date");
               break;
            }

            remove();
            break;

         case 'P':
            // Are there more than 1 characters in command other than P? (ex. Paa), then
            // print error

            if (command.length() != 1) {
               System.out.println("Command '" + command + "' is not supported");
               break;
            } else if (st.countTokens() != NUM_PRINT_QUIT_INPUTS) {
               // Checks if there is another input other than P
               // It should be 0 because we devoured "P" with String command = nextToken();

               System.out.println("Too many inputs! (" + st.countTokens() + " Extra)");
               break;
            }

            print();
            break;

         case 'Q':
            // Are there more than 1 characters in command other than Q? (ex. Qaa), then
            // print error

            if (command.length() != 1) {
               System.out.println("Command '" + command + "' is not supported");
               break;
            } else if (st.countTokens() != NUM_PRINT_QUIT_INPUTS) {
               // Checks if there is another input other than Q
               // It should be 0 because we devoured "Q" with String command = nextToken();

               System.out.println("Too many inputs! (" + st.countTokens() + " Extra)");
               break;
            }

            // print();
            System.out.println("Program terminated");
            done = true;
            return;

         default:
            // deal with bad command here
            System.out.println("Command '" + command + "' is not supported!");
         }
      }

      return;
   } // run()

   /**
    * Adds a Student to the list. Checks for duplicates first. Prints error message
    * if it has an invalid format. Prints error message if duplicate is found and
    * returns.
    * 
    * @return void
    */
   private void add() {

      // <command> <fname> <lname> <credit> <type-specific data>

      // inside st is still <fname> <lname> <credit> <type-specific data>
      // exactly 4 st.nextToken() calls!

      String fname = st.nextToken();
      String lname = st.nextToken();
      String credit = st.nextToken();
      String data = st.nextToken();

      Student s = null;
      // check if credits is valid.
      // first, it must be an integer.
      // then, it must be a positive integer.
      // sidenote:if it is an international, it cannot be less than 9

      int credit_num;
      try {
         // throws an exception if not an integer
         credit_num = Integer.parseInt(credit);

      } catch (Exception e) {
         System.out.println("incorrect format for credits");
         return; // ? do i do this?
      }

      if (credit_num < 1) {
         System.out.println("Expected a positive number of credits.");
         return;
      }

      if (credit_num < 9 && command.charAt(0) == 'N') {
         System.out.println("An international student cannot have less than 9 credits.");
         return;
      }

      if (command.charAt(0) == 'I') { // in state

         int funding;
         try {
            // throws an exception if not an integer
            funding = Integer.parseInt(data);

         } catch (Exception e) {
            System.out.println("funding incorrect format");
            return; // ? do i do this?
         }

         if (funding < 0) {
            System.out.println("Funding must be non negative.");
            return;
         }

         s = new Instate(fname, lname, credit_num, funding);
         // a part time Instate student cannot have funding. if this happens, funding is
         // assumed
         // to be none, but will be accepted as a valid student

      }

      if (command.charAt(0) == 'O') { // out of state

         // String data must be T or F.
         if (data.charAt(0) == 'T' && data.length() == 1) {

            s = new Outstate(fname, lname, credit_num, true);

         }

         else if (data.charAt(0) == 'F' && data.length() == 1) {

            s = new Outstate(fname, lname, credit_num, false);

         } else {
            System.out.println("type specified data must be 'T' or 'F'");
            return;
         }
      }

      if (command.charAt(0) == 'N') { // international

         // String data must be T or F.
         if (data.charAt(0) == 'T' && data.length() == 1) {

            s = new International(fname, lname, credit_num, true);

         }

         else if (data.charAt(0) == 'F' && data.length() == 1) {

            s = new International(fname, lname, credit_num, false);

         } else {
            System.out.println("type specified data must be 'T' or 'F'");
            return;
         }
      }

      if (cs213.contains(s)) {
         // then we don't add.
         System.out.println(s.toString() + " is already a Student.");
         return;
      }

      cs213.add(s);
      System.out.println("Student has been added");
   }

   /**
    * Removes a Student if a match is found in the list. Prints error message if it
    * has a student is not there. found.
    * 
    * @return void
    */
   private void remove() {
      // We know that there are 2 more tokens so we don't need to check for that
      // assign the first token, the first name
      String fname = st.nextToken();

      // assign the second token, the last name
      String lname = st.nextToken();

      Student s = new Outstate(fname, lname, 15, false);
      // make sure remove function only checks the names, and not the credit amount.

      if (cs213.remove(s)) {
         System.out.println(fname + " " + lname + " has been removed from the list.");
         return;
      }

      // if we get to here, then we could not find it in the list.
      System.out.println(fname + " " + lname + "could not be found in the list.");
   }

   /**
    * Prints a list of the Students, their info, and their tuition amount. An empty
    * List prints a message that there are no members.
    * 
    * @return void
    */
   private void print() {
      // must check if the team has 0 members.
      // if so, then print out "We have 0 members!". return.
      if (cs213.isEmpty()) {
         System.out.println("We have 0 students!");
         return;
      }

      cs213.print();

   } // print

   public static void main(String[] args) {

      TuitionManager tuit = new TuitionManager();
      tuit.run();
   }

} // ProjectManager
