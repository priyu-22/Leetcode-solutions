package practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {58,1994,65,422,1,70};
		for(int num: i) {
			System.out.println("Input: "+num+"\nOutput: "+intToRoman(num));
			System.out.println("----------------------");
		}
		

	}
	
	public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
		
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = num/entry.getValue();
            while(count!=0) {
            	sb.append(entry.getKey());
            	count--;
            }
            num = num%entry.getValue();
        }
		return sb.toString();
    }
	
	
	public String intToRoman1(int num) {
		StringBuilder s = new StringBuilder();
		while (num >= 1000) {
			s.append('M');
			num -= 1000;
		}
		if (num >= 900) {
			s.append("CM");
			num -= 900;
		}
		if (num >= 500) {
			s.append('D');
			num -= 500;
		}
		if (num >= 400) {
			s.append("CD");
			num -= 400;
		}
		while (num >= 100) {
			s.append('C');
			num -= 100;
		}
		if (num >= 90) {
			s.append("XC");
			num -= 90;
		}
		if (num >= 50) {
			s.append('L');
			num -= 50;
		}
		if (num >= 40) {
			s.append("XL");
			num -= 40;
		}
		while (num >= 10) {
			s.append('X');
			num -= 10;
		}
		if (num == 9) {
			s.append("IX");
			num -= 9;
			return s.toString();
		}
		if (num >= 5) {
			s.append('V');
			num -= 5;
		}
		if (num == 4) {
			s.append("IV");
			num -= 4;
			return s.toString();
		}
		while (num >= 1) {
			s.append('I');
			num -= 1;
		}
		return s.toString();
	}

}
