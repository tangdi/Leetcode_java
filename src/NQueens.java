import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
	public List<String[]> solveNQueens(int n) {
		List<String []> result = new ArrayList<String[]>();
		List<List<Integer>> queenLoc = getNQueensLocation(n);
		for(List<Integer> list: queenLoc){
			String[] strs = new String[n];
			for(int i=0; i<n; i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<n; j++){
					sb.append(".");
				}
				sb.setCharAt(list.get(i), 'Q');
				strs[i] = sb.toString();
				//System.out.println(strs[i]);
			}
			result.add(strs);
		}
		return result;
	}
	
	private List<List<Integer>> getNQueensLocation(int n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		helper(new ArrayList<Integer>(), result, n, new HashSet<Integer>());
		return result;
	}
	
	private void helper(List<Integer> list, List<List<Integer>> result, int n, Set<Integer> memory){
		if(list.size() == n){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		outer: for( int i=0; i<n; i++){
			
			for(Integer loc: memory){
				int row = loc / n;
				int col = loc % n;
				
				if(col == i || (Math.abs(col -i) == list.size() - row)){
					continue outer;
				}
			}
			
			memory.add(list.size() *n + i);
			list.add(i);
			
			helper(list, result, n, memory);
			list.remove(list.size()-1);
			memory.remove(list.size() *n +i);
		}
	}
	
	public static void main(String[] args) {
		NQueens s1 = new NQueens();
		System.out.println(s1.solveNQueens(4));
		
	}
}
