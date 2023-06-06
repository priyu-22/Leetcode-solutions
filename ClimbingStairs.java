package practice;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(45));
	}
	public static int climbStairs(int n) {
        return rec(n);
    }
	private static int rec(int n) {
		/*if(n==1) return 1;
        if(n==2) return 2;
        int res = climbStairs(n-1) + climbStairs(n-2);
		return res;*/
		
		int one = 1;
		int two = 1;
		for(int i = 0; i<n-1; i++) {
			int temp = one;
			one += two;
			two = temp;
		}
		return one;
	}

}
