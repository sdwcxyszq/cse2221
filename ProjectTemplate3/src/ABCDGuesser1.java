import components.simplereader.SimpleReader;
import components.simplewriter.SimpleWriter;
import components.utilities.FormatChecker;

public class ABCDGuesser1 {
	/**
	 * Repeatedly asks the user for a positive real number until the user enters
	 * one. Returns the positive real number.
	 * 
	 * @param in
	 *            the input stream
	 * @param out
	 *            the output stream
	 * @return a positive real number entered by the user
	 */
	private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
		out.print("Please enter a positive real number: ");
		String str= in.nextLine();
		double num = 0;
		boolean judge=false;
		while(!judge){
			if(FormatChecker.canParseDouble(str)) {
				num=Double.parseDouble(str);
				if(num>0) {
					judge=true;
				}
				else {
					out.print("The number is not a real number. Please enter another one: ");
					str=in.nextLine();
				}
			}
			else {
				out.print("The number is not a real number. Please enter another one: ");
				str=in.nextLine();
			}
		}
		return num;
		
	}
	  
	/**
	 * Repeatedly asks the user for a positive real number not equal to 1.0
	 * until the user enters one. Returns the positive real number.
	 * 
	 * @param in
	 *            the input stream
	 * @param out
	 *            the output stream
	 * @return a positive real number not equal to 1.0 entered by the user
	 */
	private static double getPositiveDoubleNotOne(SimpleReader in, SimpleWriter out) {
		out.print("Please enter a positive real number no equal to 1.0");
		String str= in.nextLine();
		double num = 0;
		boolean judge=false;
		while(!judge) {
			if(FormatChecker.canParseDouble(str)) {
				num=Double.parseDouble(str);
				if(num>0) {
					if(num!=1) {
						judge=true;
					}
					else {
						out.print("The number is equal to 1. Please enter another one: ");
						str=in.nextLine();
					}
				}
				else {
					out.print("The number is not a positive number. Please enter another one: ");
					str=in.nextLine();
				}
			}
			else {
				out.print("The number is not a real number. Please enter another one: ");
				str=in.nextLine();
			}
		}
		return num;
	}
}
