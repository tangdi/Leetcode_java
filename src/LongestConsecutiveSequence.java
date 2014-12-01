import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		Map<Integer, Boolean> history = new HashMap<Integer, Boolean>();
		int max = 0;
		for(int n:num){
			history.put(n, false);
		}
		for(int n: num){
			if(history.get(n)){
				continue;
			}
			history.put(n, true);
			int left_digit = n-1;
			int left_length = 0;
			int right_length = 0;
			int right_digit = n+1;
			while(history.containsKey(left_digit)){
				history.put(left_digit, true);
				
				left_length++;
				left_digit --;
				
			}
			while(history.containsKey(right_digit)){
				history.put(right_digit, true);
				right_length++;
				right_digit++;
			}
			max = Math.max(max, 1+left_length+right_length);
		}
		return max;
	}
	
	
}
