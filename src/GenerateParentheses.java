import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(n, 0, result, "", 0, 0);
        return result;
        
    }
	
	
	
	public void helper(int n, int deep, List<String> result, String s, int left, int right){
		System.out.println(s);
		if(2*n == deep){
			result.add(s);
			return;
		}
		if(left<n){
			helper(n, deep + 1, result, s + "(", left +1, right);
        }
		
		if(right<left){
			helper(n, deep +1, result, s +")", left, right + 1);
		}
	}
		
		
		
        
	
	public static void main(String[] args) {
		GenerateParentheses s1 = new GenerateParentheses();
		System.out.println(s1.generateParenthesis(4));
	}
}
