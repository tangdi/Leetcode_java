
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
       
        for(String str: tokens){
            if ("*".equals(str)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
                continue;
            }
             if ("-".equals(str)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
                continue;
            }
             if ("+".equals(str)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
                continue;
            }
             if ("/".equals(str)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
                continue;
            }
            stack.push(Integer.valueOf(str));
        }
        return stack.pop();
    }
}
