package practice;

public class AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("6913259244", "71103343"));

	}
	
	public static String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry=0;
        int ptr1 = num1.length();
        int ptr2 = num2.length();
        
        while(ptr1 >= 0 && ptr2 >=0) {
        	int first = (ptr1 >=0)? num1.charAt(ptr1) - '0': 0;
        	int second = (ptr2 >=0)? num2.charAt(ptr2) - '0': 0;
        	int add = (first+second+carry) % 10;
        	carry = (first+second+carry)/10;
        	sum.append(String.valueOf(add));
        	ptr1--;
        	ptr2--;
        }
        if(carry !=0) sum.append(carry);
        return sum.reverse().toString();
    }
	
	

}
