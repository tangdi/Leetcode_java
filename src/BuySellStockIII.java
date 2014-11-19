import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//maximum subarray problem
public class BuySellStockIII {
	public int maxProfitBrudeForce(int[] prices) {
	       if(prices.length == 0) {
	           return 0;
	       }
	      
	        int []delta_price = new int[prices.length];
	        delta_price[0] = 0;
	        int max_profit = 0;
	        
	        List<Integer> profits = new ArrayList<Integer>();
	        for (int i = 1; i< prices.length; i++){
	        	delta_price[i] = prices[i] - prices[i-1];
	            
	        }
	        
	       for (int i =1; i< prices.length; i++){
	    	   max_profit = Math.max(max_profit, findMax(delta_price, 1, i) + findMax(delta_price, i+1, prices.length-1));
	       }
	       
	        return max_profit;
	       
	        
	    }
	
	public int maxProfit(int[] prices) {
	       if(prices.length < 2) {
	           return 0;
	       }
	      
	        int []delta_price = new int[prices.length];
	        delta_price[0] = 0;
	        int max_profit = 0;
	        
	        List<Integer> profits = new ArrayList<Integer>();
	        for (int i = 1; i< prices.length; i++){
	        	delta_price[i] = prices[i] - prices[i-1];
	            
	        }
//	        System.out.println(delta_price[1]);
	        
	       List<Integer> MaxForward = new ArrayList<Integer>();
	       List<Integer> MaxBackward = new ArrayList<Integer>();
	        
	       int forward_max = 0;
	       int max_ending_here = 0;
	       
	       for (int i =1; i< prices.length; i++){
	    	   max_ending_here = Math.max(0, max_ending_here + delta_price[i]);
	    	   forward_max = Math.max(max_ending_here, forward_max);
//	    	   System.out.println(forward_max);
	    	   MaxForward.add(forward_max);
	    	
	    
	       }
	       
	       int backward_max = 0;
	       max_ending_here = 0;
	       MaxBackward.add(0);
	       for (int i=1; i<prices.length-1 ; i++){
	    	   
	    	   max_ending_here = Math.max(0, max_ending_here+delta_price[prices.length-i]);
	    	   backward_max = Math.max(max_ending_here, backward_max);
	    	   MaxBackward.add(backward_max);
	       }
	       
	       System.out.println(MaxBackward);
	       System.out.println(MaxForward);
	       
	       for (int i=0; i< MaxBackward.size(); i++){
	    	   max_profit = Math.max(max_profit, MaxBackward.get(i)+MaxForward.get(prices.length-2-i));
	       }
	        System.out.println(max_profit);
	        return max_profit;
	       
	        
	    }
	
	public int findMax(int[] delta_price, int start, int end){
		int max_profit = 0;
		int max_ending_here =0;
		for (int i = start; i<= end; i++){
        	max_ending_here = Math.max(0, max_ending_here + delta_price[i]);
        	max_profit = Math.max(max_ending_here, max_profit);
        }
		return max_profit;
		
	}
	
	public static void main(String[] args){
		BuySellStockIII sol = new BuySellStockIII();
		int []prices = {1};
		System.out.println(sol.maxProfit(prices));
		
	}

}
