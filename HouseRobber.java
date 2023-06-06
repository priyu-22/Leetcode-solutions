package practice;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		System.out.println(rob(nums));
	}
	
	public static int rob1(int[] nums) {
        int oddRob = 0;
        int evenRob = 0;
        int twoSpacesRob =0;
		for(int i = 0; i<nums.length; i ++) {
			if((i+1)%2 == 0) {
				evenRob = evenRob+nums[i];
			}else {
				oddRob = oddRob+nums[i];
			}
			
		}
		return Math.max(oddRob, evenRob) ;
    }
	
	public static int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
		for(int n : nums) {
			int temp = Math.max(rob1+n, rob2);
			rob1 = rob2;
			rob2 = temp;
		}
		return rob2 ;
    }


}
