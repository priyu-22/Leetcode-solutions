package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTransformToAnotherString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));
	}
	
	public static boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> chars = new HashSet<>();
		for(int i=0; i<str1.length(); i++) {
			if(map.containsKey(str1.charAt(i))){
				if(map.get(str1.charAt(i)) != str2.charAt(i)) {
					return false;
				}
			}else {
				map.put(str1.charAt(i), str2.charAt(i));
				chars.add(str2.charAt(i));
			}
		}
		
		
		return chars.size()<26;
    }

}
