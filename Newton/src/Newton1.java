import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }
    /**
	* Computes estimate of square root of x to within relative error 0.01%.
	* 
	* @param x
	*            positive number to compute square root of
	* @return estimate of square root
	*/
    private static double sqrt(double x) {
	    double r=x;
	    while(Math.abs(r*r-x)/x>=0.000001) {
	    	r=(r+x/r)/2;
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
        double x=1/2;
        System.out.println(x);
        out.print("Do you want to calculate another square root: ");
        String judge=in.nextLine();
        while(judge.equals("y"))
        {
        	out.print("Enter the number you want to calculate: ");
        	double num=in.nextDouble();
        	double result = sqrt(num);
        	System.out.println("Square root of " + num + " is " + result);
        	out.print("Do you want to calculate another square root: ");
        	judge=in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
