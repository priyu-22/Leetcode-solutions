package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {

	public static void main(String[] args) {
		//int[][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
		//int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
		int[][] points = {{0,1},{1,3},{3,3},{4,4},{1,4},{2,3},{1,0},{3,4}};
		System.out.println(minAreaRect1(points));
	}
	
	//refered solution
	public static int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int[] i: points) {
			map.putIfAbsent(i[0], new ArrayList<Integer>());
			map.get(i[0]).add(i[1]);
		}
		int min = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) { 
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
	
	public static int minAreaRect1(int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int res=0;
		for(int[] i: points) {
			map.putIfAbsent(i[0], new ArrayList<Integer>());
			map.get(i[0]).add(i[1]);
		}
		Set<Integer> set = map.keySet();
		Map<Integer, Integer> usedPoints = new HashMap<Integer, Integer>();
		for(int i: set) {
			List<Integer> val = map.get(i);
			if(map.containsValue(val)) {
				for(Map.Entry<Integer, List<Integer>> en: map.entrySet()) {
					int key= en.getKey();
					if((usedPoints.containsKey(i) && usedPoints.get(i) ==(key))
							||(usedPoints.containsKey(key) && usedPoints.get(key) ==(i))) {
						continue;
					}
					if(key != i && en.getValue().equals(val)) {
						usedPoints.put(i,key);
						int temp = Math.max(i-key, key-i);
						res = (res!=0)? Math.min(res,temp): temp;
					}
				}
			}
		}
		
        return res*2;
    }

}
