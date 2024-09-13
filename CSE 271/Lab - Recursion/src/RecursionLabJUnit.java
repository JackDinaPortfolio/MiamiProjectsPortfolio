import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionLabJUnit {

	@Test(timeout=1000)
	public void testLucas() {
		assertEquals(1, RecursionLab.lucas(1));
		assertEquals(11, RecursionLab.lucas(5));
		assertEquals(18, RecursionLab.lucas(6));
		assertEquals(29, RecursionLab.lucas(7));		
	}

	@Test(timeout=1000)
	public void testThreebonacci() {
		assertEquals(1, RecursionLab.threebonacci(1));
		assertEquals(1, RecursionLab.threebonacci(2));
		assertEquals(1, RecursionLab.threebonacci(3));
		assertEquals(9, RecursionLab.threebonacci(6));
		assertEquals(31, RecursionLab.threebonacci(8));
		assertEquals(57, RecursionLab.threebonacci(9));
	}

	@Test(timeout=1000)
	public void testSumToN() {
		assertEquals(0, RecursionLab.sumToN(0));
		assertEquals(1, RecursionLab.sumToN(1));
		assertEquals(15, RecursionLab.sumToN(5));
		assertEquals(5050, RecursionLab.sumToN(100));
	}

	@Test(timeout=1000)
	public void testBunnyEars() {
		assertEquals(0, RecursionLab.bunnyEars(0));
		assertEquals(2, RecursionLab.bunnyEars(1));
		assertEquals(10, RecursionLab.bunnyEars(5));
		assertEquals(34, RecursionLab.bunnyEars(17));
	}

	@Test(timeout=1000)
	public void testCount3() {
		assertEquals(1, RecursionLab.count3(3));
		assertEquals(2, RecursionLab.count3(33));
		assertEquals(2, RecursionLab.count3(313));
		assertEquals(0, RecursionLab.count3(125));
		assertEquals(8, RecursionLab.count3(333333303));
		assertEquals(1, RecursionLab.count3(8675309));
	}

	@Test(timeout=1000)
	public void testCountDigit() {
		assertEquals(1, RecursionLab.countDigit(3, 3));
		assertEquals(2, RecursionLab.countDigit(33, 3));
		assertEquals(0, RecursionLab.countDigit(3, 1));
		assertEquals(1, RecursionLab.countDigit(12340, 2));
		assertEquals(1, RecursionLab.countDigit(12340, 0));
		assertEquals(2, RecursionLab.countDigit(330333303, 0));
		assertEquals(7, RecursionLab.countDigit(330333303, 3));
		assertEquals(0, RecursionLab.countDigit(333333303, 9));
	}

	@Test(timeout=1000)
	public void testSCount() {
		assertEquals(3, RecursionLab.sCount("classes"));
		assertEquals(0, RecursionLab.sCount("tree"));
		assertEquals(1, RecursionLab.sCount("s"));
		assertEquals(0, RecursionLab.sCount(""));
		assertEquals(4, RecursionLab.sCount("mississippi"));
	}

	@Test(timeout=1000)
	public void testAllS() {
		assertTrue(RecursionLab.allS("sssss"));
		assertFalse(RecursionLab.allS("ssSssss"));
		assertTrue(RecursionLab.allS("s"));
		assertTrue(RecursionLab.allS(""));
		assertFalse(RecursionLab.allS("classes"));
		assertTrue(RecursionLab.allS("sssssssssssssss"));
		assertFalse(RecursionLab.allS("ssssssssssssssS"));
		assertFalse(RecursionLab.allS("Ssssssssssssss"));
		assertFalse(RecursionLab.allS("as"));
		assertFalse(RecursionLab.allS("so"));
	}

	@Test(timeout=1000)
	public void testHiCount() {
		assertEquals(1, RecursionLab.hiCount("xhixx"));
		assertEquals(3, RecursionLab.hiCount("hihixhi"));
		assertEquals(0, RecursionLab.hiCount("hxi"));
		assertEquals(0, RecursionLab.hiCount(""));
		assertEquals(2, RecursionLab.hiCount("aaahihi"));
		assertEquals(2, RecursionLab.hiCount("hibbbbbhib"));
		assertEquals(6, RecursionLab.hiCount("hihihihhiihihi"));
	}

	@Test(timeout=1000)
	public void testIsPalindrome() {
		assertTrue(RecursionLab.isPalindrome("mom"));
		assertTrue(RecursionLab.isPalindrome("c"));
		assertTrue(RecursionLab.isPalindrome("w"));
		assertTrue(RecursionLab.isPalindrome("racecar"));
		assertTrue(RecursionLab.isPalindrome("noon"));
		assertTrue(RecursionLab.isPalindrome("aabbaa"));
		assertTrue(RecursionLab.isPalindrome("aba"));
		assertTrue(RecursionLab.isPalindrome("wasitacatisaw"));

		assertFalse(RecursionLab.isPalindrome("abca"));
		assertFalse(RecursionLab.isPalindrome("bbaa"));
		assertFalse(RecursionLab.isPalindrome("ohwow"));
		assertFalse(RecursionLab.isPalindrome("abcdecba"));
		assertFalse(RecursionLab.isPalindrome("xy"));
	}

	@Test(timeout=1000)
	public void testPow() {
		assertEquals(32, RecursionLab.pow(2, 5));
		assertEquals(5, RecursionLab.pow(5, 1));
		assertEquals(1, RecursionLab.pow(1, 5));
		assertEquals(1, RecursionLab.pow(42, 0));
		assertEquals(10000, RecursionLab.pow(10, 4));
		assertEquals(1, RecursionLab.pow(17, 0));
		assertEquals(1, RecursionLab.pow(1, 94));
	}

	@Test(timeout=1000)
	public void testIndexOfA() {
		assertEquals(0, RecursionLab.indexOfA("Apple"));
		assertEquals(2, RecursionLab.indexOfA("bcAdeA"));
		assertEquals(0, RecursionLab.indexOfA("AAAAA"));
		assertEquals(6, RecursionLab.indexOfA("uvwxyzA"));
		assertEquals(4, RecursionLab.indexOfA("wwwwAAxxx"));
	}

	@Test(timeout=1000)
	public void testIndexOfB() {
		assertEquals(0, RecursionLab.indexOfB("Banana"));
		assertEquals(-1, RecursionLab.indexOfB("bbb"));
		assertEquals(4, RecursionLab.indexOfB("wxyzBaBBcB"));
		assertEquals(6, RecursionLab.indexOfB("012345B"));
		assertEquals(-1, RecursionLab.indexOfB(""));
	}

}