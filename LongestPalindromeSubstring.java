package practice;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
	}
	
	public static String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        for(int i=0; i<s.length();i++) {
        	//for odd
        	int left = i;
        	int right = i;
        	while(left>=0 && right<s.length() && (s.charAt(left) == s.charAt(right))) {
        		 //maxLen = Math.max(maxLen,(right-left+1));
        		 if(maxLen < (right-left+1)) {
        			 res = s.substring(left, right+1);
        			 maxLen = (right-left+1);
        		 }
        		 left --;
        		 right++;
        	}
        	//for even
        	left = i;
        	right = i+1;
        	while(left>=0 && right<s.length() && (s.charAt(left) == s.charAt(right))) {
        		 //maxLen = Math.max(maxLen,(right-left+1));
        		 if(maxLen < (right-left+1)) {
        			 res = s.substring(left, right+1);
        			 maxLen = (right-left+1);
        		 }
        		 left --;
        		 right++;
        	}
        }
		return res;
    }

}
