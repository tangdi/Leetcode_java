
public class InterleaveString {
	
	 public boolean isInterleave(String s1, String s2, String s3) {
		 if(s3.length() != s2.length() + s1.length()){
			 return false;
		 }
		 
		 boolean [][] interLeave = new boolean[s1.length() + 1][s2.length()+1];
		 
		 for(int i = 0; i<s1.length()+1; i++){
			 for(int j=0; j<s2.length()+1; j++){
				 if(i ==0 && j==0){
					 interLeave[i][j] = true;
					 continue;
				 }
				 
				 if(i ==0 && s3.charAt(j+i-1) == s2.charAt(j-1)){
					 interLeave[i][j] = interLeave [i][j-1];
					 continue;
				 }
				 
				 if(j ==0 && s3.charAt(j+i-1) == s1.charAt(i-1)){
					 interLeave[i][j] = interLeave [i-1][j];
					 continue;
				 }
				 
				 if( i>= 1 && j >=1 && s3.charAt(i + j -1) == s2.charAt(j-1) && s3.charAt(i + j -1) != s1.charAt(i-1)){
					 interLeave[i][j] = interLeave[i][j-1];
					 continue;
				 }
				 
				 if(i>= 1 && j >=1 && s3.charAt(i + j -1) == s1.charAt(i-1) && s3.charAt(i + j -1) != s2.charAt(j-1)){
					 interLeave[i][j] = interLeave[i-1][j];
					 continue;
				 }
				 
				 if(i>= 1 && j >=1 && s3.charAt(i + j -1) == s1.charAt(i-1) && s3.charAt(i + j -1) == s2.charAt(j-1)){
					 interLeave[i][j] = interLeave[i-1][j] || interLeave[i][j-1] ;
					 continue;
				 }
				 interLeave[i][j] = false;		 
				 
				 
			 }
		 }
		
		return interLeave[s1.length()][s2.length()];
	 }
	 
	 public boolean isInterleaveSLOW(String s1, String s2, String s3) {
		 if(s3.length() != s2.length() + s1.length()){
			 return false;
		 }
		 if(s1.length() ==0){
			 return s2.equals(s3);
		 }
		 if(s2.length() ==0 ){
			 return s1.equals(s3);
		 }
		 
		boolean result = false; 
		if(s1.charAt(0) == s3.charAt(0)){
			result = isInterleaveSLOW(s1.substring(1), s2, s3.substring(1));
		}
		if(result){
			return result;
		}
		
		if(s2.charAt(0) == s3.charAt(0)){
			result = isInterleaveSLOW(s1, s2.substring(1), s3.substring(1));
		}
		
		return result;
	 }
	 
	 public static void main(String[] args) {
		InterleaveString s = new InterleaveString();
		
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.out.println(s.isInterleave(s1, s2, s3));
	}
}
