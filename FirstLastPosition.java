package practice;

public class FirstLastPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(searchRange(nums, target));
	}
	

	public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
		return res;
    }
	
	private static int binarySearch(int[] nums, int target, boolean position) {
		int left = 0;
		int right = nums.length-1;
		int index = -1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(target< nums[mid]) {
				right = mid-1;
			}else if(target > nums[mid]) {
				left = mid + 1;
			}else {
				index = mid;
				if(position) {
					right = mid -1;
				}else {
					left = mid+1;
				}
			}
		}
		return index;
	}

}
