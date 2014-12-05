import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MinimumWindowSubstring {
	public String minWindowSlow(String S, String T) {
		char[] chars = T.toCharArray();
		HashMap<Character, Integer> chars_count = new HashMap<Character, Integer>();
		for (char c : chars) {
			if (chars_count.containsKey(c)) {
				chars_count.put(c, chars_count.get(c) + 1);
			} else {
				chars_count.put(c, 1);
			}
		}
		HashMap<Character, Integer> record = new HashMap<Character, Integer>();
		int min = chars.length;
		while (min <= S.length()) {
			for (int i = 0; i <= S.length() - min; i++) {

				if (!chars_count.containsKey(S.charAt(i))) {
					continue;
				}
				record.clear();
				int match_count = 0;
				for (int j = i; j < i + min; j++) {
					char c = S.charAt(j);
					if (!chars_count.containsKey(c)
							|| (record.containsKey(c) && record.get(c) < chars_count
									.get(c))) {
						continue;
					} else {
						if (record.containsKey(c)) {
							record.put(c, record.get(c) + 1);
						} else {
							record.put(c, 1);
						}
						match_count++;
					}
				}

				if (match_count == min) {
					return S.substring(i, i + min);
				}

			}
			min++;
		}
		return "";
	}

	public String minWindow(String S, String T) {
		char[] chars = T.toCharArray();
		HashMap<Character, Integer> chars_count = new HashMap<Character, Integer>();
		for (char c : chars) {
			if (chars_count.containsKey(c)) {
				chars_count.put(c, chars_count.get(c) + 1);
			} else {
				chars_count.put(c, 1);
			}
		}
		HashMap<Character, Integer> record = new HashMap<Character, Integer>();
		int min_start = 0;
		int min_end = 0;
		int min_len = Integer.MAX_VALUE;
		int start = 0;
		int count = 0;


		for (int end = 0; end < S.length(); end++) {
			char c = S.charAt(end);

			if (!chars_count.containsKey(c)) {
				continue;
			}
			
			if(record.containsKey(c) && record.get(c) >= chars_count.get(c)){
				record.put(c, record.get(c)+1);
				continue;
			}
			
			if(record.containsKey(c) && record.get(c) < chars_count.get(c)){
				record.put(c, record.get(c)+1);
			} else{
				record.put(c, 1);
				}
			count ++;
			
			if(count == chars.length){
				while(!chars_count.containsKey(S.charAt(start)) || chars_count.get(S.charAt(start)) < record.get(S.charAt(start))){
					if(chars_count.containsKey(S.charAt(start))){
						record.put(S.charAt(start), record.get(S.charAt(start)) -1);
					}
					start ++;
				}
				if(end-start+1 < min_len){
					min_end = end;
					min_start = start;
					min_len = end-start+1;
				}
				count --;
				
				if(chars_count.containsKey(S.charAt(start))){
					record.put(S.charAt(start), record.get(S.charAt(start)) -1);
				}
				start ++;
				
			}
		}

		if(min_len>S.length()){
			return "";
		}
		
		return S.substring(min_start, min_end + 1);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring s1 = new MinimumWindowSubstring();
		String S = "acbbaca", T = "aba";

		System.out.println(s1.minWindow(S, T));
	}
}
