package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4, 9,5};
		int[] nums2 = {9, 4, 9, 8, 4};
		System.out.println(intersection(nums1, nums2));
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1 = new HashSet<Integer>();
        Set<Integer> inter = new HashSet<Integer>();
        for(int i: nums1) {
        	num1.add(i);
        }
        for(int j : nums2) {
        	if(num1.contains(j)) {
        		inter.add(j);
        	}
        }
        int[] array = new int[inter.size()];
        int i = 0;
        for(Integer val: inter) {
        	array[i] = val;
        	i++;
        }
        return array;
    }

}
