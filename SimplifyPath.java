package practice;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/a//b////c/d//././/..";
		System.out.println(simplifyPath1(path));
	}
	
	public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
		for(char c: path.toCharArray()) {
			if(c == '/') {
				if(!sb.isEmpty()) {
					if(!stack.isEmpty() && sb.toString().equals("..")) {
						stack.pop();
					}else if(!sb.toString().equals(".") && !sb.toString().equals("..")) {
						stack.push(sb.toString());
					}
					sb.setLength(0);
				}
			}else {
				sb.append(c);
			}
		}
		while(!stack.isEmpty()) {
			String temp = stack.elementAt(0);
			stack.remove(0);
			sb.append(temp);
			sb.append("/");
		}
		if(sb.charAt(sb.length()-1) == '/') sb.deleteCharAt(sb.length()-1);
        
		return (sb.length() == 0)? sb.append("/").toString() : "/"+ sb.toString();
    }
	
	public static String simplifyPath1(String path) {
        StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<String>();
        String[] str = path.split("/");
        for(String s: str) {
        	if(s.equals("") || s.equals(".") || (stack.empty() && s.equals(".."))) {
        		continue;
        	}else if(!stack.isEmpty() && s.equals("..")) {
        		stack.pop();
        	}else {
        		stack.push(s);
        	}
        }
        while(!stack.isEmpty()) {
			String temp = stack.elementAt(0);
			stack.remove(0);
			sb.append(temp);
			sb.append("/");
		}
        String res="";
		if(sb.length() != 0) {
			if(sb.charAt(sb.length()-1) == '/') {
				sb.deleteCharAt(sb.length()-1);
			}
			res = "/"+sb.toString();
		}else {
			res = sb.append("/").toString();
		}
        
		return res;
    }

}
