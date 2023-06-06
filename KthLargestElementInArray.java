package practice;

import java.util.Random;

public class KthLargestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num= {3,2,1,5,2,1,7};
		System.out.println(findKthLargest(num, 4));

	}
	
	public static int findKthLargest(int[] nums, int k) {
		int index = partion1(0, nums.length-1, nums);
        int req = nums.length-k;
        while(index != req) {
        	if(index>req) {
            	index = partion1(0, index-1, nums);
            }else {
            	index = partion1(index+1, nums.length-1, nums);
            }
        }
		return nums[index];
    }
	
	private static int partion(int low, int high, int[] nums) {
		int pIndex = low;
		int pivot = nums[low];
		swap(nums, pIndex, high); // swapped first and last elements
		
		for(int i=low; i<=high; i++) {
			if(nums[i]<=pivot) {
				swap(nums,i,pIndex);
				pIndex++;
			}
		}
		
		return pIndex-1;
	}
	
	private static int partion1(int low, int high, int[] nums) {
		int pivot = nums[low];
		int pIndex = low;
		for(int i = low; i<=high; i++) {
			if(nums[i]< pivot) {
				swap(nums, i, pIndex);
				pIndex++;
			}
		}
		swap(nums, high, pIndex);
		return pIndex;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	
	/*public static int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length-1, nums.length-k);
	}

	private static int quickSelect(int[] nums, int left, int right, int k) {
		if (left == right) return nums[left];

		int pIndex = 0;// new Random().nextInt(right - left + 1) + left;
		pIndex = partition(nums, left, right, pIndex);

		if (pIndex == k) return nums[k];
		else if (pIndex < k) return quickSelect(nums, pIndex+1, right, k);
		return quickSelect(nums, left, pIndex-1, k);
	}

	private static int partition(int[] nums, int left, int right, int pIndex) {
		int pivot = nums[pIndex];
		swap(nums, pIndex, right);
		pIndex = left;

		for (int i=left; i<=right; i++) 
			if (nums[i] <= pivot) 
				swap(nums, i, pIndex++);

		return pIndex - 1;
	}

	private static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}*/


}
