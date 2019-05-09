import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Ziqi Sheng
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }
    /**
	* Computes estimate of square root of x to within relative error 0.01%.
	* if x=0, we do not do the compute and give the value 0;
	* 
	* @param x
	*            positive number to compute square root of
	* @return estimate of square root
	*/
    private static double sqrt(double x, double y) {
	    double r=x;
	    if(r!=0) {
		    while(Math.abs(r*r-x)/x>=Math.pow(y, 2)) {
		    	r=(r+x/r)/2;
		    }
	    }
	    return r;
	}

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        out.print("Enter the number you want to calculate: ");
    	double num=Double.parseDouble(in.nextLine());
        while(num>=0)
        {
        	out.print("Enter the value of ¦Å: ");
        	double errorValue = in.nextDouble(); 
        	double result = sqrt(num,errorValue);
        	System.out.println("Square root of " + num + " is " + result);
        	out.print("Enter the number you want to calculate: ");
        	num=Double.parseDouble(in.nextLine());
        }
        out.println("Goodbye");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
