import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

public class CombinationSum {
	int sum;
	int target;
	List<List<Integer>> result;
	
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 
		 result = new ArrayList<List<Integer>>();
		 
		 this.target = target;
		 
		 if (candidates.length == 0 || target <= 0){
			 return result;
		 }
		 
		 TreeSet<Integer> candidateSet = new TreeSet<Integer>();
		
		 for (int i: candidates){
			 candidateSet.add(i);
		 }
		 
		 ArrayList<Integer> candidate = new ArrayList<Integer>(candidateSet);
		 System.out.println(candidate);
		 
		 for(int i=0; i< candidate.size(); i++){
			 
			 
		 }
//		
		 
		 ArrayList<Integer> currentResult = new ArrayList<Integer>();
		 helper(candidate, 0, 0, currentResult);
		 
		 return result;
	        
	    }
	 
	 public void helper(ArrayList<Integer> candidate, int start, int sum, ArrayList<Integer> currentResult){
		 //System.out.println(sum);
		 System.out.println(start);
		 System.out.println(currentResult);
		 
		 
		
		 for(int i=start; i<candidate.size(); i++){
			
			sum += candidate.get(i);
			currentResult.add(candidate.get(i));
			
			if (sum > target){
				 System.out.println("larger");
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
			
			helper(candidate, i, sum, currentResult);
			
			
			sum -= candidate.get(i);
			currentResult.remove(currentResult.size()-1);
			
			
		 }
			
		}
	 
	 public static void main(String[] args){
		 CombinationSum s1 = new CombinationSum();
		 int[] candidate = {1,2,2,4,3,5,7};
		 int target = 7;
		 
		 /*int [] candidate = {1};
		 int target = 2;*/
		 System.out.println(s1.combinationSum(candidate, target));
	 }
			
}

