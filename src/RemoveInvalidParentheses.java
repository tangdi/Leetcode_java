import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: RemoveInvalidParentheses Function: TODO
 *
 * @Author: dtang
 * @Date: 8/6/16, 4:33 PM
 */
public class RemoveInvalidParentheses {
    List<String> result = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        if(s==null) return result;
        int[] invalids = findInvalidLeftPare(s);
        stripInvalid(s, invalids[0], invalids[1], 0);
        return result;
    }
    public void stripInvalid(String s, int invalidLeft, int invalidRight, int start){
        if(invalidLeft == 0 && invalidRight == 0){
            if(isValid(s)){
                if(!result.contains(s))
                    result.add(s);
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<s.length(); i++){
            String target = s.substring(i, i+1);

            if(target.equals("(") && invalidLeft >0 ){
                stripInvalid(s.substring(0, i) + s.substring(i+1), invalidLeft-1, invalidRight, s.substring(0, i).length());
            }else if(target.equals(")") && invalidRight >0){
                stripInvalid(s.substring(0, i) + s.substring(i+1), invalidLeft, invalidRight-1, s.substring(0, i).length());
            }
        }
    }
    public int[] findInvalidLeftPare(String s){
        int[] invalids = {0, 0};
        Stack<String> stack = new Stack<>();
        int countRight = 0;
        for(int i=0; i< s.length(); i++){
            String target = s.substring(i, i+1);
            if(target.equals("(")){
                stack.add("(");
            }else if(target.equals(")")){
                if(!stack.empty()){
                    stack.pop();
                }else{
                    countRight ++;
                }
            }
        }
        invalids[0] = stack.size();
        invalids[1] = countRight;
        return invalids;
    }
    public boolean isValid(String s){
        Stack<String> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            String target = s.substring(i, i+1);
            if(target.equals("(")){
                stack.add("(");
            }else if(target.equals(")")){
                if(!stack.empty()) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.size() ==0;
    }
}
