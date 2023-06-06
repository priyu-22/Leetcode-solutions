package practice;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("-91283472332"));
		//System.out.println(myAtoi("9223372036854775809"));

	}
	
	public static int myAtoi1(String s) {
        s = s.trim();
		int i = 0;
		int sign = 1;
		long parsedNum = 0;
        if(s == null || s.equals("")) return 0;
		if (s.charAt(i) == '-') {
			sign = -1;
			i += 1;
		}else if (s.charAt(i) == '+') {
			i += 1;}
		while (i < s.length()) {
			if (!Character.isDigit(s.charAt(i)))
				break;
			parsedNum = parsedNum * 10 + Character.getNumericValue(s.charAt(i));
			i++;
		}
		parsedNum *= sign;
		if (parsedNum < (int) Math.pow(-2, 31)){
			parsedNum = (int) Math.pow(-2, 31);
            return (int)parsedNum;
        }else if (parsedNum > (int) Math.pow(2, 31) - 1){
			return (int) Math.pow(2, 31);
        }
		return (int)parsedNum;
    }
	
	public static int myAtoi(String s) {
		s = s.trim();
		int i = 0;
		int sign = 1;
		long parsedNum = 0;
        if(s == null || s.equals("")) return 0;
		if (s.charAt(i) == '-') {
			sign = -1;
			i += 1;
		}else if (s.charAt(i) == '+') {
			i += 1;}
		while (i < s.length()) {
			if (!Character.isDigit(s.charAt(i)))
				break;
			parsedNum = parsedNum * 10 + Character.getNumericValue(s.charAt(i));
			if((parsedNum*sign) > Integer.MAX_VALUE -1) {
				return Integer.MAX_VALUE;
			}else if((parsedNum*sign) <= Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			i++;
		}
		parsedNum *= sign;
		return (int)parsedNum;
    }

}
