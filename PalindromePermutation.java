package practice;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("aab"));

	}
	
	public static boolean canPermutePalindrome(String s) {
        //even
		int ones = (s.length()%2 == 0) ? 0:1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c: s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		map.values();
		return false;
    }

}
