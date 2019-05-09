import components.simplereader.SimpleReader1L;
import components.simplereader.SimpleReader;
import java.util.ArrayList;
import components.simplewriter.SimpleWriter1L;
import components.simplewriter.SimpleWriter;
import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;
public class Glossary_Processor {
	/**
	 * Output the head part of the glossary to the file we want.
	 * @param name 
	 * 				the name of the website
	 * @param out
	 * 				the SimpleWriter used to output the website
	 * @ensures <pre>
	 * <html>
	 * <head>
	 * <title>name</title>
	 * </head>
	 * <body>
	 * <h2>name</h2>
	 * <hr />
	 * <h3>Index</h3>
	 * </pre>
	 * 
	 */
	public static void Glossary_Heading(String name,SimpleWriter out ) {
		out.println("<html>");
		out.println("<head>");
		if(name!="") {
			out.println("<title>"+name+"</title>");
		}
		else {
			out.println("<title>No title</title>");
		}
		out.println("</head>");
		out.println("<body>");
		if(name!="") {
			out.println("<h2>"+name+"</h2>");
		}
		else {
			out.println("<h2>No title</h2>");
		}
		out.println("<hr />");
		out.println("<h3>Index</h3>");
	}
	/**
	 * Output the following part of the list of the glossary to the file we want
	 * @param out
	 * 				the SimpleWriter used to output the website
	 * @param array
	 * 				the arraylist which contain all the words of glossary
	 * @ensure <pre>
	 * <ul>
	 * <li><a href="word.html">word</a></li>
	 * ...
	 * </ul>
	 * </body>
	 * </html>
	 * 
	 */
	public static void list(SimpleWriter out,ArrayList<String> array) {
		if(array.size()>0) {
			out.println("<ul>");
			for(int index=0;index<array.size();index++) {
				out.println("<li><a href="+'"'+array.get(index)+".html"+'"'+">"+array.get(index)+"</a></li>");
			}
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");
		}
	}
	/**
	 * Return the meaning of the word we want
	 * @param file
	 * 				the SimpleReader who reads the input file
	 * @return the meaning of the word
	 */
	public static String meanGet(SimpleReader file) {
		String mean="";
		if(!file.atEOS()) {
			mean = file.nextLine();
			if(!file.atEOS()&&!mean.equals("")) {
				mean += " "+meanGet(file);
			}
		}
		return mean;
	}
	/**
	 * Return the following HTML files for these words
	 * @param out
	 * 				The simpleWriter to output the html file
	 * @param word
	 * 				the word from the glossary
	 * @param mean
	 * 				the definition of the word
	 * @param wordset
	 * 				the set who contains all the words from glossary.
	 * @param Set<Character> separator
	 * 				the set who used to separator words
	 * @param name
	 * 				the name of the glossary file
	 * @ensure <pre>
	 * <html>
	 * <head>
	 * <title>word</title>
	 * </head>
	 * <body>
	 * <h2><b><i><font color="red">word</font></i></b></h2>
	 * <blockquote>mean</blockquote>
	 * <hr />
	 * <p>Return to <a href="name.html">name</a>.</p>
	 * </body>
	 * </html>
	 */
	public static void translation(SimpleWriter out, String word, String mean,Set<String> wordSet,Set<Character> separator,String name) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>"+word+"</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2><b><i><font color="+'"'+"red"+'"'+">"+word+"</font></i></b></h2>");
		out.print("<blockquote>");
		int index=0;
		while(index<mean.length()) {
			String nextWord = nextWordOrSeparator(mean,index,separator);
			if(wordSet.contains(nextWord)) {
				out.print("<a href="+'"'+nextWord+".html"+'"'+">"+nextWord+"</a>");
			}
			else {
				out.print(nextWord);
			}
			index+=nextWord.length();
		}
		out.println("</blockquote>");
		out.println("<hr />");
		out.println("<p>Return to <a href="+'"'+name+".html"+'"'+">"+name+"</a>.</p>");
		out.println("</body>");
		out.println("</html>");
	}
	/**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     * 
     * @param str
     *            the given {@code String}
     * @param strSet
     *            the {@code Set} to be replaced
     * @replaces strSet
     * @ensures strSet = entries(str)
     */
    public static void generateElements(String str, Set<Character> strSet) {
        assert str != null : "Violation of: str is not null";
        assert strSet != null : "Violation of: strSet is not null";
        if(str.length()>0) {
        	char letter = str.charAt(0);
        	if(!strSet.contains(letter)) {
	        	strSet.add(letter);    	
        	}
        	if(str.length()>1) {
        		generateElements(str.substring(1),strSet);
        	}
        }

    }
	/**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     * 
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    public static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";
        String total="";
        char letter = text.charAt(position);
		total+=letter;
		position++;
		boolean judge1=separators.contains(letter);
        	while(position<text.length()) {
        		letter=text.charAt(position);
        		boolean judge2=separators.contains(letter);
        		if(judge1==judge2) {
        			total+=letter;                                                                        
        		}
        		else {
        			break;
        		}
        		position++;
        	}
        return total;
        
    }
    /**
     * Get a new array which is the ordered one from A-Z by the array.
     * We don't need the array anymore.
     * @param array
     * 				The arraylist which contains all the word from glossary 
     * @return Ordered array
     */
    public static ArrayList<String> arraySort(ArrayList<String> array){
    	ArrayList<String> listed = new ArrayList<String>();
    	while(array.size()>1) {
    		int min=0;
    		for(int index=1;index<array.size();index++) {
    			//By using the number of the char letter it symbolize, we can get it ordered.
    			int letter1 = array.get(min).charAt(0);
    			int letter2 = array.get(index).charAt(0);
    			if(letter1>letter2) {
    				min=index;
    			}
    		}
    		listed.add(array.get(min));
    		array.remove(min);
		}
    	listed.add(array.get(0));      
    	return listed;
    	
    }
	public static void main(String[] args) {
		/*
         * Define separator characters for test
         */
        final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        generateElements(separatorStr, separatorSet);
        //Do normal writer and reader
		SimpleWriter out= new SimpleWriter1L();
		SimpleReader in = new SimpleReader1L();
		// Read the file
		out.print("Please enter the file:");
		String fileName = in.nextLine();
		SimpleReader file = new SimpleReader1L(fileName);
		//Use a map to record the information from the import file.
		Map<String,String> glossary = new Map1L<>();
		//Define an arraylist to get the word
		ArrayList<String> wordList = new ArrayList<>();
		//Define a set to check whether the meaning has the word in the glossarr
		Set<String> wordSet = new Set1L<>();
		while(!file.atEOS()) {
			String word = file.nextLine();
			String mean = meanGet(file);
			glossary.add(word, mean);
			wordList.add(word);
			wordSet.add(word);
		}
		wordList=arraySort(wordList);
		// get the name of output file and the simplewriter
		out.print("Please enter the name of output file:");
		String name = in.nextLine();
		SimpleWriter output = new SimpleWriter1L(name+".html");
		//Output the glossary html
		Glossary_Heading(name,output);
		list(output,wordList);
		//output the word html
		for(int index=0;index<wordList.size();index++) {
			String word = wordList.get(index);
			SimpleWriter html = new SimpleWriter1L(word+".html");
			translation(html,word,glossary.value(word),wordSet,separatorSet,name);
		}
		out.close();
		in.close();
	}

	

}
