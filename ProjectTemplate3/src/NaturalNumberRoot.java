import java.util.Comparator;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.queue.*;

/**
 * Program with implementation of {@code NaturalNumber} secondary operation
 * {@code root} implemented as static method.
 *
 * @author Put your name here
 *
 */
public final class NaturalNumberRoot {
	private static class StringLT implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return 0;
		}

		
	}
	/**
	 * Removes and returns the minimum value from {@code q} according to the
	 * ordering provided by the {@code compare} method from {@code order}.
	 * 
	 * @param q
	 *            the queue
	 * @param order
	 *            ordering by which to compare entries
	 * @return the minimum value from {@code q}
	 * @updates q
	 * @requires <pre>
	 * q /= empty_string  and
	 *  [the relation computed by order.compare is a total preorder]
	 * </pre>
	 * @ensures <pre>
	 * perms(q * <removeMin>, #q)  and
	 *  for all x: string of character
	 *      where (x is in entries (q))
	 *    ([relation computed by order.compare method](removeMin, x))
	 * </pre>
	 */
	private static String removeMin(Queue<String> q, Comparator<String> order) {
		assert q.length()==0 : "Violation of: the length of q is 0.";
	}
    /**
     * Reports whether n is even.
     * 
     * @param n
     *            the number to be checked
     * @return true iff n is even
     * @ensures isEven = (n mod 2 = 0)
     */
    public static boolean isEven(NaturalNumber n) {
    	NaturalNumber ncopy= new NaturalNumber2(n);
    	int remainder= ncopy.divideBy10();
    	if(remainder%2==0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
   
    
	/**
     * Main method.
     *	
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        NaturalNumber a= new NaturalNumber2(5);
        NaturalNumber b= new NaturalNumber2(3);
        NaturalNumber c= new NaturalNumber2(3);
        powerMod(a,b,c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        
    }

}