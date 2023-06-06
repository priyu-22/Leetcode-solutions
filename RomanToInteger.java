package practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXCIV"));

	}
	
	public static int romanToInt(String s) {
		int res = 0;
		int num =0;
		for(int i= s.length()-1; i>=0; i--) {
			switch(s.charAt(i)) {
			case 'I':
				num=1; 
				break;
			case 'V':
				num=5; 
				break;
			
			case 'X':
				num=10; 
				break;
			
			case 'L':
				num=50; 
				break;
			
			case 'C':
				num=100; 
				break;
			case 'D':
				num=500; 
				break;
			
			case 'M':
				num=1000; 
				break;
			
			}
			res = (4*num<res)? res-num: res+num;
			
		}
		
		return res;
	}
	
	
	
	public static int romanToInt1(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);
		
		int res = 0;
		StringBuilder sb = new StringBuilder(s);
		res = getVal(res, sb, "IV", map);
		res = getVal(res, sb, "IX", map);
		res = getVal(res, sb, "XL", map);
		res = getVal(res, sb, "XC", map);
		res = getVal(res, sb, "CD", map);
		res = getVal(res, sb, "CM", map);
		for(char c: sb.toString().toCharArray()) {
			res = res+ map.get(""+c);
		}
		
		return res;
	}
	private static int getVal(int res, StringBuilder sb, String rom, Map<String, Integer> map) {
		int index = sb.indexOf(rom);
		if(index != -1) {
			sb.delete(index, index+2);
			res = res+ map.get(rom);
		}
		return res;
	}

}
