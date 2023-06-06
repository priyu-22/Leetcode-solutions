package practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> combinations = generateAll(new ArrayList<String>(), "", n, 0);
		return combinations;
    }
	
	private static List<String> generateAll(List<String> comb, String str, int open, int close ){
		if(open == 0 && close == 0) {
			comb.add(str);
			return comb;
		}
		if(open >0) generateAll(comb, str+"(", open-1, close+1);
		if(close>0) generateAll(comb, str+")", open, close-1);
		return comb;
	}

}
