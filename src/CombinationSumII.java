import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;


public class CombinationSumII {
	
	int sum;
	int target;
	HashSet<String> record;
	List<List<Integer>> result;
	
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		 
		 result = new ArrayList<List<Integer>>();
		 record = new HashSet<String>();
		 
		 this.target = target;
		 
		 if (candidates.length == 0 || target <= 0){
			 return result;
		 }
		 
		 ArrayList<Integer> candidate = new ArrayList<Integer>();
		
		 for (int i: candidates){
			 candidate.add(i);
		 }
		 
		 Collections.sort(candidate);
		 System.out.println(candidate);
		 
	
		ArrayList<Integer> currentResult = new ArrayList<Integer>();
		helper(candidate, 0, 0, currentResult);
			 
		 
		 
		 
		
		 
		 return result;
	        
	    }
	 
	 public void register(ArrayList<Integer> currentResult){
		 StringBuilder s1= new StringBuilder();
		 ArrayList<Integer> buffer = new ArrayList<Integer>();
		 for(Integer i: currentResult){
			 s1.append(i);
			 buffer.add(i);
		 }
		 
		 if(!record.contains(s1.toString())){
			 result.add(buffer);
			 record.add(s1.toString());
		 }
	 }
	 public void helper(ArrayList<Integer> candidate, int start, int sum, ArrayList<Integer> currentResult){
		
		 for(int i=start; i<candidate.size(); i++){
			 
			if(i>start &&candidate.get(i) == candidate.get(i-1)) continue;
			sum += candidate.get(i);
			currentResult.add(candidate.get(i));
			
			if (sum > target){
				 sum -= candidate.get(i);
			     currentResult.remove(currentResult.size()-1);
				 return;
			 }
			
			if( sum == target){
				 result.add(new ArrayList<Integer>(currentResult));
				 sum -= candidate.get(i);
			     currentResult.remove(currentResult.size()-1);
			    
				 return;
				 
			 }
			
			helper(candidate, i+1, sum, currentResult);
			
			
			sum -= candidate.get(i);
			currentResult.remove(currentResult.size()-1);
			
			
		 }
			
		}
	 
	 public static void main(String[] args){
		 CombinationSumII s1 = new CombinationSumII();
/*		 int[] candidate = {1,2,2,4,3,5,7};
		 int target = 7;*/
		 
		 int [] candidate = {1, 2,2 ,2,5};
		 int target = 5;
		 System.out.println(s1.combinationSum2(candidate, target));
	 }

}
