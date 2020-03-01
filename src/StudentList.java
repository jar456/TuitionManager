/**
 * This is the container class that defines a Student and its operations. The
 * class handles operations such as find, grow, isEmpty, remove, contains,
 * print.
 * 
 * @author Jared Montalbo, Noah Turbin
 */
public class StudentList {
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; // initial and grow size
   private Student[] students;
   private int numStudents;

   /**
    * Default Constructor of the class. Initializes the student array and
    * initializes number of members to 0.
    */
   public StudentList() {
      // this is the default constructor
      this.students = new Student[GROW_SIZE];
      this.numStudents = 0;

   }

   /**
    * Finds the student in the student list by comparing param s to the list. If
    * student is found, returns index number of the student
    * 
    * @param s The student to be found in the student list
    * @return NOT_FOUND Returns -1 if user is not found
    */
   private int find(Student s) {
      for (int i = 0; i < numStudents; i++) {

         // If we match a TeamMember then return it
         if (this.students[i].compareTo(s) == 0) {
            return i;
         }
      }

      return NOT_FOUND;
   }

   /**
    * Grows students container. Creates new array of students that is larger than
    * the old one by 1 Copys information of old array to new array and starts using
    * new array.
    * 
    * @return void
    */
   private void grow() {
      // Create New array that is one bigger than the previous
      Student[] students = new Student[this.numStudents + 1];

      // Set old students array values to newly sized students array
      for (int i = 0; i < this.numStudents; i++) {
         students[i] = this.students[i];
      }

      this.students = students; // Set new array to this.students array

      // Do nothing if numMembers is less than GROW_SIZE

      return;
   }

   /**
    * Checks if the students container is empty or not and returns a boolean
    * 
    * @return true if there are no students, false otherwise
    */

   public boolean isEmpty() {
      if (this.numStudents == 0) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * Adds a student to the container. Calls grow if the container isn't big enough
    * to hold another student
    * 
    * @param s The student to be added
    */
   public void add(Student s) {
      /*
       * If our array of students length is equal or less than the number of students
       * and the students length is greater or equal to the GROW_SIZE (4) then we
       * should grow our array of students
       */
      if ((this.students.length <= this.numStudents) && (this.students.length >= GROW_SIZE)) {
         this.grow();
      }

      // Increment number of members as it is safe to since we grew the array
      this.numStudents++;

      // Handle if there is only 1 student
      if (this.numStudents == 1) {
         this.students[0] = s;

         return;
      }

      for (int i = 0; i < this.numStudents; i++) {
         // Assign student to last item in the array of students
         if (i == this.numStudents - 1) {
            this.students[i] = s;
         }
      }

   }

   /**
    * Removes a given student from the list Returns true if student is found and
    * removed, False if none is found
    * 
    * @param s The student to be deleted
    * @return True if student is successfully defeated, false if none is found
    */
   public boolean remove(Student s) {
      // find the index of the student by using the find function
      int studentIndex = this.find(s);

      // If there is no student matched in our array then return false
      if (studentIndex == NOT_FOUND) {
         return false;
      }

      // Handle if there is only 1 student, Set the student to null and
      // decrement numStudents
      if (this.numStudents == 1) {
         this.students[0] = null;
         this.numStudents--;

         return true;
      }

      //
      for (int i = 0; i < this.numStudents; i++) {

         if (i == studentIndex) {

            for (; i < this.numStudents; i++) {

               if (i == this.numStudents - 1) {
                  this.students[i] = null;
                  this.numStudents--;

                  return true;
               }

               Student temp = this.students[i];
               this.students[i] = this.students[i + 1];
               this.students[i + 1] = temp;
            }
         }
      }

      return false;
   }

   /**
    * Checks if a student is already in the list of students and returns a boolean.
    * 
    * @param s The student to be found in the container
    * @return True if student is found in the container, false otherwise
    */
   public boolean contains(Student s) {
      for (int i = 0; i < this.numStudents; i++) {
         if (this.students[i].equals(s)) {
            return true;
         }
      }

      return false;
   }

   /**
    * Prints the students in the student container
    * 
    * @return void
    */
   public void print() {
      // set up a for loop and call the toString() method
      for (int i = 0; i < this.numStudents; i++) {
         System.out.println(this.students[i].toString());
      }

   }

   // Delete main later, just using for testing
   public static void main(String[] args) {
      StudentList list = new StudentList();

      Instate instate1 = new Instate("Jared", "Montalbo", 16, 100);
      Instate instate4 = new Instate("Noah", "Turbinator", 6, 0);
      Outstate out1 = new Outstate("Noah", "Montalbo", 16, true);
      International inter2 = new International("Jared", "Turbin", 14, false);
      Outstate out5 = new Outstate("Jeremy", "Lin", 1, true);

      list.add(instate1);
      list.add(instate4);
      list.add(out1);
      list.add(inter2);
      list.add(out5);

      list.print();

      list.remove(out1);
      list.remove(out5);

      System.out.println("\nRemoving Noah Montalbo and Jeremy Lin" + "\n");

      list.print();
   }

}
