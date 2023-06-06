package practice;

public class NthTribonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tribonacci(5));

	}
	
	public static int tribonacci(int n) {
		int dp[] = {0, 1, 1};
	    for(int num=3;num<=n;num++){
	          dp[num%3]=dp[0]+dp[1]+dp[2];
	     }
	     return dp[n%3];
    }

}
