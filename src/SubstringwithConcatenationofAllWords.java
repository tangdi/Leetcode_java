import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstringSlow(String S, String[] L) {
    	List<List<String>> set = new ArrayList<List<String>>();
    	helperBuilder(set, -1, 0, L, new ArrayList<String>());
    	List<Integer> result = new ArrayList<Integer>();
    	StringBuilder sb = new StringBuilder();
    	for(List<String> list: set){
    		sb.setLength(0);
    		for(String s: list){
    			sb.append(s);
    		}
    		for (int i = -1; (i = S.indexOf(sb.toString(), i + 1)) != -1; ) {
    		    result.add(i);
    		}
    	}
    	return result;
    	
    }
    
    
    public void helperBuilder(List<List<String>> set, int index, int length, String[] L, List<String> list){
    	if (length == L.length ){
    		set.add(new ArrayList<String>(list));
    		return;
    	}
    	for(int i=0; i<L.length; i++){
    		if(i == index){
    			continue;
    		}
    		list.add(L[i]);
    		helperBuilder(set, i, length+1, L, list);
    		list.remove(list.size()-1);
    	}
    }
    
    public List<Integer> findSubstring(String S, String[] L) {
    	int singleStringLen = L[0].length();
    	int subStringLen = L.length * singleStringLen;
    	List<Integer> result = new ArrayList<Integer>();
    	HashMap<String, Integer> words = new HashMap<String, Integer>();
    	HashMap<String, Integer> records = new HashMap<String, Integer>();
    	for(int index = 0; index<L.length; index++){
			if(words.containsKey(L[index])){
				words.put(L[index], words.get(L[index])+1);
			}else{
				words.put(L[index], 1);
			}
		}
  
    	for(int i=0; i<=S.length()-subStringLen;i++){
    		records.clear();
    		
    		
    		String to_be_test = S.substring(i, i+subStringLen);
    		int count =0;
    		for( ; count<L.length; count++){
    			String s = to_be_test.substring(count*singleStringLen, count*singleStringLen+singleStringLen);
    			if(!words.containsKey(s) || (records.containsKey(s) && words.get(s) <= records.get(s))){
    				break;
    			}
    			records.put(s, records.containsKey(s)? records.get(s)+1:1);	
    		}
    		
    		if(count == L.length){//
    			result.add(i);
    		}
    	}
    	return result;
    }

	public List<Integer> findSubstring_2016_07(String s, String[] words) {
		List<Integer> result  = new ArrayList<>();
		int totalLength = words.length * words[0].length();
		for(int i = 0,j=totalLength-1; i<=j && j < s.length();){
			if(exactContern(s.substring(i, j+1), words)){
				result.add(i);
			}
			i ++;
			j ++;
		}
		return result;
	}
	private boolean exactContern(String s, String[] words){
		StringBuilder sb = new StringBuilder().append(s);
		for(String target: words){
			int index = -1;
			String existing = sb.toString();
			for(int i=0; i<=existing.length()-target.length(); i += target.length()){
				if(existing.substring(i, i+target.length()).equals(target)){
					index = i;
					break;
				}
			}
			if(index == -1) return false;

			sb.setLength(0);
			sb.append(existing.substring(0, index)).append(existing.substring(index+target.length()));
		}
		return sb.toString().length() == 0;

	}
    public static void main(String[] args){
    	SubstringwithConcatenationofAllWords s1 = new SubstringwithConcatenationofAllWords();
    	String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
    	String[] L = {"fooo","barr","wing","ding","wing"};
    }
}
