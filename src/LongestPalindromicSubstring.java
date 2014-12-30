
public class LongestPalindromicSubstring {
	 public String findPalindrome(String s, int c_left , int c_right){
			int left = c_left -1;
			int right = c_right+1;
			while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
				left --;
				right ++;
			}
			System.out.println(right);
			return s.substring(left+1, right);
		}
		public String longestPalindrome(String s) {
	        if (s.length() <= 2){
	        	return s;
	        }
	        
	        
	        String longest = s.substring(0, 1);
	        for(int i=0; i<s.length()-1; i++){
	        	String s1 = findPalindrome(s, i, i);
	        	if(s1.length() > longest.length()){
	        		longest = s1;
	        	}
	        	if(s.charAt(i) == s.charAt(i+1)){
	        	s1 = findPalindrome(s, i, i+1);
	        	if(s1.length() > longest.length()){
	        		longest = s1;
	        	}
	        	}
	        }
	        
	        return longest;
	    }
		
		public static void main(String[] args) {
			LongestPalindromicSubstring s1 = new LongestPalindromicSubstring();
			String s = "abb";
			System.out.println(s1.longestPalindrome(s));
		}
}
