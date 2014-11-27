
public class BestTimetoBuyandSellStock {
public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i: prices){
        	min = Math.min(min, i);
        	maxProfit = Math.max(i-min, maxProfit);
        	
        }
        return maxProfit;
    }
}
