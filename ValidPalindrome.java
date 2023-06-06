package practice;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

	}
	
	//using string builder reverse method
	public static boolean isPalindrome1(String s) {
		String str = s.toLowerCase();
		str = str.replaceAll("[^a-z0-9]", "");
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		if(sb.toString().equals(str)) {
			return true;
		}
		return false;
    }
	
	//using two pointers
	public static boolean isPalindrome(String s) {
		String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
		int start = 0;
		int end = str.length()-1;
		while(start<end) {
			if(str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			}else {
				return false;
			}
		}
		
		
		return true;
	}

}
