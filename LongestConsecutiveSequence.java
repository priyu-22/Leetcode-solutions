package practice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{100,4,200,1,3,2}, {0,-1}, {0,1,6,5,3,2},{2,4,6,8,0},{2,2,7,9,5,2},{9,1,-3,2,4,8,3,-1,6,-2,-4,7},{0,3,7,2,5,8,4,6,0,1},{},{-5,-9,-6,0,1,-2,-3,-4,0,0,0,9,8,7,6,5,4,3}};
		for(int[] i: nums) {
			System.out.println("Input: "+i);
			System.out.println("Output: "+longestConsecutive(i));
			System.out.println("-------------------------------------------------------------------------");
		}
		

	}
	
	public static int longestConsecutive(int[] nums) {
		if(nums.length == 0) return 0;
       int maxSeq=0;
		Set<Integer> hs = new HashSet<Integer>();
		for(int i: nums) {
			hs.add(i);
		}
		for(int j: hs) {
			if(!hs.contains(j-1)) {
				int curr = j;
				int ans = 1;
				while(hs.contains(curr+1)) {
					curr+=1;
					ans +=1;
				}
				maxSeq = Math.max(ans, maxSeq);
			}
		}
		return maxSeq;
    }

}
