
public class RegularExpression {
	
	public boolean isMatch(String s, String p) {
  
        return isMatch(s, 0, p, 0);
        
    }
	
	public boolean isMatch(String s, int s_start, String p, int p_start){
		if(s_start >= s.length()){
			if(p_start >= p.length()){
				return true;
			}
			
			for(int i = p_start; i< p.length(); ){
				if( i == p.length()-1){
					return false;
				}
				if(i < p.length()-1 && p.charAt(i+1) != '*'){
					return false;
				}
				
				i+=2;
			}
			return true;
		}
		if(p_start == p.length()-1){
			if((p.charAt(p_start) != '.' && p.charAt(p_start) != s.charAt(s_start)) || s_start != s.length()-1){
				return false;
			}
			return true;
		}
		
		if(p_start > p.length()-1){
			return false;
		}
		if (p.charAt(p_start+1) == '*'){
			if(p.charAt(p_start) == '.'){
				for(int i = s_start; i<= s.length(); i++){
					if(isMatch(s, i, p, p_start+2)){
						return true;
					}
				}
				return false;
			}
			
			if(isMatch(s, s_start, p, p_start+2)){
				return true;
			}
			
			for(int i = s_start; i<s.length(); i++){
				if(s.charAt(i) == p.charAt(p_start)){
					if(isMatch(s, i+1, p, p_start+2)){
						return true;
					}
					continue;
				}
				break;
			}
			return false;
		}
		if(p.charAt(p_start) == '.' || p.charAt(p_start) == s.charAt(s_start)){
			return isMatch(s, s_start +1, p, p_start+1);
		}
		return false;
		
		
	}
	
	public static void main(String[] args) {
		RegularExpression s1 = new RegularExpression();
		String s = "aa";
		String p = ".*";
		System.out.println(s1.isMatch(s, p));
	}
}
