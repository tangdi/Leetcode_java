import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (String i : strs) {
			char[] chars = i.toCharArray();
			Arrays.sort(chars);
			
			String sortedStr = new String(chars);
			
			if (map.containsKey(sortedStr)) {
				
				map.get(sortedStr).add(i);
				
			} else {
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(i);
				map.put(sortedStr, newList);
			}
		}
		
		for(Entry<String, List<String>> e: map.entrySet()){
			if(e.getValue().size()>1){
				
				for(String i: e.getValue()){
					result.add(i);
				}
			}
		}
		return result;

	}
	
	public static void main(String[] args){
		Anagrams s1 = new Anagrams();
		String[] strs = {"tea","and","ate","eat","dan"};
		System.out.println(s1.anagrams(strs));
	}

}
