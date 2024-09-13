
public class RecusrionDemo {

	public static void main(String[] args) {
		
		//hanoi(2,1,3);
		//System.out.println(factorial(10)); //3628800
		//System.out.println(twoToThePowerOf(4));
		//System.out.println(fib(7));
		//System.out.println(binary(13));
		hanoi(4, 1, 3);
		
	}
	
	public static String binary(int n) {
		if (n == 0) {
			return "";
		} else {
			return binary(n / 2) + "" + (n % 2);
		}
	}
	
	//Recursive fibonacci numbers.
	//1, 1, 2, 3, 5, 8
	//The two starting numbers are each 1
	//All other numbers are found by adding the two previous numbers.
	//This is very very inefficient.No stack overflow, but
	//repeats a lot fo the same calculations. 
	public static int fib(int n) {
		//Base:
		if (n <= 2) {
			return 1;
		}
		
		//Recursive:
		return fib(n-1) + fib(n-2);
	}
	
	
	//Recursively compute 2 to the power of n
	public static int twoToThePowerOf(int n) {
		//base 
		if (n == 0) {
			return 1;
		}
		//recursive
		return 2 * twoToThePowerOf(n - 1);
	}
	
	//Recursively compute factorial
	public static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public static void hanoi (int n, int start, int end) {
		
		//base case:
		if (n == 1) {
			System.out.println(start + " to " + end);
		} else {
			//recursive case
			int temp = 6 - start - end;
			hanoi(n-1, start, temp);
			hanoi(1, start, end);
			hanoi(n-1,  temp, end);
		}
		
	}
	
}
