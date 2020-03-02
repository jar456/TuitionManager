/**
 * Instate is a subclass of Student.
 *  Instantiating an Instate student will calculate tuition based off instate fees and funds.
 * 
 * @author Jared Montalbo, Noah Turbin
 *
 */
public class Instate extends Student {

	private int funds;

	/**
	 * Constructor of Instate Assigns fname, lname, credit to its superclass Assigns
	 * private variable funds
	 * 
	 * @param fname  first name of student
	 * @param lname  last name of student
	 * @param credit amount of credits student is taking
	 * @param funds  funds student has been awarded
	 */
	public Instate(String fname, String lname, int credit, int funds) {

		super(fname, lname, credit);
		this.funds = funds;

		if (credit < 12) {
			this.funds = 0;
		}

	}

	/**
	 * Calculates amount of tuition the student owes if student is Instate and
	 * returns the amount owed. Overrides abstract function defined in Student.java
	 * 
	 * @return an int, the amount of tuition owed
	 */

	@Override
	public int tuitionDue() {
		// Check for part time or full time status
		if (this.credit < 12) {
			// Part time students don't qualify for funds
			return (this.credit * Fees.IN_STATE_TUTION_FEE) + Fees.PART_TIME_FEE;

		} else {
			int calculateCredit = this.credit;

			if (this.credit > 15) {
				calculateCredit = 15;
			}
			if (((calculateCredit * Fees.IN_STATE_TUTION_FEE) + Fees.FULL_TIME_FEE) < this.funds) {
				// handles if the funds given is larger than the fees

				return 0;

			}

			return (calculateCredit * Fees.IN_STATE_TUTION_FEE) + Fees.FULL_TIME_FEE - this.funds;

		} // else
	}// tuitionDue()

	/**
	 * Returns the contents of the Instate class as a String. calls the toString()
	 * method in the Student superclass, then adds information specific to the
	 * Instate subclass.
	 * 
	 * @returns A String of the information of this Instate Student.
	 */
	@Override
	public String toString() {
		return super.toString() + " Instate, with the funds: " + Integer.toString(this.funds);
	}

	/**
	 * Instate.java testbed main Used to test the functionality of the methods in
	 * variables in Instate.java
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Instate instate1 = new Instate("Jared", "Montalbo", 16, 100);
		System.out.println(instate1.toString() + " owes: " + instate1.tuitionDue());
		// Tuition Amount: (15 * 433) + 1441 - 100 = 7836
		// Prints: Jared Montalbo 16 owes: 1774

		Instate instate2 = new Instate("Noah", "Turbin", 10, 200);
		System.out.println(instate2.toString() + " owes: " + instate2.tuitionDue());
		// Tuition Amount: (10 * 433) + 846 = 5176 (Funds do not qualify, because he is
		// part time)
		// Prints: Noah Turbin 10 owes: 5176

		Instate instate3 = new Instate("Jared", "Montalbo", 12, 0);
		System.out.println(instate3.toString() + " owes: " + instate3.tuitionDue());
		// Tuition Amount: (16 * 433) + 1441 - 0 = 6637
		// Prints: Jared Montalbo 12 owes: 6637

		Instate instate4 = new Instate("Noah", "Turbinator", 6, 0);
		System.out.println(instate4.toString() + " owes: " + instate4.tuitionDue());
		// Tuition Amount: (6 * 433) + 846 = 3444
		// Prints: Noah Turbinator 6 owes: 3444

		System.out.println("Comparing Jared Montalbo to Jared Montalbo, Value: " + instate1.compareTo(instate3));
		// Since Jared Montalbo and Jared Montalbo is equal, value should be 0

		System.out.println("Comparing Jared Montalbo to Noah Turbin, Value: " + instate1.compareTo(instate2));
		// Since Jared comes earlier Noah, value should be -1

		System.out.println("Comparing Noah Turbin to Jared Montalbo, Value: " + instate2.compareTo(instate1));
		// Since Noah comes later then Jared, value should be 1

		System.out.println("Comparing Noah Turbin to Noah Turbinator, Value: " + instate2.compareTo(instate4));
		// Since Turbin has a shorter last name then Turbinator, value should be -1

		System.out.println("Comparing Noah Turbinator to Noah Turbin, Value: " + instate4.compareTo(instate2));
		// Since Turbinator has a longer last name then Turbin, value should be 1
	}

}
