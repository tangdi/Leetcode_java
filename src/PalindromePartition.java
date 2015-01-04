import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		helper(s, result, new ArrayList<String>());
		return result;
	}
	
	public boolean isPalindrome(String s){
		for(int i=0, j=s.length()-1; i<j; j--, i++){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}
	public void helper(String s, List<List<String>> result, List<String> list){
		if(s.length() == 0){
			result.add(new ArrayList<String>(list));
		}
		for(int i = 1;i <=s.length(); i++){
			if(isPalindrome(s.substring(0, i))){
				list.add(s.substring(0,i));
				helper(s.substring(i), result, list);
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		PalindromePartition s1 = new PalindromePartition();
		String s = "aab";
		System.out.println(s1.partition(s));
	}
}
