import java.util.ArrayList;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || "".equals(s)) {
			return 0;
		}
		ArrayList<Integer> spaceList = new ArrayList<Integer>();
		ArrayList<String> strList = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				spaceList.add(i);
				if (str.length() > 0){
					strList.add(str.toString());
				}
				str.setLength(0);
			} else{
				str.append(s.charAt(i));
				if(i == s.length()-1){
					strList.add(str.toString());
				}
			}
			
		}
		if (s.length() == spaceList.size()) {
			return 0;
		}
		return strList.get(strList.size()-1).length();

		
	}

}
