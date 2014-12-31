
public class InterleaveString {
	 
	 public boolean isInterleave(String s1, String s2, String s3) {
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
			result = isInterleave(s1.substring(1), s2, s3.substring(1));
		}
		if(result){
			return result;
		}
		
		if(s2.charAt(0) == s3.charAt(0)){
			result = isInterleave(s1, s2.substring(1), s3.substring(1));
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
