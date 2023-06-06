package practice;

public class ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(reverseWords("  the sky  is   blue   "));
	}
	
	public static String reverseWords1(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length-1; i>=0; i--) {
        	if(!str[i].equals("")) {
        		sb.append(str[i]);
        		sb.append(" ");
        	}
        }
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
    }

	
	public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
		s =s.trim();
		String[] str = s.split(" ");
        for(int i =str.length-1; i >=0; i--) {
        	if(str[i] == null || str[i].equals("")) {
        		continue;
        	}
        	ans.append(" ");
        	ans.append(str[i]);
        }
		
		return (ans.toString()).trim();
    }
}
