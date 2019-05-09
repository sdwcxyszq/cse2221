import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
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
		out.print("Enter the constant ¦Ì you want to approximate: ");
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
	
	public static void main(String[] args){
		SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        //Number list have 17 numbers
		double[] numList= {-5.0, -4.0, -3.0, -2.0, -1.0, -1.0/2, -1.0/3, -1.0/4, 0.0, 1.0/4, 1.0/3, 1.0/2, 1.0, 2.0, 3.0, 4.0, 5.0};
		//Enter the value of ¦Ì with positive real number
		double ¦Ì=getPositiveDouble(in,out);
		//The base numbers w,x,y,z, enter the value of them
		double[] base=new double[4];
		int baseIndex=0;
		while(baseIndex<base.length) {
			base[baseIndex]=getPositiveDoubleNotOne(in,out);
			baseIndex++;
		}
		double w=base[0],x=base[1],y=base[2],z=base[3];
		int a=0,b=0,c=0,d=0;
		while(a<numList.length) {
			while(b<numList.length) {
				while(c<numList.length) {
					while(d<numList.length) {
						double total=Math.pow(w, numList[a])*Math.pow(x, numList[b])*Math.pow(y, numList[c])*Math.pow(z, numList[d]);
						double error=Math.abs(total-¦Ì)/¦Ì;
						if(error<0.01) {
							out.println("a is " + numList[a]);
							out.println("b is " + numList[b]);
							out.println("c is " + numList[c]);
							out.println("d is " + numList[d]);
							return; 
						}
						d++;
					}
					d=0;
					c++;
				}
				c=0;
				b++;
			}
			b=0;
			a++;
		}
		in.close();
		out.close();
		
	}
}
