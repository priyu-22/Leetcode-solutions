package practice;

public class ReverseWordsInStringII {

	public static void main(String[] args) {
		char[] s = {'a', ' ', 'b'};
		reverseWords(s);
	}
	
	public static void reverseWords(char[] s) {
        String str = new String(s);
        String[] strArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strArr.length-1; i>=0;i--) {
        	sb.append(strArr[i]);
        	sb.append(" ");
        }
        str = sb.toString();
        for(int i = 0; i<s.length; i++) {
        	s[i] = str.charAt(i);
        }
    }
}
