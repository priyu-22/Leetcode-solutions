package practice;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCasePermutation("aaaa1b1"));
	}
	
	/* copied solution
	public static List<String> letterCasePermutation(String s) {
        List<String> res=new ArrayList<>();
        per(s,s.length(),0,new String(""),res);
        return res;
    }
    public static void per(String s,int n,int i,String p,List<String> res)
    {
        if(i==n)
        {
            res.add(new String(p));
            return;
        }
        char ch=s.charAt(i);
        if(!Character.isDigit(ch))
        {
            if(Character.isUpperCase(ch))
            per(s,n,i+1,p+Character.toLowerCase(ch)+"",res);
            else
            per(s,n,i+1,p+Character.toUpperCase(ch)+"",res);
        }
        per(s,n,i+1,p+ch+"",res);

    }
    */
	
	public static List<String> letterCasePermutation(String s) {
        List<String> strList = new ArrayList<String>();
        backtrack(s, s.length(), 0, "", strList);
		return strList;
    }
	
	private static void backtrack(String s, int len, int index, String tempStr, List<String> res) {
		if(len == index) {
			res.add(tempStr);
			return;
		}
		
		char c = s.charAt(index);
		if(!Character.isDigit(c)) {
			if(Character.isUpperCase(c)) {
				backtrack(s, len, index+1, tempStr+Character.toLowerCase(c)+"", res);
			}else {
				backtrack(s, len, index+1, tempStr+Character.toUpperCase(c)+"", res);
			}
		}
		backtrack(s, len, index+1, tempStr+c+"",res);
	}

}
