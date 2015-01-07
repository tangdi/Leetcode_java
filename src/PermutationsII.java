import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PermutationsII {
	public List<List<Integer>> permuteUniqueSlow(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num.length ==0){
			return result;
		}
		Arrays.sort(num);
		
		helperSlow(num, new ArrayList<Integer>(), result, num.length);
		return result;
	}

	public void helperSlow(int[] num, List<Integer> list,
			List<List<Integer>> result, int count) {
		if (list.size() == count) {
			result.add(new ArrayList<Integer>(list));
		}
		for (int i = 0; i < num.length; i++) {
			
			if(i>0 && num[i] == num[i-1]){
				continue;
			}
			list.add(num[i]);
	
			int [] newNum = new int[num.length-1];
			for(int j =0; j<newNum.length; j++){
				
				newNum[j] = j<i? num[j]: num[j+1];
				
			}
			helperSlow(newNum, list, result, count);
			
			list.remove(list.size() - 1);
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num.length ==0){
			return result;
		}
		Arrays.sort(num);
		boolean[] occupied = new boolean[num.length];
		for(int i =0; i< num.length; i++){
			occupied[i] = false;
		}
		helper(num, occupied, new ArrayList<Integer>(), result);
		return result;
	}

	public void helper(int[] num, boolean[] occupied, List<Integer> list,
			List<List<Integer>> result) {
		if (list.size() == num.length) {
			result.add(new ArrayList<Integer>(list));
		}
		for (int i = 0; i < num.length; i++) {
			if (occupied[i]) {
				continue;
			}
			
			if( i >0 && num[i] == num[i-1] && occupied[i-1] == false){
				continue;
			}
			list.add(num[i]);
			occupied[i] = true;
			helper(num, occupied, list, result);
			occupied[i] = false;
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		PermutationsII s1 = new PermutationsII();
		int [] num = {1, 2, 1};
		System.out.println(s1.permuteUnique(num));
	}
}
