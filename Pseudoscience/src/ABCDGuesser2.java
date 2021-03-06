import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

public class ABCDGuesser2 {
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
		out.print("Enter the constant �� you want to approximate: ");
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
		out.print("Please enter a positive real number no equal to 1.0: ");
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
	/*
	 * Give the value of the percentage of the error
	 * 
	 * @param total 
	 * 				the total value of estimationi
	 * @param ��
	 * 				the value of approximation
	 */
	private static double errorCal(double total, double ��) {
		return Math.abs(total-��)/��;
	}
	
	public static void main(String[] args){
		SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        //Number list have 17 numbers
		Double[] numList= {-5.0, -4.0, -3.0, -2.0, -1.0, -1.0/2, -1.0/3, -1.0/4, 0.0, 1.0/4, 1.0/3, 1.0/2, 1.0, 2.0, 3.0, 4.0, 5.0};
		//Enter the value of �� with positive real number
		double ��=getPositiveDouble(in,out);
		//The base numbers w,x,y,z, enter the value of them
		double[] base=new double[4];
		int baseIndex=0;
		while(baseIndex<base.length) {
			base[baseIndex]=getPositiveDoubleNotOne(in,out);
			baseIndex++;
		}
		//Calculate the series
		double w=base[0],x=base[1],y=base[2],z=base[3];
		for(int a=0;a<numList.length;a++) {
			for(int b=0;b<numList.length;b++) {
				for(int c=0;c<numList.length;c++) {
					for(int d=0;d<numList.length;d++) {
						double total=Math.pow(w, numList[a])*Math.pow(x, numList[b])*Math.pow(y, numList[c])*Math.pow(z, numList[d]);
						double error=errorCal(total,��);
						if(error<0.01) {
							out.println("a is " + numList[a]);
							out.println("b is " + numList[b]);
							out.println("c is " + numList[c]);
							out.println("d is " + numList[d]);
							return; 
						}
					}
				}
			}
		}
		in.close();
		out.close();
		
		
	}
}
