/**
 * International is a subclass of Student This class calculates the tuition of
 * an international student and calls the superclass student to assign the
 * student information
 * 
 * @author Jared Montalbo, Noah Turbin
 *
 */
public class International extends Student {

	private boolean exchange;

	/**
	 * Constructor of International Assigns fname, lname, credit to superclass
	 * Student Assigns private variable exchange
	 * 
	 * @param fname    first name of student
	 * @param lname    last name of student
	 * @param credit   amount of credits student is taking
	 * @param exchange if an exchange student or not
	 */
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		// TODO Auto-generated constructor stub
		this.exchange = exchange;
	}

	/**
	 * Calculates amount of tuition the student owes if the student is international
	 * and returns the amount owed. Overrides abstract function defined in
	 * Student.java
	 * 
	 * @return an int, the amount of tuition owed
	 */
	@Override
	public int tuitionDue() {
		// Check if exchange student
		if (this.exchange) {
			return Fees.FULL_TIME_FEE + Fees.INTERNATIONAL_FEE;
		}
		// Handle if not exchange student
		if (this.credit < 12 && this.credit >= 9) {
			// Calculate if part time international
			return (this.credit * Fees.INTERNAIONAL_TUITION_FEE) + Fees.INTERNATIONAL_FEE + Fees.PART_TIME_FEE;
		} else {
			// Calculate if full time international
			int calculateCredit = this.credit;

			if (this.credit > 15) {
				calculateCredit = 15;
			}

			return (calculateCredit * Fees.INTERNAIONAL_TUITION_FEE) + Fees.INTERNATIONAL_FEE + Fees.FULL_TIME_FEE;
		}
	}

	/**
	 * Returns the contents of the International class as a String. calls the
	 * toString() method in the Student superclass, then adds information specific
	 * to the International subclass.
	 * 
	 * @returns A String of the information of this International Student.
	 */

	public String toString() {
		return super.toString() + " International, an exchange student: " + String.valueOf(this.exchange);
	}

	/**
	 * International.java testbed main Used to test the functionality of the methods
	 * in variables in International.java
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		International inter1 = new International("Jared", "Montalbo", 16, true);
		System.out.println(inter1.toString() + " owes: " + inter1.tuitionDue());
		// Tuition Amount: 1441 + 350 = 1791
		// Jared Montalbo 16 owes: 1791

		International inter2 = new International("Noah", "Turbin", 14, false);
		System.out.println(inter2.toString() + " owes: " + inter2.tuitionDue());
		// Tuition Amount: (14 * 945) + 350 + 1441 = 15021
		// Noah Turbin 14 owes: 15021

		International inter3 = new International("Jared", "Montalbo", 20, false);
		System.out.println(inter3.toString() + " owes: " + inter3.tuitionDue());
		// Tuition Amount: (15 * 945) + 350 + 1441 = 15966
		// Jared Montalbo 20 owes: 15966

		International inter4 = new International("Noah", "Turbinator", 10, false);
		System.out.println(inter4.toString() + " owes: " + inter4.tuitionDue());
		// Tuition Amount: (10 * 945) + 350 + 846 = 10646
		// Noah Turbinator 10 owes: 10646

	}

}
