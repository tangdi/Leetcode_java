import java.util.ArrayList;
import java.util.List;


public class LetterCombinationOfPhoneNumber {
	 public List<String> letterCombinations(String digits) {
		 String trans[] = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		 List<String> result = new ArrayList<String>();
		 cascader(digits, 0, trans, result, "");
		 return result;
	 }
	 public void cascader(String digits, int index, String[] trans, List<String> result, String str){
		 if(index == digits.length()){
			 result.add(str);
			 return;
		 }
		 
		 int digit = digits.charAt(index) - '0';
		 
		 for(int i=0;i < trans[digit].length(); i++){
			 cascader(digits, index+1, trans, result, str + trans[digit].substring(i, i+1));
		 }
	 }
	 
	 public static void main(String[] args) {
		LetterCombinationOfPhoneNumber s1 = new LetterCombinationOfPhoneNumber();
		String digits = "23";
		System.out.println(s1.letterCombinations(digits));
	}
}
