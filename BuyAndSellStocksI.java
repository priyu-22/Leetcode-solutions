package practice;

public class BuyAndSellStocksI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] prices = {7,1,5,3,6,4};
		int[] prices = {7,6,4,3,1};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
        int ptr1 = 0;
        int ptr2 = 1;
        int profit =0;
        while(ptr2<prices.length) {
        	if(prices[ptr1]< prices[ptr2]) {
        		profit = Math.max(profit, prices[ptr2]- prices[ptr1]);
        	}else {
        		ptr1=ptr2;
        	}
        	ptr2++;
        }
		return profit;
    }

}
