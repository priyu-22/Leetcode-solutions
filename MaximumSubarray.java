package practice;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = {5,4,-1,7,8};
		System.out.println(maxSubArray(nums));
		
	}
	
	public static int maxSubArray(int[] nums) {
		int sum = nums[0];
		int maxSum = sum;
		for(int n=1; n <nums.length; n++) {
			sum = Math.max(nums[n], sum + nums[n]);
			maxSum = Math.max(maxSum, sum);
		}
		return (maxSum ==0)? sum: maxSum;		
    }

}
