import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreakSlow(String s, Set<String> dict) {
		if (dict.contains(s)) {
			return true;
		}

		for (int i = 1; i <= s.length(); i++) {
			if (dict.contains(s.substring(0, i))
					&& wordBreakSlow(s.substring(i), dict)) {
				return true;
			}
		}
		return false;
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (dict.contains(s)) {
			return true;
		}

		if (s.length() == 0) {
			return false;
		}

		
		boolean B[] = new boolean[s.length() + 1];
		B[0] = true;

		for (int i = 1; i <= s.length(); i++){
			for(int j=i-1; j>=0; j--){
				if(B[j] && dict.contains(s.substring(j, i))){
					B[i] = true;
					break;
				}
			}
			
		}
		return B[s.length()];
	}
	
	public static void main(String[] args) {
		WordBreak s1 = new WordBreak();
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaa");
		dict.add("aaaa");
		System.out.println(s1.wordBreak(s, dict));
	}
}
