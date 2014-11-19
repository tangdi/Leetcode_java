import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class WordLadder {
	 public int ladderLength(String start, String end, HashSet<String> dict) {
		 
	        if (dict.size() == 0)  
	            return 0; 
	 
	        LinkedList<String> wordQueue = new LinkedList<String>();
	        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
	        dict.add(end);
	        wordQueue.add(start);
	        distanceQueue.add(1);
	 
	 
	        while(!wordQueue.isEmpty()){
	            String currWord = wordQueue.pop();
	            Integer currDistance = distanceQueue.pop();
	 
	            if(currWord.equals(end)){
	                return currDistance;
	            }
	            
	            for(int i=0; i<currWord.length(); i++){
	            	char[] currCharArr = currWord.toCharArray();
	                for(char c='a'; c<='z'; c++){
	                    currCharArr[i] = c;
	                    String newWord = new String(currCharArr);
	                    if(dict.contains(newWord)){
	                        wordQueue.add(newWord);
	                        distanceQueue.add(currDistance+1);
	                        dict.remove(newWord);
	                    }
	                }
	            }
	        }
	 System.out.println("not found");
	        return 0;
	    }
	public static void main(String[] args) {
		WordLadder s1 = new WordLadder();
		String start = "hit";
		String end = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log" };
		HashSet<String> dict = new HashSet<String>(Arrays.asList(words));
		System.out.println(s1.ladderLength(start, end, dict));
	}

}
