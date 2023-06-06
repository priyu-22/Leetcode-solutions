package practice;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abaabaaba"));
	}
	
	/*public static boolean repeatedSubstringPattern(String s) {
        int ptr1 = 0;
        int ptr2 = 1;
        int fixedWindow = 0;
        String substr = "";
        while(ptr2<s.length()) {
        	if(s.charAt(ptr1) == s.charAt(ptr2)) {
        		fixedWindow = ptr2 - ptr1;
        		substr = (substr.equals(""))? s.substring(ptr1, ptr2): substr;
        		if(!substr.equals(s.substring(ptr1, ptr2))) {
        			return false;
        		}
        	}else {
        		ptr2++;
        	}
        	if(fixedWindow !=0) {
        		ptr1=ptr2;
        		ptr2+=fixedWindow;
        	}
        }
		
		
		return true;
    }*/
	
	
	public static boolean repeatedSubstringPattern(String s) {
		String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

}
