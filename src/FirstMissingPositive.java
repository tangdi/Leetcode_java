import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {
	public int firstMissingPositive2(int[] A) {
		if (A.length == 0)
			return 1;
		Map<Integer, Boolean> history = new HashMap<Integer, Boolean>();
		for (int i : A) {
			history.put(i, false);
		}
		int min = Integer.MAX_VALUE;

		for (int i : A) {
			if (history.get(i)) {
				continue;
			}
			int left = i - 1;
			int right = i + 1;
			while (left > 0) {
				if (history.containsKey(left)) {

					history.put(left, true);
					left--;
				} else {
					break;
				}

			}

			if (left > 0) {
				min = Math.min(min, left);
				continue;
			}
			while (true) {
				if (history.containsKey(right)) {
					history.put(right, true);
				} else {
					if (right > 0) {
						break;
					}
				}
				right++;
			}
			min = Math.min(min, right);

		}
		return min;
	}
	
	public int firstMissingPositive(int[] A) {
		
		Map<Integer, Boolean> history = new HashMap<Integer, Boolean>();
		for (int i : A) {
			history.put(i, false);
		}
		int i=1;
		while(i>0){
			if (history.containsKey(i)){
				i++;
			}else{
				return i;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		FirstMissingPositive s1 = new FirstMissingPositive();
		int[] A = { 1000, -1 };
		System.out.println(s1.firstMissingPositive(A));
	}
}
