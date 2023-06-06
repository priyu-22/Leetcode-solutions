package practice;

import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("a","b"));

	}
	
	//Solution 1
	public static boolean isAnagram1(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		return Arrays.equals(sArr, tArr);
    }
	
	//Solution 2
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] arr = new int[26];
		for(int i=0; i<s.length()-1;i++) {
			arr[s.charAt(i)-'a']++;
			arr[t.charAt(i)-'a']--;
		}
		for(int j = 0; j<arr.length; j++) {
			if(arr[j] !=0) return false;
		}
		
		return true;
    }

}
