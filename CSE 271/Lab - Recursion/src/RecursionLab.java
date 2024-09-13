public class RecursionLab {

	public static void main(String[] args) {
		
		System.out.println(indexOfB("Banana")); //1
		System.out.println(indexOfB("aabbaa")); //11
		
	}
	
	// 7 4 4 4 8 8 8 7 7 7 4 4 11

	// NOTES:
	// There should be no loops in any of these solutions.
	
	// The only String methods you may use in this assignment
	// are charAt(), substring(), equals(), and length().
	
	// For problems that are about numbers, do not convert the numbers
	// to strings.
	
	// Recall that num % 2 will give you the last digit of a positive int.

	// The lucas numbers are 1, 3, 4, 7, 11, 18, and so on.
	// That is, the first two lucas(1) is 1, and lucas(2) is 3,
	// and each of the remaining numbers is the sum of the previous
	// two lucas numbers.
	public static int lucas(int n) {
		//base case
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 3;
		}
		
		//recursive case
		return lucas(n-1) + lucas(n-2);
	}

	// The threebonacci numbers are 1, 1, 1, 3, 5, 9, 17, and
	// so on. The first three numbers are each 1, and the remaining
	// numbers are computed by finding the sum of the previous three
	// numbers. So, threebonacci(6) is 9, for example.
	public static int threebonacci(int n) {
		//base case
		if ((n == 3) || (n==2) || (n==1)) {
			return 1;
		}
		
		//recursive case
		return threebonacci(n-1) + threebonacci(n-2) + threebonacci(n-3);
	}

	// Given n >= 0, recursively compute the sum of
	// the integers from 0 to n, inclusive. So, for example
	// sumToN(5) is 15 because 1 + 2 + 3 + 4 + 5 is 15
	// sumToN(3) is 6
	// sumToN(1) is 1
	// sumToN(0) is 0
	public static int sumToN(int n) {
		//base case
		if (n == 0) { 
			return 0;
		}
		
		//recursive case
		return n + sumToN(n - 1);
	}

	// Bunnies have two ears. Recursively compute the number of
	// ears on n bunnies. For example, bunnies(5) is 10.
	public static int bunnyEars(int n) {
		//base case
		if (n == 0) {
			return 0;
		}
		
		//recursive case
		return 2 + bunnyEars(n-1);
	}

	// Recursively compute the number of times that the digit 3
	// appears in the positive integer n. For example count3(43153) is 2.
	public static int count3(int n) {
		//base case
		if (n == 0) {
			return 0;
		}
		
		//recursive case
		if ((n % 10) == 3) {
			return 1 + count3(n/10) ;
		} else {
			return count3(n/10);
		}
	}

	// Recursively compute the number of times that the specified digit
	// appears in the positive integer n. For example countDigit(43153, 3) is 2.
	public static int countDigit(int n, int digit) {
		//base case
		if (n == 0) {
			return 0;
		}
				
		//recursive case
		if ((n % 10) == digit) {
			return 1 + countDigit(n/10,digit) ;
		} else {
			return countDigit(n/10, digit);
		}
	}

	// Recursively compute the number of times that the letter "s"
	// appears in the given string. For example:
	// sCount("classes") is 3
	// sCount("tree") is 0
	// sCount("s") is 1
	// sCount("") is 0
	public static int sCount(String s) {
		//base case
		if (s.length() == 0) {
			return 0;
		}
		//recursive case
		if (s.charAt(0) == 's') {
			return 1 + sCount(s.substring(1)); 
		} else {
			return sCount(s.substring(1));
		}
	}

	// Return true if all characters in the string are "s",
	// and false otherwise. In a string with no characters, all
	// of its characters are "s", so return true.
	// allS("sssss") is true
	// allS("ssSssss") is false
	// allS("s") is true
	// allS("") is true
	public static boolean allS(String s) {
		//base case
		if(s.length() == 0) {
			return true;
		}
		
		//recursive case
		if (s.charAt(0) == 's') {
			return allS(s.substring(1)); 
		} else {
			return false;
		}
	}

	// Recursively compute the number of times that the word "hi"
	// appears in the given string. For example:
	// hiCount("xhixx") is 1
	// hiCount("hihixhi") is 3
	// hiCount("hxi") is 0
	// hiCount("") is 0
	public static int hiCount(String s) {
		//base case
		if (s.length() == 0) {
			return 0;
		}
		//recursive case
		if (s.charAt(0) == 'h' && s.charAt(1) == 'i') {
			return 1 + hiCount(s.substring(2)); 
		} else {
			return hiCount(s.substring(1));
		}
		
	}

	// A palindrome is a string that is the same forward and backward.
	// Recursively determine if a string is a palindrome. Assume
	// the string is non-empty.
	// isPalindrome("mom") is true
	// isPalindrome("racecar") is true
	// isPalindrome("aaba") is false
	// isPalindrome("c") is true
	// isPalindrome("noon") is true
	// Suggestion: check the end letters for a match, and then
	// make a recursive call.
	public static boolean isPalindrome(String s) {
		//base case
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		//recursive case
		if (s.charAt(0) == s.charAt(s.length()-1)) {
			return isPalindrome(s.substring(1,s.length()-1)); 
		} else {
			return false;
		}
	}

	// Given a base b and an exponent e, compute
	// b to the power of e recursively.
	// Assume b >= 1 and e >= 0
	// For example:
	// pow(2, 5) is 32
	// pow(5, 1) is 5
	// pow(1, 5) is 1
	// pow(42, 0) is 1
	public static int pow(int b, int e) {
		//base case
		if (e == 0) {
			return 1;
		}
		//recursive case
		return b * pow(b, e-1);
		
	}

	// Recursively determine the first index of the
	// character A in a given string. Assume that A appears
	// in the string in at least one location.
	// indexOfA("Apple") is 0
	// indexOfA("bcAdeA") is 2
	// indexOfA("AAAAA") is 0
	public static int indexOfA(String s) {
		//base case
		
		//recursive case
		if (s.charAt(0) != 'A') {
			return 1 + indexOfA(s.substring(1));
		} else {
			return 0;
		}
	}

	// Recursively determine the first index of the
	// character B in a given string. If B does not
	// appear in the string, return -1.
	// indexOfB("Banana") is 0
	// indexOfB("bbb") is -1
	// indexOfB("012345B") is 6
	// indexOfB("") is -1
	public static int indexOfB(String s) {
		if (!(s.contains("B"))) {
			return -1;
		}
		
		if (s.charAt(0) != 'B') {
			return 1 + indexOfB(s.substring(1));
		} else {
			return 0;
		}
	}

}
