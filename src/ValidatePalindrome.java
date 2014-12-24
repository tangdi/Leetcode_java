public class ValidatePalindrome {
	public boolean isPalindrome(String s) {
	        if (s == null || s.trim().length() == 0 ){
	            return true;
	        }
	        
	        s = s.trim();
	        s = s.replaceAll("[^a-zA-Z0-9]", "");
	        s = s.toLowerCase();
	        for ( int i=0, j=s.length()-1; i<j; i++, j--){
	            if( s.charAt(i) != s.charAt(j)){
	                return false;
	            }
	            
	        }
	        return true;
	    }
}
