package practice;

public class FindPeekElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,1};
		System.out.println(findPeakElement1(nums));
	}
	
	
	public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
        	int mid = (left+right)/2;
        	if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
        		return mid;
        	}else {
        		if(nums[mid+1]>nums[mid]) {
        			left = mid;
        		}else {
        			right = mid;
        		}
        	}
        }
		
		
		return -1;
    }
	
	public static int findPeakElement1(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
        	int mid = (left+right)/2;
        	if(nums[mid] < nums[mid+1]) {
        		left = mid+1;
        	}else {
        		right = mid;
        	}
        }
		return left;
    }

}
