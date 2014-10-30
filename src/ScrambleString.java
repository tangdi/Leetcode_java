import java.util.Arrays;





public class ScrambleString {
	
	  public static boolean isScramble(String s1, String s2) {
		  if(s1.length() != s2.length()){
			  return false;
		  }
		  if(s1.equals(s2)){
			  return true;
		  }
		  char[] s1_char = s1.toCharArray();
		  char[] s2_char = s2.toCharArray();
		  //System.out.println(s1_char);
		  
		  Arrays.sort(s1_char);
		  Arrays.sort(s2_char);
		  
		  if(!new String(s1_char).equals(new String(s2_char))){
			  return false;
		  }
		  
		  int len = s1.length();
		  
		  for (int i=1; i<len; i++){
			  String s11 = s1.substring(0, i);
			  String s12 = s1.substring(i);
			  
			  
			  
			  String s21 = s2.substring(0,i);
			  String s22 = s2.substring(i);
			  
			  if(isScramble(s11, s21)&&(isScramble(s12, s22))){
				  return true;
			  }
			  
			  s21 = s2.substring(0, len-i);
			  s22 = s2.substring(len-i);
			  
			  if(isScramble(s11, s22)&&(isScramble(s12, s21))){
				  return true;
			  }
		  }
		  return false;
		  

	    }
	  
	  public static boolean isScrambleDP(String s1, String s2){
		  if(s1.length() != s2.length()){
			  return false;
		  }
		  if(s1.equals(s2)){
			  return true;
		  }
		  
		  s1.
		  
		  
	  }
	  
	  public static void main(String[] args){
		  
		  String s1 = new String("great");
		  
		  String s2 = new String("tgrea");
		  
		  
		  
		  System.out.println(isScramble(s1,s2));
		  
	  }

}
