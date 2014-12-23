import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> dict= new HashMap<Character, Integer>();
		dict.put('C', 100);
		dict.put('I', 1);
		dict.put('M', 1000);
		dict.put('V', 5);
		dict.put('X', 10);
		dict.put('D', 500);
		dict.put('L', 50);
		
		int length = s.length();
		
		int i = 0;
		int val = 0;
		while(i < length){
			if(i != length -1 && dict.get(s.charAt(i)) < dict.get(s.charAt(i+1))){
				val = val + dict.get(s.charAt(i+1)) - dict.get(s.charAt(i));
				i += 2;
				continue;
			}
			
			val += dict.get(s.charAt(i));
			i++;
		}
		return val;
	}
}
