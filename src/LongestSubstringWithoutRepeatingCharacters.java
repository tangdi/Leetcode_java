import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestSubstringWithoutRepeatingCharacters {
	 public int lengthOfLongestSubstring(String s) {
		 int longest = 0;
		 Map<Character, Integer> record = new HashMap<Character, Integer>();
		 int length = 0;
		 int last_head = 0;
		 for(int i =0; i<s.length();){
			// System.out.println(i);
			 char c = s.charAt(i);
			 if(! record.containsKey(c)){
				 length++;
				 record.put(c, i);
				 longest = Math.max(longest, length);
				 i++;
			 }else{
				 int temp = record.get(c)+1;
				 for(int j=last_head; j<temp; j++){
					 record.remove(s.charAt(j));
					 length --;
				 }
				 length ++;
				 record.put(c, i);
				 i++;
				 last_head = temp;
			 }
		 }
		 return longest;
	    }
	 
	 public static void main(String[] args){
		 LongestSubstringWithoutRepeatingCharacters s1 = new LongestSubstringWithoutRepeatingCharacters();
		 String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		 System.out.println(s1.lengthOfLongestSubstring(s));
	 }
}
