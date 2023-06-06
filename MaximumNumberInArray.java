package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = {10,12,8,24,10,12};
		//System.out.println(solution(arr));
		System.out.println(solution1(arr));

	}
	
	public static String solution(long[] arr) {
        // Type your solution here
        long left = 0;
        long right =0;
        for(int i =1; i<arr.length; i++){
            if(arr[i] != -1){
                if(i%2 != 0){
                    left+=arr[i];
                }else{
                    right+=arr[i];
                }
            }
        }
        System.out.println("Left: "+left+" right: "+right);
        if(left>right) return "Left";
        else if(right>left) return "Right";
        else return "";
    }
	
	public static long sol(long[] tran) {
		List<Long> lis = new ArrayList<Long>();
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		Arrays.sort(lis.toArray());
		for(long l : tran) {
			if(!lis.contains(l)) {
				lis.add(l);
			}
		}
		return Long.valueOf(lis.size());
	}
	
	public static long[] solution1(long[] numbers) {
        // Type your solution here
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for(long l: numbers){
            if(map.containsKey(l)){
                map.put(l, map.get(l)+1);   
            }else{
                map.put(l,1);
            }
        }
        Arrays.sort(map.values().toArray());
        int val =0;
        long[] res;
        for(Map.Entry<Long, Integer> e: map.entrySet()) {
        	val = e.getValue();
        	if(e.getValue() <= val) {
        		
        	}
        	System.out.println(e.getKey()+" "+e.getValue());
        }
        return new long[0];
    }
}

