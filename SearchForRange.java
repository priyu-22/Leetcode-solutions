package practice;

public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
		System.out.println(searchForRange(nums, 45));

	}
	
	public static int[] searchForRange1(int[] nums, int target) {
		int[] range = new int[2];
		int left = 0;
		int right = nums.length-1;
		while(left<right) {
			int mid = left+right/2;
			//search at left
			
			if(target > nums[left] && target < nums[mid]) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		return range;
	}
	
	
	public static int[] searchForRange(int[] nums, int target) {
	    int leftIndex = binarySearchLeft(nums, target);
	    int rightIndex = binarySearchRight(nums, target);
	    return new int[]{leftIndex, rightIndex};
	}

	private static int binarySearchLeft(int[] nums, int target) {
	    int left = 0;
	    int right = nums.length - 1;
	    int result = -1;
	    
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (nums[mid] >= target) {
	            right = mid - 1;
	            if (nums[mid] == target) {
	                result = mid;
	            }
	        } else {
	            left = mid + 1;
	        }
	    }
	    
	    return result;
	}

	private static int binarySearchRight(int[] nums, int target) {
	    int left = 0;
	    int right = nums.length - 1;
	    int result = -1;
	    
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (nums[mid] <= target) {
	            left = mid + 1;
	            if (nums[mid] == target) {
	                result = mid;
	            }
	        } else {
	            right = mid - 1;
	        }
	    }
	    
	    return result;
	}

}
