import java.util.Arrays;
import java.util.Comparator;

public class LongestCommoPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		if (strs.length == 1) return strs[0];
		
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				if (arg0.length() == arg1.length()) {
					return 0;
				}
				
				if(arg0.length() < arg1.length()){
					return -1;
				}
				
				return 1;
			}
		});
		
		int largestPossible = strs[0].length();
		StringBuilder result = new StringBuilder();
		
		outer:for(int i=0;i<largestPossible; i++){
			char target = strs[0].charAt(i);
			for (int j = 1; j< strs.length; j++ ){
				if(strs[j].charAt(i) != target){
					break outer;
				}
			}
			result.append(target);
		}
		
		return result.toString();
	}

}
