package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid1("[]"));
	}
	
	//using stack
	public static boolean isValid(String s) {
        if(s.length() < 2 || s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')') return false;
		Stack<Character> st = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
		for(char c: s.toCharArray()) {
        	if(c == '}' || c == ']' || c==')') {
        		char expectedOp = map.get(c);
        		if(st.isEmpty()) return false;
        		else if(expectedOp != st.pop()) {
        			return false;
        		}
        	}else {
        		st.push(c);
        	}
			
        }
		if(!st.isEmpty()) return false;
		
		return true;
    }
	
	//solution refered from LC solutions: without stack
	public static boolean isValid1(String s) {
		char[] opendBrackets = new char[s.length()+1];
		int cursor = 0;
		for(char c: s.toCharArray()) {
			if(c == '[' || c =='{' || c == '(') {
				opendBrackets[++cursor] = c;
			}else {
				if(cursor == 0) return false;
				if((c == '}' && opendBrackets[cursor] == '{')
					|| (c == ')' && opendBrackets[cursor] == '(')
					|| (c == ']' && opendBrackets[cursor] == '[')) {
					cursor--;
				}else {
					cursor --;
				}
			}
		}
		
		return cursor == 0;
	}

}
