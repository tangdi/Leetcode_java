import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	final int LENGTH = 4;
	List<List<Integer>> solSet;

	public List<List<Integer>> fourSumSlow(int[] num, int target) {
		Arrays.sort(num);
		solSet = new ArrayList<List<Integer>>();
		helper(num, new ArrayList<Integer>(), target, 0, 0);
		return solSet;
	}

	public void helper(int[] num, List<Integer> sol, int target, int sum,
			int start) {
		for (int i = start; i < num.length; i++) {
			if (i > start && num[i] == num[i - 1]) {
				continue;
			}

			sum += num[i];
			sol.add(num[i]);

			if (sum > target || sol.size() > LENGTH) {
				sum -= num[i];
				sol.remove(sol.size() - 1);
				return;
			}

			if (sum == target && sol.size() == LENGTH) {
				solSet.add(new ArrayList<Integer>(sol));
				sum -= num[i];
				sol.remove(sol.size() - 1);
				return;
			}

			if (sum < target && sol.size() < LENGTH) {
				helper(num, sol, target, sum, i + 1);
			}

			sum -= num[i];
			sol.remove(sol.size() - 1);
		}
	}
	
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		solSet = new ArrayList<List<Integer>>();
		if(num.length<4) return solSet;
		
		for(int i=0; i< num.length -3; i++){
			if(i>0 && num[i] == num[i-1]) continue;
			for(int j=i+1; j< num.length-2; j++){
				if(j>i+1 && num[j] == num[j-1]) continue;
				int left_sum = target - num[i] - num[j];
				int head = j+1;
				int tail = num.length-1;
				while(head<tail){
					int sum = num[head] + num[tail];
					if(sum<left_sum){
						head++;
					}else if(sum>left_sum){
						tail--;
					}else{
						Integer [] sol = {num[i], num[j], num[head], num[tail]};
						solSet.add(Arrays.asList(sol));
						head++;
						tail--;
						while(head<tail && num[head] == num[head-1]){
							head++;
						}
						
						while(tail > head && num[tail] == num[tail+1]){
							tail--;
						}
					}
					
				}
			}
		}
		return solSet;
	}

	public static void main(String[] args) {
		FourSum s1 = new FourSum();
		int[] num = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		System.out.println(s1.fourSum(num, target));
	}
}
