
public class ArrayStuff {

	public static void main(String[] args) {
		int[] nums = {3, 7, 5, 2, 5, 8};
		
		System.out.println(count5(nums));
		System.out.println(contains3(nums));
	}
	
	
	public static boolean contains3(int[] nums) {
		return contains3(nums, 0);
	}
	
	public static boolean contains3(int[] nums, int start) {
		if(start == nums.length )	return false;
		return nums[start] == 3 || contains3(nums, start+1);
		
		
		//If I find a 3, I'm done looking. Return true.
		//if (nums[start] == 3) {
		//	return true;
		//}
		
		//If I don't find a 3:
		//return contains3(nums, start + 1);
		
	}
	
	//A non-recursive helper method so that 
	//it's easier to call count5 in the main() method.
	public static int count5(int[] nums) {
		//This will call the recursive method
		return count5(nums,0);
	}
	
	//A recursive method that counts how many times 5
	//appears in the array
	public static int count5(int[] nums, int start) {
		//base case is: has start passed the end of the array
		if(start == nums.length) {
			return 0;
		}
		
		//
		if(nums[start] == 5) {
			return 1 + count5(nums,start + 1);
		}
		return 0 + count5(nums, start + 1);
	}
	
	public boolean groupSum(int start, int[] nums, int target) {
		//base case:
		//if(start == nums.length) {
		//	if(target ==0) {
		//		return true;
		//	}
		//	return false;
		//}
		
		if(start == nums.length) return target ==0;
		
		return groupSum(start +1, nums, target -nums[start]) || groupSum(start+1, nums, target);
	}
	
}
