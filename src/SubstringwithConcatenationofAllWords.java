import java.util.ArrayList;
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
    	
    	
    }
    
    public static void main(String[] args){
    	SubstringwithConcatenationofAllWords s1 = new SubstringwithConcatenationofAllWords();
    	String S = "barfoothefoobarman";
    	String[] L = {"foo", "bar"};
    	System.out.println(s1.findSubstring(S, L));
    }
}
