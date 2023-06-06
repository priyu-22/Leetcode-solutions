package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}
	
	//not feasible for large inputs
	//brute force approach
	public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> visited = new ArrayList<String>();
		for(int i =0; i<strs.length;i++) {
			if(visited.contains(strs[i])) continue;
			String word = sortedWord(strs[i]);
        	List<String> anagrams = new ArrayList<String>();
        	anagrams.add(strs[i]);
        	visited.add(strs[i]);
        	for(int j = i+1; j<strs.length; j++) {
        		String jStr = sortedWord(strs[j]);
        		if(word.equals(jStr)) {
        			anagrams.add(strs[j]);
        			visited.add(strs[j]);
        		}
        	}
        	res.add(anagrams);
        }
		return res;
    }
	
	//still not feasible for large inputs
	public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        List<String> visited = new ArrayList<String>();
		for(int i =0; i<strs.length;i++) {
			if(visited.contains(strs[i])) continue;
			String word = sortedWord(strs[i]);
			hm.put(word, new ArrayList<String>());
			hm.get(word).add(strs[i]);
        	visited.add(strs[i]);
        	for(int j = i+1; j<strs.length; j++) {
        		if(visited.contains(strs[j]));
        		String jStr = sortedWord(strs[j]);
        		if(word.equals(jStr)) {
        			hm.get(word).add(strs[j]);
        			visited.add(strs[j]);
        		}
        	}
        }
		return new ArrayList(hm.values());
    }
	
	private static String sortedWord(String s) {
		char[] c = s.toCharArray();
        Arrays.sort(c);
        String str = new String(c);
        return str;
	}
	

}
