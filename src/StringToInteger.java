public class StringToInteger {
	public int atoi(String str) {
		 if (str == null || str.trim().length() ==0){
	            return 0;
	        }
		 
		 char[] chars = str.trim().toCharArray();
		 
		 
		 boolean positive = true;
		 int val = 0;
		 for(int i=0; i<chars.length; i++){
			 if(i==0){
				 if(chars[0] == '-'){
					 positive = false;
					 continue;
				 }
				 if(chars[0] == '+'){
					 continue;
				 }
			 }
			 if(chars[i] > '9' || chars[i] < '0'){
				 return val;
			 }
			 
			 if(positive){
				 if(val > Integer.MAX_VALUE/10){
					 return Integer.MAX_VALUE;
				 }
				 if(val == Integer.MAX_VALUE/10 && (chars[i] - '0' > 7) ){
					 
						 return Integer.MAX_VALUE;
					
				 }
				 
				 
				 val *= 10;
				 val += chars[i] - '0';
			 }else{
				 if(val < Integer.MIN_VALUE/10){
					 return Integer.MIN_VALUE;
				 }
				 
				 if(val == Integer.MIN_VALUE/10 && (chars[i] - '0' >8)){
					 return Integer.MIN_VALUE;
				 }
				 val *= 10;
				 val -= chars[i] - '0';
			 }
		 }
		 return val;
		 
	}
}
