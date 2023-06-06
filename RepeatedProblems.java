package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RepeatedProblems {

	public static void main(String[] args) {
		//String to Integer
		//System.out.println(myAtoi("-9782638465124"));
		
		//String to String conversion
		//System.out.println(canConvert("aa", "ab"));
		
		//Add Strings
		//System.out.println(addStrings("1","9"));
		
		//Range Sum of BST
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);
		int low =7;
		int high = 15;
		System.out.println(rangeSumBST3(root, low, high));
	}
	
	//Range Sum of BST
	public static int rangeSumBST(TreeNode root, int low, int high) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int sum =0;
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			int n = curr.val;
			if(curr.left!=null) q.add(curr.left);
			if(curr.right != null) q.add(curr.right);
			if(n>=low && n<=high) {
				sum+=n;
			}
		}
		return sum;
	}
	public static int rangeSumBST3(TreeNode root, int low, int high) {
    	return recurssiveDfs(root, 0, low, high);
    }
    private static int recurssiveDfs(TreeNode root, int sum, int low, int high) {
    	if(root==null) return 0;
    	int n = root.val;
    	if(n <= high && n >= low) {
    		sum+= n;
    	}
    	if(root.left != null) {
    		sum = recurssiveDfs(root.left, sum, low, high);
    	}
    	if(root.right != null) {
    		sum = recurssiveDfs(root.right, sum, low, high);
    	}
    	return sum;
    }
	
	
	//Add String
	public static String addStrings(String num1, String num2) {
		 StringBuilder sum = new StringBuilder();
	        int carry=0;
	        int ptr1 = num1.length()-1;
	        int ptr2 = num2.length()-1;
	        
	        while(ptr1 >= 0 || ptr2 >= 0) {
	        	int first = (ptr1 >=0)? Character.getNumericValue(num1.charAt(ptr1)): 0;
	        	int second = (ptr2 >=0)? Character.getNumericValue(num2.charAt(ptr2)): 0;
	        	int temp = (first+second+carry);
	        	int add = temp % 10;
	        	carry = temp/10;
	        	sum.append(add);
	        	ptr1--;
	        	ptr2--;
	        }
	        if(carry !=0) sum.append(carry);
	        return sum.reverse().toString();
	}
	
	//String to Integer
	public static int myAtoi(String s) {
		s = s.trim();
		if(s == null || s.equals("")) return 0;
		int index = 0;
		int sign = 1;
		if(s.charAt(index) == '-'){
			sign = -1;
			index++;
		}else if(s.charAt(index) == '+') {
			sign = 1;
			index++;
		}
		long parsedNum = 0;
        while(index <s.length()) {
        	if(!Character.isDigit(s.charAt(index))) {
        		break;
        	}
        	int numericVal = Character.getNumericValue(s.charAt(index));
        	parsedNum = parsedNum* 10+ numericVal;
        	if((sign*parsedNum) < Integer.MIN_VALUE) {
        		return Integer.MIN_VALUE;
        	}else if((sign*parsedNum) > Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	}
        	index++;
        }
        
        return (int) (sign*parsedNum);
    }

	public static boolean canConvert(String str1, String str2) {
		if(str1.equals(str2)) return true;
		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> set = new HashSet<Character>();
		for(int i =0; i<str1.length(); i++) {
			if(map.containsKey(str1.charAt(i))) {
				if(map.get(str1.charAt(i)) != str2.charAt(i)) {
					return false;
				}
			}
			map.put(str1.charAt(i), str2.charAt(i));
			set.add(str2.charAt(i));
		}
		return set.size() < 26;
	}
}
