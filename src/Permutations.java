import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num.length ==0){
			return result;
		}
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
			list.add(num[i]);
			occupied[i] = true;
			helper(num, occupied, list, result);
			occupied[i] = false;
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Permutations s1 = new Permutations();
		int[] num = {1, 2, 3};
		System.out.println(s1.permute(num));
	}
}
