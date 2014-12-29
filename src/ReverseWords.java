
public class ReverseWords {
	 public String reverseWords(String s) {
	        String[] strs = s.split("\\s+");
	        StringBuilder sb = new StringBuilder();
	        
	        for(int i = strs.length-1; i>=0; i--){
	        	if(strs[i].length() ==0){
	        		continue;
	        	}
	            if(sb.length() > 0){
	            	sb.append(" ");
	            }
	            sb.append(strs[i]);
	        }
	        return sb.toString();
	        
	    }
	 
	 public static void main(String[] args) {
		ReverseWords s1 = new ReverseWords();
		String s = "the ";
		System.out.println(s1.reverseWords(s));
	}
}
