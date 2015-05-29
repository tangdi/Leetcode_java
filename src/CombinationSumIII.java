import java.util.List;


public class CombinationSumIII {
	 private List<List<Integer>> result = new ArrayList<List<Integer>>();
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        List<Integer> temp = new ArrayList<Integer>();
	        helper(0, 0, k, temp, n);
	        return result;
	    }
	    
	    private void helper(int start, int sum, int length, List<Integer>list, int target){
	        if(list.size() == length ){
	            if(sum == target){
	                result.add(new ArrayList(list));
	            }
	            return;
	        }
	        for(int i =start; i<=9 ;i++){
	            list.add(i);
	            sum += i;
	            helper(i+1, sum, list, target);
	            sum -= i;
	            list.remove(list.size()-1);
	        }
	    }
}
