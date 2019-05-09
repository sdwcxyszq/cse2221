import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class Glossary_Test {
	
	//Test for method arraySort
	@Test
	public void arraySort_test1() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("name");
		array.add("flight");
		array.add("hi");
		array.add("whatever");
		ArrayList<String> list = new ArrayList<String>();
		list.add("flight");
		list.add("hi");
		list.add("name");
		list.add("whatever");
		ArrayList<String> newArray=Glossary_Processor.arraySort(array);
		assertEquals(newArray.get(0),list.get(0));
		assertEquals(newArray.get(1),list.get(1));
		assertEquals(newArray.get(2),list.get(2));
		assertEquals(newArray.get(3),list.get(3));
	}
	@Test
	public void arraySort_test2() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("name");
		array.add("flight");
		array.add("whatever");
		array.add("hi");
		array.add("query");
		ArrayList<String> list = new ArrayList<String>();
		list.add("flight");
		list.add("hi");
		list.add("name");
		list.add("query");
		list.add("whatever");
		ArrayList<String> newArray=Glossary_Processor.arraySort(array);
		assertEquals(newArray.get(0),list.get(0));
		assertEquals(newArray.get(1),list.get(1));
		assertEquals(newArray.get(2),list.get(2));
		assertEquals(newArray.get(3),list.get(3));
		assertEquals(newArray.get(4),list.get(4));
	}
	@Test
	public void arraySort_test3() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("name");
		array.add("flight");
		array.add("hi");
		array.add("query");
		array.add("znqe");
		array.add("whatever");
		ArrayList<String> list = new ArrayList<String>();
		list.add("flight");
		list.add("hi");
		list.add("name");
		list.add("query");
		list.add("whatever");
		list.add("znqe");
		ArrayList<String> newArray=Glossary_Processor.arraySort(array);
		assertEquals(newArray.get(0),list.get(0));
		assertEquals(newArray.get(1),list.get(1));
		assertEquals(newArray.get(2),list.get(2));
		assertEquals(newArray.get(3),list.get(3));
		assertEquals(newArray.get(4),list.get(4));
		assertEquals(newArray.get(5),list.get(5));
		
	}
	@Test
	public void arraySort_test4() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("name");
		array.add("flight");
		array.add("hi");
		array.add("query");
		array.add("znqe");
		array.add("whatever");
		array.add("apple");
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("flight");
		list.add("hi");
		list.add("name");
		list.add("query");
		list.add("whatever");
		list.add("znqe");
		ArrayList<String> newArray=Glossary_Processor.arraySort(array);
		assertEquals(newArray.get(0),list.get(0));
		assertEquals(newArray.get(1),list.get(1));
		assertEquals(newArray.get(2),list.get(2));
		assertEquals(newArray.get(3),list.get(3));
		assertEquals(newArray.get(4),list.get(4));
		assertEquals(newArray.get(5),list.get(5));
		assertEquals(newArray.get(6),list.get(6));
	}
	//test for generateElements
	@Test
	public void generateElements_test1() {
		String word = "life";
		Set<Character> strSet = new Set1L<Character>();
		Glossary_Processor.generateElements(word,strSet);
		assert(strSet.contains('l'));
		assert(strSet.contains('i'));
		assert(strSet.contains('f'));
		assert(strSet.contains('e'));
	}
	@Test
	public void generateElements_test2() {
		String word = " ";
		Set<Character> strSet = new Set1L<Character>();
		Glossary_Processor.generateElements(word,strSet);
		assert(strSet.contains(' '));
	}
	@Test
	public void generateElements_test3() {
		String word = "llife";
		Set<Character> strSet = new Set1L<Character>();
		Glossary_Processor.generateElements(word,strSet);
		assert(strSet.contains('l'));
		assert(strSet.contains('i'));
		assert(strSet.contains('f'));
		assert(strSet.contains('e'));
	}
	@Test
	public void generateElements_test4() {
		String word = "lifeeif";
		Set<Character> strSet = new Set1L<Character>();
		Glossary_Processor.generateElements(word,strSet);
		assert(strSet.contains('l'));
		assert(strSet.contains('i'));
		assert(strSet.contains('f'));
		assert(strSet.contains('e'));
	}
	//test for method Glossary_Heading
	@Test
	public void Glossary_Heading_test1() {
		String name = "hit";
		SimpleWriter out = new SimpleWriter1L("sample.txt");
		Glossary_Processor.Glossary_Heading(name, out);
		SimpleReader file1 = new SimpleReader1L("sample.txt");
		SimpleReader file2 = new SimpleReader1L("hit.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			String line1= file1.nextLine();
			String line2= file2.nextLine();
			assertEquals(line1,line2);
		}
		file1.close();
		file2.close();
	}
	@Test
	public void Glossary_Heading_test2() {
		String name = "";
		SimpleWriter out = new SimpleWriter1L("sample.txt");
		Glossary_Processor.Glossary_Heading(name, out);
		SimpleReader file1 = new SimpleReader1L("sample.txt");
		SimpleReader file2 = new SimpleReader1L("none.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			String line1= file1.nextLine();
			String line2= file2.nextLine();
			assertEquals(line1,line2);
		}
		file1.close();
		file2.close();
	}
	@Test
	public void Glossary_Heading_test3() {
		String name = "123";
		SimpleWriter out = new SimpleWriter1L("sample.txt");
		Glossary_Processor.Glossary_Heading(name, out);
		SimpleReader file1 = new SimpleReader1L("sample.txt");
		SimpleReader file2 = new SimpleReader1L("123.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			String line1= file1.nextLine();
			String line2= file2.nextLine();
			assertEquals(line1,line2);
		}
		file1.close();
		file2.close();
	}
	@Test
	public void Glossary_Heading_test4() {
		String name = "Get one place";
		SimpleWriter out = new SimpleWriter1L("sample.txt");
		Glossary_Processor.Glossary_Heading(name, out);
		SimpleReader file1 = new SimpleReader1L("sample.txt");
		SimpleReader file2 = new SimpleReader1L("get.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}
	//test for method list
	@Test
	public void list_test1() {
		ArrayList<String> array = new ArrayList<String>();
		SimpleWriter out = new SimpleWriter1L("list_sample.txt");
		Glossary_Processor.list(out,array);
		SimpleReader file = new SimpleReader1L("list_sample.txt");
		assert(file.atEOS());
		file.close();
	}
	@Test
	public void list_test2() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("hero");
		SimpleWriter out = new SimpleWriter1L("list_sample.txt");
		Glossary_Processor.list(out,array);
		SimpleReader file1 = new SimpleReader1L("list_sample.txt");
		SimpleReader file2 = new SimpleReader1L("list2.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}
	@Test
	public void list_test3() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("hero");
		array.add("game");
		array.add("help");
		SimpleWriter out = new SimpleWriter1L("list_sample.txt");
		Glossary_Processor.list(out,array);
		SimpleReader file1 = new SimpleReader1L("list_sample.txt");
		SimpleReader file2 = new SimpleReader1L("list3.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}
	@Test
	public void list_test4() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("hero");
		array.add("game");
		array.add("help");
		array.add("people");
		array.add("mine");
		SimpleWriter out = new SimpleWriter1L("list_sample.txt");
		Glossary_Processor.list(out,array);
		SimpleReader file1 = new SimpleReader1L("list_sample.txt");
		SimpleReader file2 = new SimpleReader1L("list4.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}
	//test for method meanGet
	@Test
	public void meanGet_test1() {
		String meaning = "";
		SimpleReader out = new SimpleReader1L("mean1.txt");
		String output = Glossary_Processor.meanGet(out);
		assertEquals(meaning,output);
		out.close();
	}
	@Test
	public void meanGet_test2() {
		String meaning = "game happy";
		SimpleReader out = new SimpleReader1L("mean2.txt");
		String output = Glossary_Processor.meanGet(out);
		assertEquals(meaning,output);
		out.close();
	}
	@Test
	public void meanGet_test3() {
		String meaning = "game happy day";
		SimpleReader out = new SimpleReader1L("mean3.txt");
		String output = Glossary_Processor.meanGet(out);
		assertEquals(meaning,output);
		out.close();
	}
	@Test
	public void meanGet_test4() {
		String meaning = "game happy day";
		SimpleReader out = new SimpleReader1L("mean4.txt");
		String output = Glossary_Processor.meanGet(out);
		assertEquals(meaning,output);
		out.close();
	}
	//test for method nextWordOrSeparator
	@Test
	public void nextWordOrSeparator_test1() {
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        String str="happy nice day";
        int position=0;
        String nextWord=Glossary_Processor.nextWordOrSeparator(str, position, separatorSet);
        assertEquals(nextWord,"happy");
	}
	@Test
	public void nextWordOrSeparator_test2() {
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        String str="happy nice day";
        int position=1;
        String nextWord=Glossary_Processor.nextWordOrSeparator(str, position, separatorSet);
        assertEquals(nextWord,"appy");
	}
	@Test
	public void nextWordOrSeparator_test3() {
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        String str="happy nice day";
        int position=5;
        String nextWord=Glossary_Processor.nextWordOrSeparator(str, position, separatorSet);
        assertEquals(nextWord," ");
	}
	@Test
	public void nextWordOrSeparator_test4() {
		//Determine separator
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        
        String str="happy , nice day";
        int position=5;
        String nextWord=Glossary_Processor.nextWordOrSeparator(str, position, separatorSet);
        assertEquals(nextWord," , ");
	}
	//test for method translation
	@Test
	public void translation_test1() {
		//Determine separator
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        
        //Define variable word, meaning, name
		String word="book";
		String meaning="a printed or written literary work";
		String name="index";
		
		//Get the wordSet
		Set<String> wordSet=new Set1L<String>();
		wordSet.add("book");
		wordSet.add("definition");
		wordSet.add("glossary");
		wordSet.add("meaning");
		wordSet.add("term");
		SimpleWriter out = new SimpleWriter1L("translation_sample.txt");
		Glossary_Processor.translation(out, word, meaning, wordSet, separatorSet, name);
		SimpleReader file1 = new SimpleReader1L("translation_sample.txt");
		SimpleReader file2 = new SimpleReader1L("translation1.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}
	@Test
	public void translation_test2() {
		//Determine separator
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        
        //Define variable word, meaning, name
		String word="glossary";
		String meaning="a list of difficult or specialized terms, with their definitions, usually near the end of a book";
		String name="index";
		
		//Get the wordSet
		Set<String> wordSet=new Set1L<String>();
		wordSet.add("book");
		wordSet.add("definition");
		wordSet.add("glossary");
		wordSet.add("meaning");
		wordSet.add("term");
		wordSet.add("word");
		SimpleWriter out = new SimpleWriter1L("translation_sample.txt");
		Glossary_Processor.translation(out, word, meaning, wordSet, separatorSet, name);
		SimpleReader file1 = new SimpleReader1L("translation_sample.txt");
		SimpleReader file2 = new SimpleReader1L("translation2.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}
	@Test
	public void translation_test3() {
		//Determine separator
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        
        //Define variable word, meaning, name
		String word="definition";
		String meaning="a sequence of words that gives meaning to a term";
		String name="index";
		
		//Get the wordSet
		Set<String> wordSet=new Set1L<String>();
		wordSet.add("book");
		wordSet.add("definition");
		wordSet.add("glossary");
		wordSet.add("meaning");
		wordSet.add("term");
		wordSet.add("word");
		SimpleWriter out = new SimpleWriter1L("translation_sample.txt");
		Glossary_Processor.translation(out, word, meaning, wordSet, separatorSet, name);
		SimpleReader file1 = new SimpleReader1L("translation_sample.txt");
		SimpleReader file2 = new SimpleReader1L("translation3.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}
	@Test
	public void translation_test4() {
		//Determine separator
		final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        Glossary_Processor.generateElements(separatorStr, separatorSet);
        
        //Define variable word, meaning, name
		String word="term";
		String meaning="a word whose definition is in a glossary";
		String name="index";
		
		//Get the wordSet
		Set<String> wordSet=new Set1L<String>();
		wordSet.add("book");
		wordSet.add("definition");
		wordSet.add("glossary");
		wordSet.add("meaning");
		wordSet.add("term");
		wordSet.add("word");
		SimpleWriter out = new SimpleWriter1L("translation_sample.txt");
		Glossary_Processor.translation(out, word, meaning, wordSet, separatorSet, name);
		SimpleReader file1 = new SimpleReader1L("translation_sample.txt");
		SimpleReader file2 = new SimpleReader1L("translation4.txt");
		while(!file1.atEOS()&&!file2.atEOS()) {
			assertEquals(file1.nextLine(),file2.nextLine());
		}
		file1.close();
		file2.close();
	}

}
