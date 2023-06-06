package practice;

public class FibonacciNumber {
	
	public static void main(String args[]) {
		System.out.println(fib(5));
	}
	
	public static int fib(int n) {
		if(n==0) return 0;
        int one = 1; //f(1)
        int two = 1; //f(2)
        for(int i=1; i<n; i++) {
        	/*
        	 * here tow's value is stored in temp (to store two's value before calculating new two's val) and recalculated with adding one to it
        	 * then one is updated with two's previous value i.e. temp
        	 */
        	int temp = two;
        	two += one;
        	one = temp;
        }
        return one;
    }
}
