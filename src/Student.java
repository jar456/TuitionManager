public abstract class Student implements Comparable {
   private String fname;
   private String lname;
   protected int credit;

   public Student(String fname, String lname, int credit) {
      this.fname = fname;
      this.lname = lname;
      this.credit = credit;

   } // constructor

//must implement compareTo method because Student class implements the Comparable Interface
//return 0 if fname and lname of the two students are equal,
//return -1 if this fname and lname is < obj’s, return 1 if this fname and lname is > obj’s
//Hint: use the compareToIgnoreCase methods of the String class to compare fname
//and lname; compare the fname first, then lname; names are not case-sensitive;

   public int compareTo(Object obj) {
      if (obj == null || !(obj instanceof Student)) {
         return -1;
      }

      Student s = (Student) obj;

      if (this.fname.compareToIgnoreCase(s.fname) == 0 && this.lname.compareToIgnoreCase(s.lname) == 0) {
         return 0;
      }

      int FLAG_NAME_COMPARE = this.fname.compareToIgnoreCase(s.fname);
      if (FLAG_NAME_COMPARE < 0) {
         return -1;
      } else if (FLAG_NAME_COMPARE > 0) {
         return 1;
      }

      FLAG_NAME_COMPARE = this.lname.compareToIgnoreCase(s.lname);
      if (FLAG_NAME_COMPARE < 0) {
         return -1;
      } else if (FLAG_NAME_COMPARE > 0) {
         return 1;
      }

      return 0;

   }

//return a string with fname, lname and credit hours; subclasses will be using this method.
   public String toString() {
      return this.fname + " " + this.fname + " " + Integer.toString(this.credit);
   }

//compute the tuition due; concrete implementation is required in the subclasses.
   public abstract int tuitionDue();
}