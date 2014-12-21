public class ValidNumber {
	public boolean isNumberWrong(String s) {
		if (s == null || s.trim().length() == 0) {
			return false;
		}
		char[] chars = s.trim().toCharArray();
		boolean isNumber = true;
		boolean point = false;
		boolean exponential = false;
		
		for(int i = 0; i< chars.length; i++){
			if(i == 0){
				if( chars[i] == '-' || chars[i] == '+' ){
					if(chars.length ==1){
						return false;
					}
					continue;
				}
				if(chars[i] == '.' ){
					if(chars.length ==1){
						return false;
					}
					point = true;
					continue;
				}
				if(chars[i] > '9' || chars[i] < '0'){
					return false;
				}
				continue;
			}
			
			if(chars[i] == '.'){
				if(point || exponential || i == chars.length-1){
					return false;
				}
				point = true;
				continue;
			}
			
			if(chars[i] == 'e'){
				if(exponential || i == chars.length-1){
					return false;
				}
				exponential = true;
				continue;
			}
			
			if(chars[i] == '-'){
				if(!(exponential && chars[i-1] == 'e') || i == chars.length-1){
					return false;
				}
				continue;
			}
			if(chars[i] > '9' || chars[i] < '0'){
				return false;
			}
			
			
			
		}
		
		return isNumber;
	}
	
	public boolean isNumber(String s){
		if (s == null || s.trim().length() == 0) {
			return false;
		}
		s = s.trim();
		String pattern = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?"; 
		if (s.matches(pattern)){
			return true;
		}else{
			return false;
		}
	}
}
