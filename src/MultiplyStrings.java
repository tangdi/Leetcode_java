import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
	 public String multiply(String num1, String num2) {
	        List<String> list = new ArrayList<String>();
	        if("0".equals(num1) || "0".equals(num2)){
	            return "0";
	        }
	        char[] num2Digits = num2.toCharArray();
	        StringBuilder builder = new StringBuilder();
	        
	        for(int i = num2Digits.length -1; i>=0; i--){
	            builder.setLength(0);
	            char[] num1Digits = num1.toCharArray();
	            int carry = 0;
	            for(int j = num1Digits.length-1; j>=0; j--){
	                int product = (num2Digits[i] - '0') * (num1Digits[j] - '0') + carry;
	                num1Digits[j] = (char)((int)'0' + product % 10);
	                carry = product /10;
	            }
	            
	            if(carry != 0){
	                builder.append(carry);
	            }
	            
	            for(char c: num1Digits){
	                builder.append(c);
	            }
	            
	            int times = num2Digits.length -1 - i;
	            
	            while(times -- > 0){
	                builder.append('0');
	            }
	            list.add(builder.toString());
	        }
	        
	        String sum = list.get(list.size()-1);
	        for(int i = list.size() - 2; i>=0; i--){
	            sum = add(sum, list.get(i));
	        }
	        
	        return sum;
	        
	    }
	    
	    public String add(String num1, String num2){
	        StringBuilder builder = new StringBuilder();
	        
	        char[] num1Digits = num1.toCharArray();
	        char[] num2Digits = num2.toCharArray();
	        
	        char[] longer = null;
	        char[] shorter = null;
	        int carry = 0;
	        if(num1Digits.length > num2Digits.length){
	            longer = num1Digits;
	            shorter = num2Digits;
	        }else{
	            longer = num2Digits;
	            shorter = num1Digits;
	        }
	        
	        int i = 0;
	        while(i < longer.length ){
	            int sum = 0;
	            if( i >= shorter.length){
	                if(carry == 0){
	                    break;
	                }
	                 sum = (longer[longer.length - 1 - i] - '0') + carry;
	            } else {
	            sum = (longer[longer.length - 1 - i] - '0') +  (shorter[shorter.length - 1- i] - '0') + carry;
	                
	            }
	            longer[longer.length - 1 -i] = (char)((int)'0' + sum % 10);
	            carry = sum / 10;
	            i ++;
	        }
	        if(carry != 0){
	            builder.append('1');
	        }
	        
	        for(char c: longer){
	            builder.append(c);
	        }
	        return builder.toString();
	        
	        
	    }
	    
	    public static void main(String[] args) {
			MultiplyStrings s1 = new MultiplyStrings();
			String num1= "123";
			String num2 = "11";
			System.out.println(s1.multiply(num1, num2));
		}
}
