/**
 * This is the container class that defines a team and its operations. The class
 * handles operations such as find, grow, isEmpty, remove, contains, print.
 * 
 * @author Jared Montalbo, Noah Turbin
 */
public class StudentList {
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; // initial and grow size
   private TeamMember[] team;
   private int numMembers;

   /**
    * Default Constructor of the class. Initializes the team array and initializes
    * number of members to 0.
    */
   public Team() {
      // this is the default constructor
      this.team = new TeamMember[GROW_SIZE];
      this.numMembers = 0;

   }

   /**
    * Finds the teamMember in the team by comparing param m to the team. If
    * teamMember is found, returns index number of the teamMember
    * 
    * @param m The teamMember to be found in the team
    * @return NOT_FOUND Returns -1 if user is not found
    */
   private int find(TeamMember m) {
      for (int i = 0; i < numMembers; i++) {

         // If we match a TeamMember then return it
         if (this.team[i].equals(m)) {
            return i;
         }
      }

      return NOT_FOUND;
   }

   /**
    * Grows team container. Creates new array of team that is larger than the old
    * one by 1 Copys information of old array to new array and starts using new
    * array.
    * 
    * @return void
    */
   private void grow() {
      // Create New array that is one bigger than the previous
      TeamMember[] team = new TeamMember[this.numMembers + 1];

      // Set old team array values to newly sized team array
      for (int i = 0; i < this.numMembers; i++) {
         team[i] = this.team[i];
      }

      this.team = team; // Set new array to this.team array

      // Do nothing if numMembers is less than GROW_SIZE

      return;
   }

   /**
    * Checks if the team container is empty or not and returns a boolean
    * 
    * @return true if there are no teamMembers, false otherwise
    */

   public boolean isEmpty() {
      if (this.numMembers == 0) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * Adds a team member to the container. Calls grow if the container isn't big
    * enough to hold another team member
    * 
    * @param m The team member to be added
    */
   public void add(TeamMember m) {
      /*
       * If our array of teamMembers length is equal or less than the number of
       * members and the team length is greater or equal the GROW_SIZE (4) then we
       * should grow our array of teamMembers
       */
      if ((this.team.length <= this.numMembers) && (this.team.length >= GROW_SIZE)) {
         this.grow();
      }

      // Increment number of members as it is safe to since we grew the array
      this.numMembers++;

      // Handle if there is only 1 teamMember
      if (this.numMembers == 1) {
         this.team[0] = m;

         return;
      }

      for (int i = 0; i < this.numMembers; i++) {
         // Assign teamMember to last item in the array of teamMembers
         if (i == this.numMembers - 1) {
            this.team[i] = m;
         }
      }

   }

   /**
    * Removes a given team member from the list Returns true if team member is
    * found and removed, False if none is found
    * 
    * @param m The team member to be deleted
    * @return True if team member is successfully defeated, false if none is found
    */
   public boolean remove(TeamMember m) {
      // find the index of the teamMember by using the find function
      int teamMemberIndex = this.find(m);

      // If there is no teamMember matched in our array then return false
      if (teamMemberIndex == NOT_FOUND) {
         return false;
      }

      // Handle if there is only 1 teamMember, Set the teamMember to null and
      // decrement numMembers
      if (this.numMembers == 1) {
         this.team[0] = null;
         this.numMembers--;

         return true;
      }

      //
      for (int i = 0; i < this.numMembers; i++) {

         if (i == teamMemberIndex) {

            for (; i < this.numMembers; i++) {

               if (i == this.numMembers - 1) {
                  this.team[i] = null;
                  this.numMembers--;

                  return true;
               }

               TeamMember temp = this.team[i];
               this.team[i] = this.team[i + 1];
               this.team[i + 1] = temp;
            }
         }
      }

      return false;
   }

   /**
    * Checks if a team member is already in the team and returns a boolean.
    * 
    * @param m The team member to be found in the container
    * @return True if team member is found in the container, false otherwise
    */
   public boolean contains(TeamMember m) {
      for (int i = 0; i < this.numMembers; i++) {
         if (this.team[i].equals(m)) {
            return true;
         }
      }

      return false;
   }

   /**
    * Prints the team members in the team container
    * 
    * @return void
    */
   public void print() {
      // set up a for loop and call the toString() method
      for (int i = 0; i < this.numMembers; i++) {
         System.out.println(this.team[i].toString());
      }

   }

}
