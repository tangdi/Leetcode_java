
public class BuySellStockII {
	public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i< prices.length; i++){
            if (prices[i] -prices[i-1] > 0){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
       
        
    }
	
	public static void main(String[] args){
		BuySellStockII sol = new BuySellStockII();
		int []prices = {1,2};
		System.out.println(sol.maxProfit(prices));
		
	}

}
