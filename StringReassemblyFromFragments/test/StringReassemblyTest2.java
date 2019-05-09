import static org.junit.Assert.*;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;

public class StringReassemblyTest2 {

	//addToSetAvoidingSubstringsTest
	@Test
	public void addToSetAvoidingSubstringsTest1() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("bcd");
		str.add("nbk");
		String add = "bc";
		Set<String> correct = new Set1L<String>();
		correct.add("abc");
		correct.add("bcd");
		correct.add("nbk");
		StringReassembly.addToSetAvoidingSubstrings(str,add);
		assertEquals(str,correct);
		assertEquals("bc",add);
	}
	@Test
	public void addToSetAvoidingSubstringsTest2() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("bcd");
		str.add("nbk");
		String add = "bc";
		Set<String> correct = new Set1L<String>();
		correct.add("abc");
		correct.add("bcd");
		correct.add("nbk");
		StringReassembly.addToSetAvoidingSubstrings(str,add);
		assertEquals(str,correct);
		assertEquals("bc",add);
	}
	@Test
	public void addToSetAvoidingSubstringsTest3() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("bcd");
		str.add("nbk");
		String add = "abcd";
		Set<String> correct = new Set1L<String>();
		correct.add("abcd");
		correct.add("nbk");
		StringReassembly.addToSetAvoidingSubstrings(str,add);
		assertEquals(str,correct);
		assertEquals("abcd",add);
	}
	@Test
	public void addToSetAvoidingSubstringsTest4() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("bcd");
		str.add("nbk");
		String add = "nk";
		Set<String> correct = new Set1L<String>();
		correct.add("abc");
		correct.add("bcd");
		correct.add("nbk");
		correct.add("nk");
		StringReassembly.addToSetAvoidingSubstrings(str,add);
		assertEquals(str,correct);
		assertEquals("nk",add);
	}
	//assembleTest
	@Test
	public void assembleTest1() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("bcd");
		str.add("nbk");
		Set<String> correct = new Set1L<String>();
		correct.add("abcd");
		correct.add("nbk");
		StringReassembly.assemble(str);
		assertEquals(str,correct);
	}
	@Test
	public void assembleTest2() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("dc");
		str.add("nbk");
		Set<String> correct = new Set1L<String>();
		correct.add("abc");
		correct.add("dc");
		correct.add("nbk");
		StringReassembly.assemble(str);
		assertEquals(str,correct);
	}
	@Test
	public void assembleTest3() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("cd");
		str.add("nbk");
		Set<String> correct = new Set1L<String>();
		correct.add("abcd");
		correct.add("nbk");
		StringReassembly.assemble(str);
		assertEquals(str,correct);
	}
	@Test
	public void assembleTest4() {
		Set<String> str = new Set1L<String>();
		str.add("abc");
		str.add("bcd");
		str.add("defg");
		Set<String> correct = new Set1L<String>();
		correct.add("abcdefg");
		StringReassembly.assemble(str);
		assertEquals(str,correct);
	}
	
	//combination Test
	@Test
	public void combinationTest1() {
		String str1="abcd";
		String str2="bcdef";
		int number = 3;
		String str =StringReassembly.combination(str1,str2,number);
		assertEquals("abcdef",str);
		assertEquals("abcd",str1);
		assertEquals("bcdef",str2);
	}
	@Test
	public void combinationTest2() {
		String str1="abcd";
		String str2="hij";
		int number = 0;
		String str =StringReassembly.combination(str1,str2,number);
		assertEquals("abcdhij",str);
		assertEquals("abcd",str1);
		assertEquals("hij",str2);
	}
	@Test
	public void combinationTest3() {
		String str1="abcd";
		String str2="def";
		int number = 1;
		String str =StringReassembly.combination(str1,str2,number);
		assertEquals("abcdef",str);
		assertEquals("abcd",str1);
		assertEquals("def",str2);
	}
	@Test
	public void combinationTest4() {
		String str1="abcd";
		String str2="opa";
		int number = 0;
		String str =StringReassembly.combination(str1,str2,number);
		assertEquals("abcdopa",str);
		assertEquals("abcd",str1);
		assertEquals("opa",str2);
	}
	//overlapTest
	@Test
	public void overlapTest1() {
		String str1="abcd";
		String str2="bcdef";
		int number =StringReassembly.overlap(str1,str2);
		assertEquals(3,number);
		assertEquals("abcd",str1);
		assertEquals("bcdef",str2);
	}
	@Test
	public void overlapTest2() {
		String str1="abcd";
		String str2="def";
		int number =StringReassembly.overlap(str1,str2);
		assertEquals(1,number);
		assertEquals("abcd",str1);
		assertEquals("def",str2);
	}
	@Test
	public void overlapTest3() {
		String str1="abcd";
		String str2="hij";
		int number =StringReassembly.overlap(str1,str2);
		assertEquals(0,number);
		assertEquals("abcd",str1);
		assertEquals("hij",str2);
	}
	@Test
	public void overlapTest4() {
		String str1="abcd";
		String str2="de";;
		int number =StringReassembly.overlap(str1,str2);
		assertEquals(1,number);
		assertEquals("abcd",str1);
		assertEquals("de",str2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
