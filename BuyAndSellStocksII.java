package practice;

public class BuyAndSellStocksII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
        int p1 = 0;
        int p2 =1;
        int profit = 0;
        while(p2<prices.length) {
        	if(prices[p1]<prices[p2]) {
        		profit += (prices[p2]- prices[p1]);
        		p1++;
        	}else {
        		p1=p2;
        	}
        	p2++;
        	
        }
		return profit;
    }

}
