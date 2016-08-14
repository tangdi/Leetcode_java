/**
 * ClassName: ExpressionAddOperator Function: TODO
 *
 * @Author: dtang
 * @Date: 8/14/16, 6:01 PM
 */
public class ExpressionAddOperator {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num != null && num.length() >0){
            dfs("", num, 0, target, 0, 0);
        }
        return result;
    }

    public void dfs(String exp, String num, int start, int target, long cumu, long lastOperand){
        if(start == num.length()){
            if(cumu == target){
                result.add(exp);
            }
            return;
        }
        for(int i =start; i<num.length(); i++){
            if(i >start && num.charAt(start) == '0') break;
            String str = num.substring(start, i+1);
            Long curr = Long.parseLong(str);
            if(start ==0){
                dfs(str, num, i+1, target, curr, curr);
            }else{
                dfs(exp + "+" + str, num, i+1, target, cumu + curr, curr);
                dfs(exp + "-" + str, num, i+1, target, cumu - curr, -curr);
                dfs(exp + "*" + str, num, i+1, target, cumu - lastOperand + lastOperand * curr, lastOperand * curr);
            }
        }
        return;
    }
}
