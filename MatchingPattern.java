package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MatchingPattern {

	public static void main(String[] args) {
		String pattern = "xxxxy";
		String str = "patpatpatpatrain";
		//String str = "gogopowerrangergogopowerranger";
		String[] res = patternMatcher(pattern, str);
		//List<String> res = matchPattern(pattern, str);

	}
	
	public static String[] patternMatcher(String pattern, String str) {
		int pLen= pattern.length();
		int sLen = str.length();
		if((pLen%2 !=0 && sLen%2 ==0) || (pLen%2 ==0 && sLen%2 !=0)) {
			return new String[0];
		}
		int xCount = 0;
		int yCount = 0;
		String subPattern = "";
		for(char c: pattern.toCharArray()) {
			xCount = (c == 'x')? xCount+1: xCount;
			yCount = (c == 'y')? yCount+1: yCount;
		}
		if(xCount%2 == 0) {
			xCount = xCount/2;
		}else {
			return new String[0];
		}
		if(yCount%2 == 0) {
			yCount = yCount/2;
		}else {
			return new String[0];
		}
		for(char c: pattern.toCharArray()) {
				if(c == 'x' && xCount !=0) {
					subPattern = subPattern+""+c;
					xCount --;
				}
				if(c == 'y' && yCount !=0) {
					subPattern = subPattern+""+c;
					yCount --;
				}
				if(xCount == 0 && yCount == 0) {
					break;
				}
		}
		
		
		
		
		return new String[2];
	}
	
	public static List<String> matchPattern(String pattern, String str) {
        List<String> result = new ArrayList<>();
        int patternLength = pattern.length();
        int strLength = str.length();
        
        for (int i = 1; i <= strLength / 2; i++) {
            if (strLength % i != 0) {
                continue;
            }
            
            int subLength = i;
            String firstSub = str.substring(0, subLength);
            int j = subLength;
            
            while (j < strLength) {
                String sub = str.substring(j, j + subLength);
                if (!sub.equals(firstSub)) {
                    break;
                }
                j += subLength;
            }
            
            if (j == strLength) {
                StringBuilder builder = new StringBuilder();
                Map<Character, String> map = new HashMap<>();
                Set<String> set = new HashSet<>();
                int index = 0;
                
                for (char c : pattern.toCharArray()) {
                    if (map.containsKey(c)) {
                        builder.append(map.get(c));
                    } else {
                        String sub = str.substring(index, index + subLength);
                        builder.append(sub);
                        map.put(c, sub);
                        set.add(sub);
                        index += subLength;
                    }
                }
                
                if (set.size() == 2) {
                    result.add(builder.toString());
                }
            }
        }
        
        return result;
    }

}
