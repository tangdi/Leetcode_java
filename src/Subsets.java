import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subsets {
	List<List<Integer>> result;
	public List<List<Integer>> subsets(int[] S) {
        result = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        if(S.length ==0 || S == null)
        	return result;
        List<Integer> set = new ArrayList<Integer>();
        for(int i=0; i<=S.length; i++){
        	set.clear();
        	helper(S, 0, i, set);
        }
        
        return result;
    }

	public void helper(int[] S, int start, int length, List<Integer> set){
		if(length==0){
			result.add(new ArrayList<Integer>(set));
			return;
		}
		
		for(int i=start; i<S.length;i++){
	       	set.add(S[i]);
	       	helper(S, i+1, length-1, set);
	       	set.remove(set.size()-1);
	       }
		}
	
	public static void main(String[] args){
		Subsets s1 = new Subsets();
		int[] S= {1,2,3};
		System.out.println(s1.subsets(S));
	}
	
}
