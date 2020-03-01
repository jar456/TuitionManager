/**
 * The superclass of all Student subclasses Provides common functions compareTo
 * and toString and defines abstract function tuitionDue
 * 
 * @author Jared Montalbo, Noah Turbin
 *
 */

public abstract class Student implements Comparable {
   private String fname;
   private String lname;
   protected int credit;

   /**
    * Student constructor Assigns variables fname, lname, credit in this class
    * 
    * @param fname  first name of student
    * @param lname  last name of student
    * @param credit amount of credits student is taking
    */

   public Student(String fname, String lname, int credit) {
      this.fname = fname;
      this.lname = lname;
      this.credit = credit;

   }

   /**
    * Compares two Students names to see if they're equal
    * 
    * @param obj The student to be compared to
    * @return int Returns 0 if student names are equal, Return -1 if fname and
    *         lname is < obj, Return 1 if fname and lname is > obj
    */

   public int compareTo(Object obj) {
      if (obj == null || !(obj instanceof Student)) {
         return -1;
      }

      Student s = (Student) obj;

      if (this.fname.compareToIgnoreCase(s.fname) != 0) {
         
         if (this.fname.compareToIgnoreCase(s.fname) < 0) {
            return -1;
         } else {
            return 1;
         }
      }
      
      if (this.lname.compareToIgnoreCase(s.lname) != 0) {
         
         if (this.lname.compareToIgnoreCase(s.lname) < 0) {
            return -1;
         } else {
            return 1;
         }
      }

      return 0;

   } //compareTo()

   /**
    * Concatenates student's first name, last name, amount of credits and returns
    * the product
    * 
    * @return Concatenated string
    */
   public String toString() {
      return this.fname + " " + this.lname + " " + Integer.toString(this.credit);
   }

   /**
    * Compute the tuition due; concrete implementation is required in the
    * subclasses.
    * 
    * @return an int of the amount of the tuition that is due
    */
   public abstract int tuitionDue();

}