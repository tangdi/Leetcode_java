import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> result = new ArrayList<String>();
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		
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
		if (B[s.length()] == false){
			return new ArrayList<String>();
		}
		List<String> newList = new ArrayList<String>();
		newList.add("");
		map.put(0, newList);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= s.length(); i++){
			if(B[i] == false){
				continue;
			}
			newList = new ArrayList<String>(); 
			
			for(int j=i-1; j>=0; j--){
						
				if(B[j] && dict.contains(s.substring(j, i))){
					
					for(String str: map.get(j)){
						sb.setLength(0);
						sb.append(str);
						if(str.length() !=0){
							sb.append(" ");
						}
						sb.append(s.substring(j,i));
						newList.add(sb.toString());
					}
					
				}
				
			}
			map.put(i, newList);
			
		}
		return map.get(s.length());
	}
	
	public static void main(String[] args) {
		WordBreakII s1 = new WordBreakII();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		System.out.println(s1.wordBreak(s, dict));
	}
}
