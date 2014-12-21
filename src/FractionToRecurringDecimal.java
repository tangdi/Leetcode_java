import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
		if(numerator == denominator) return "1";
		
		boolean negative = (numerator <0 && denominator >0) || (numerator >0 && denominator < 0)? true: false;
		
		StringBuilder builder = new StringBuilder();
		
		long beforeDot = (long)numerator / denominator;
		long afterDot =  numerator % denominator;
		
		if(negative && beforeDot == 0){
			builder.append("-");
			System.out.println("yes");
		}
		System.out.println(beforeDot);
		afterDot = Math.abs(afterDot);
		//System.out.println(afterDot);
		
		builder.append(beforeDot);
		if(afterDot ==0){
			return builder.toString();
		}
		builder.append('.');
		
		
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		StringBuilder builder_after = new StringBuilder();
		int index = 0;
		do{
			
			
			map.put(afterDot, index);
			int zeroes = 0;
			while(true){
				afterDot *= 10;
				if(afterDot >= denominator){
					break;
				}
				zeroes ++;
			}
			
			for(int i = 0; i<zeroes; i++){
				builder_after.append('0');
			}
			builder_after.append(Math.abs(afterDot/denominator));
			afterDot %= denominator;
			index += 1+zeroes;
		}while(afterDot !=0 && (!map.containsKey(afterDot)));
		
		if(!map.containsKey(afterDot)){
			builder.append(builder_after.toString());
			return builder.toString();
			//return negative? "-"  + builder.toString(): builder.toString();
		}
		//System.out.println(afterDot);
		index = map.get(afterDot);
		//System.out.println(map);
		String str= builder_after.toString();
		builder.append(str.substring(0, index) + "(" + str.substring(index) + ")");
		return builder.toString();
		//return negative? "-"  + builder.toString(): builder.toString();
    }
	
	public static void main(String[] args) {
		FractionToRecurringDecimal s1 = new FractionToRecurringDecimal();
		int numerator = Integer.MIN_VALUE;
		int denominator = -1;
		System.out.println(s1.fractionToDecimal(numerator, denominator));
	}
}
