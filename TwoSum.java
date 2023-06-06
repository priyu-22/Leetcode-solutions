package practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,4};
		System.out.println(twoSum(nums, 6));

	}
	
	//PRACTICE 2
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for(int i=0; i<nums.length; i++) {
			int temp = target - nums[i];
			if(hm.containsKey(temp)) {
				res[0] = i;
				res[1] = hm.get(temp);
				return res;
			}else {
				hm.put(nums[i], i);
			}
		}
        return res;
    }
	
	//practice 1
	public static int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i< nums.length; i++){
            int req = target - nums[i];
            if(hm.containsKey(req)){
                ans[0]= hm.get(req);
                ans[1] = i;
                return ans;
            }else{
                hm.put(nums[i],i);
            }
        }
        return ans;
    }

}
