/**
 * Outstate is a subclass of Student
 * This class calculates the tuition of an outstate student and calls
 * the superclass student to assign the student information
 * 
 * @author Jared Montalbo, Noah Turbin
 *
 */
public class Outstate extends Student{

   private boolean tristate;
   
   
   /**
    * Constructor of Outstate
    * Assigns fname, lname, credit to superclass Student
    * Assigns private variable exchange
    * 
    * @param fname      first name of student
    * @param lname      last name of student
    * @param credit     amount of credits student is taking
    * @param exchange   if an exchange student or not
    */
   
   public Outstate(String fname, String lname, int credit, boolean tristate) {
      super(fname, lname, credit);
      // TODO Auto-generated constructor stub
      this.tristate = tristate;
      
   }

   
   /**
    * Calculates amount of tuition an Outstate student owes.
    * returns the amount owed.
    * Overrides abstract function defined in Student.java
    * 
    * @return an int, the amount of tuition owed
    */
   @Override
   public int tuitionDue() {
      // TODO Auto-generated method stub


	
	   //well, check how many credits this student has. if <12, they are a part time.
	   //credit hours beyond 15 count as 15 in calculating the per credit fee.
	   
	   //out state students pay 756 per credit.
	   //out state students from the tristate pay 556 per credit
	   //full time students pay a flat 1441 fee.
	   //part time students pay a flat 846 fee.
	   //note! out state students do not have funds.
	   int calculateCredit = this.credit;
       
       if (this.credit > 15) {
          calculateCredit = 15;
       }//handles credits beyond 15 being treated as 15 in calculating per credit fee.
	   
       
       
       
	   if(this.credit<12) {	//handle part time students.
		   
		   //if(this.tristate) { //if from tristate,
			   
			//   return (this.credit * (Fees.OUT_OF_STATE_TUITION_FEE)) + Fees.PART_TIME_FEE;
			   //returns part time, from tristate (part timers don't get the discount!
		   //}
		   
		 //  else {	
			
			   return (this.credit * Fees.OUT_OF_STATE_TUITION_FEE) + Fees.PART_TIME_FEE;
			   //return part time, not from tristate.
			   
		  // } 
		   
	   }//(this.credit<12). end of part time being handled.
	   
	   
	   else { //handle full time students.
		   
		   if(this.tristate) { //if from tristate, return the discounted rate.
			   
			   
			   return (calculateCredit * (Fees.OUT_OF_STATE_TUITION_FEE-200)) + Fees.FULL_TIME_FEE;
			   //returns full time, from tristate
		   }
		   
		   else {	
			
			   return (calculateCredit * Fees.OUT_OF_STATE_TUITION_FEE) + Fees.FULL_TIME_FEE;
			   //return full time, not from tristate.
			   
		   }
		   
		   
		   
	   }//end of else. end of full time students being handled.
	   
	   
	  
	   
	}//tuitionDue()
   
   
   
   /**
    * Returns the contents of the Outstate class as a String.
    * calls the toString() method in the Student superclass, then adds information specific
    * to the Outstate subclass. 
    * @returns A String of the information of this Outstate Student.
    */
   @Override
   public String toString() {
	      return super.toString() + " Outstate, from tristate: " + String.valueOf(this.tristate);
	   }
   
   
   public static void main(String [] args) {
	      Outstate out1 = new Outstate("Jared", "Montalbo", 16, true);
	      System.out.println(out1.toString() + " owes: " + out1.tuitionDue());
	      // Tuition Amount: 15*556 + 1441
	      // Jared Montalbo 16 owes: 9781

	      Outstate out2 = new Outstate("Noah", "Turbin", 15, false);
	      System.out.println(out2.toString() + " owes: " + out2.tuitionDue());
	      // Tuition Amount: 15*756 + 1441
	      // Noah Turbin 14 owes: 12781

	      
	      Outstate out3 = new Outstate("Jared", "Montalbo", 20, false);
	      System.out.println(out3.toString() + " owes: " + out3.tuitionDue());
	      // Tuition Amount: 15*756 + 1441
	      // Jared Montalbo 20 owes: 12781

	      
	      Outstate out4 = new Outstate("Noah", "Turbinator", 10, false);
	      System.out.println(out4.toString() + " owes: " + out4.tuitionDue());
	      // Tuition Amount: 10*756 + 846
	      // Noah Turbinator 10 owes: 8406
	    
	      Outstate out5 = new Outstate("Jeremy", "Lin", 1, true);
	      System.out.println(out5.toString() + " owes: " + out5.tuitionDue());
	      // Tuition Amount: 556 + 846
	      // Jeremy Lin 10 owes: 1402

	   } //end of test bed main

}
