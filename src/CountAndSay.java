
public class CountAndSay {
	public String countAndSay(int n) {
        String s = "1";
       StringBuilder sb = new StringBuilder();
       while(n>1){
           sb.setLength(0);
           char comparator= s.charAt(0);
           int count = 1;
           for(int i=1; i<s.length();i++){
              if(s.charAt(i) == comparator){
            	  count ++;
              }
              else{
               sb.append(count);
               sb.append(s.charAt(i-1));
               count = 1;
               comparator = s.charAt(i);
              }
           }
          sb.append(count);
          sb.append(comparator);
          n--;
          s = sb.toString();
       }
       return s;
    }
	
	public static void main(String[] args) {
		CountAndSay s1 = new CountAndSay();
		int n =4;
		System.out.println(s1.countAndSay(1));
	}
}
