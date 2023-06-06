package practice;

public class TwoSumII {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		//int[] numbers = {-1,0};
		//int target = -1;
		int target = 9;
		System.out.println(twoSum(nums, target));
	}
	//two pointer
	public static int[] twoSum(int[] numbers, int target) {
        int start=0, end=numbers.length-1;
        int sum=0;
        while(numbers[start]+numbers[end] != target) {
        	sum = numbers[start]+numbers[end];
        	if(sum > target) end--;
        	else start++;
        }
		return new int[] {start+1,end+1};
    }

	
	//Binary Search
	public static int[] twoSum1(int[] numbers, int target) {
		int[] res = new int[2];
		int start=0;
		int end=numbers.length-1;
		while(start<end) {
			int mid = (start+end/2)+1;
			if(numbers[mid]>target) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			int sum = numbers[start]+numbers[end];
			if(sum == target) {
				res[0] = start+1;
				res[1] = end+1;
				return res;
			}else if(sum>target) {
				end--;
			}else if(sum<target) {
				start++;
			}
		}
		
		return new int[2];
	}
}
