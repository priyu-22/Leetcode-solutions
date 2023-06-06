package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,3,3,3,4,2};
		System.out.println(topKFrequent(nums, 2));
	}
	
	public static int[] topKFrequent1(int[] nums, int k) {
        int[] result = new int[k];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int n : nums) {
        	if(hm.containsKey(n)) {
        		hm.put(n, hm.get(n)+1);
        	}else {
        		hm.put(n, 1);
        	}
        }
        int[] val = new int[hm.size()];;
        int m=0;
        for(int i: hm.values()) {
        	val[m] = i;
        	m++;
        }
        
        Arrays.sort(val);
        m=val.length-1;
        for(int n = 0; n<k;n++) {
        	result[n] = val[m];
        	m--;
        }
        return result;
    }

	
	public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        //another implementation
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int key = 0;
        int val = 0;
        for(int i = 0; i<nums.length; i++) {
        	if(key == nums[i]) {
        		val++;
        	}else {
        		
        		hm.put(key, val);
        	}
        }
        int[] counts = new int[nums.length];
        
        return result;
    }
}
