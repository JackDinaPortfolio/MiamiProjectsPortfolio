import java.util.Arrays;

// After you have solved each problem here, you can paste your
// solution into the appropriate problem at
// https://codingbat.com/home/norm.krumpe@muohio.edu/sortproblems
// and test it.
// Note that most of these methods are void, but on CodingBat they all return
// arrays.
// So, you will need to add a return statement to your code after pasting in
// CodingBat.
// *** Your code will be graded via codingbat ***

public class SortLabHelper {

	public static void main(String[] args) {
		
		int[] nums = {47, 2, 18, 6, 3, 59, 2, 8, 19, 5};
		insertionSort(nums, 1);
		System.out.println(Arrays.toString(nums));
		//partition(nums);
	}

	/*
	 * Implement the specified number of passes of bubble sort.
	 */
	public static void bubbleSort(int[] nums, int passes) {
		
		// one pass compares side by side elements starting with 0 and 1
		// swapping if a big # is before the small
		for (int j = 0; j < passes; j++) {
			for (int i = 0; i < nums.length - 1; i++) {
				//side by side elements are at index i and i+1
				if(nums[i] > nums[i + 1]) {
					//swap
					int temp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		
	}

	/*
	 * Implement the specified number of iterations of selection sort (finding the
	 * smallest item and swapping it to position 0, the next smallest and swapping
	 * it to position 1, and so on, up to the specified number of iterations).
	 */
	public static void selectionSort(int[] nums, int iterations) {
		
	}

	/*
	 * Implement the specified number of passes of insertion sort.
	 */
	public static void insertionSort(int[] nums, int iterations) {
		for (int j = 0; j < iterations; j++) {
			for (int i = 0; i < nums.length -1; i++) {
				while (nums[i+1] < nums[i]) {
					int temp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
	}

	/*
	 * This method focuses only on the PARTITIONING portion of the quick sort
	 * algorithm. Normally, the quick sort algorithm would choose a pivot, partition
	 * around that pivot, and then recursively call quick sort on the parts to the
	 * left and right of the pivot.
	 */
	public static void partition(int[] nums) {
		int pivot = nums[nums.length - 1];
		int swap = 0;
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] <= pivot) {
				int temp = nums[swap];
				nums[swap] = nums[i];
				nums[i] = temp;
				swap++;
			}
		}
	}

	/*
	 * The normal mergeSort algorithm splits an array into two halves and mergeSorts
	 * each half. Then, it takes those two sorted halves and merges them together.
	 * This focuses on the part of the algorithm that merges two already sorted
	 * arrays into one big array.
	 */
	public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
		return null;
	}
}
