import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class LongestValidParentheses {
	 public int longestValidParentheses(String s) {
	       int longest = 0;

	       Deque<Integer> leftParenthese = new LinkedList<Integer>();
	       int start = 0;
	       
	       for(int i= 0; i<s.length(); i++){
	    	   if(s.charAt(i) == '('){
	    		   leftParenthese.push(i);
	    		   continue;
	    	   }
	    	   if(leftParenthese.isEmpty()){
	    		   start = i +1;
	    		   continue;
	    	   }
	    	   leftParenthese.poll();
	    	   longest = Math.max(longest, leftParenthese.isEmpty()? i -start+1: i- leftParenthese.peek() );
	    	   
	    	   
	       }
	       
	       return longest;
	    }
	 
	 public static void main(String[] args) {
		LongestValidParentheses s1 = new LongestValidParentheses();
		String s = "()()";
		System.out.println(s1.longestValidParentheses(s));
	}
}
