import java.util.ArrayList;
import java.util.List;

public class WildMatch {
	public boolean isMatchSlow(String s, String p) {
		if (s.equals(p)){
			return true;
		}
		
		return isMatchSlow(s, 0, p, 0);
	}
	
	public boolean isMatchSlow(String s, int s_start, String p, int p_start){
		if(s_start >= s.length()){
			if(p_start >= p.length()){
				return true;
			}
			
			for(int i = p_start; i< p.length(); i++){
				if (p.charAt(i) != '*'){
					return false;
				}
			}
			return true;
		}
		
		int s_index = s_start;
		
		
		boolean star = false;
		int ask_count = 0;
		for(int i= p_start; i< p.length(); i++){
			if(p.charAt(i) == '*'){
				star = true;
				continue;
			}
			if(p.charAt(i) == '?'){
				ask_count ++;
				continue;
			}
			
			if(s.length() - s_index < ask_count){
				return false;
			}else{
				s_index += ask_count;
				ask_count = 0;
			}
			if(star){
				List<Integer> candidate = new ArrayList<Integer>();
				
				for(int j = s_index; j<s.length(); j++){
					if(s.charAt(j) == p.charAt(i)){
						candidate.add(j);
					}
				}
				
				for(Integer index: candidate){
					if(isMatch(s, index+1,p, i+1)){
						return true;
					}
				}
				return false;
			}else{
				if(s_index >= s.length()){
					return false;
				}
				if(s.charAt(s_index) != p.charAt(i)){
					return false;
				}
				s_index ++;
			}
		}
		
		
		if(s.length() - s_index < ask_count){
			return false;
		}
		
		if(!star && s.length() - s_index > ask_count){
			return false;
		}
		return true;
	}
	
	
	public boolean isMatchInner(String s, String p){
		System.out.println(p);
		if (s.length() < p.length()){
			return false;
		}
		for(int i=0; i< p.length(); i++){
			if(p.charAt(i) != '?' && s.charAt(i) != p.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	public boolean isMatch(String s, String p) {
		if(p.length() ==0 ){
			return true;
		}
		String[] parts = p.split("\\*+");
		boolean checkFirst = p.charAt(0) == '*'? false: true;
		boolean checkLast = p.charAt(p.length()-1) == '*'? false: true;
		int s_index = 0;
		for(int i =0; i< parts.length; i++){
			
			if(checkFirst && i ==0){
				if(s.length() < parts[i].length()){
					return false;
				}
				if ( !isMatchInner(s.substring(0, parts[i].length()), parts[i])){
					return false;
				}
				s_index += parts[i].length();
				continue;
			}
			
			if(checkLast &&i == parts.length-1 && parts.length > 1){
				if(s.length() - s_index < parts[i].length()){
					return false;
				}
				
				if(!isMatchInner(s.substring(s.length() - parts[i].length(), s.length()), parts[i])){
					return false;
				}
				s_index = s.length();
				continue;
			}
			boolean match = false;
			System.out.println(s_index);
			System.out.println(i);
			for(int j = s_index; j <= s.length() - parts[i].length(); j++){
				if(j+parts[i].length() > s.length()){
					return false;
				}
				if(isMatchInner(s.substring(j, j+parts[i].length()), parts[i])){
					match = true;
					s_index = j+ parts[i].length();
					break;
				}
			}
			
			if (!match){
				return false;
			}
		}
		
		if(checkLast && s_index < s.length()){
			return false;
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		WildMatch s1 = new WildMatch();
		String s = "mississippi";
		String p = "m*i*si*si*si*pi";
		System.out.println(s1.isMatch(s, p));
	}
}
