import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;
import components.utilities.Reporter;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 * 
 * @author Put your name here
 * 
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     * 
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
    	NaturalNumber zero = new NaturalNumber1L(0);
    	 if(exp.label().equals("plus")) {
    		NaturalNumber num1 = new NaturalNumber1L(evaluate(exp.child(0)));
    		NaturalNumber num2 = new NaturalNumber1L(evaluate(exp.child(1)));
         	num1.add(num2);
         	return num1;
         }
    	 if(exp.label().equals("minus")) {
     		NaturalNumber num1 = new NaturalNumber1L(evaluate(exp.child(0)));
     		NaturalNumber num2 = new NaturalNumber1L(evaluate(exp.child(1)));
     		if(num1.compareTo(num2)<0) {
     			Reporter.fatalErrorToConsole("The number is negative.");
     		}
     		else {
          	num1.subtract(num2);
     		}
          	return num1;
          }
    	 if(exp.label().equals("times")) {
     		NaturalNumber num1 = new NaturalNumber1L(evaluate(exp.child(0)));
     		NaturalNumber num2 = new NaturalNumber1L(evaluate(exp.child(1)));
          	num1.multiply(num2);
          	return num1;
          }
    	 if(exp.label().equals("divide")) {
     		NaturalNumber num1 = new NaturalNumber1L(evaluate(exp.child(0)));
     		NaturalNumber num2 = new NaturalNumber1L(evaluate(exp.child(1)));
          	if(num2.compareTo(zero)==0) {
          		Reporter.fatalErrorToConsole("Ths number is divided by 0.");
          	}
          	return num1;
          }
    	 else {
    		 return new NaturalNumber1L(exp.attributeValue("value"));
    	 }
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}