
public class PlusOne {
	 public int[] plusOne(int[] digits) {
		 boolean addOneDigit = false;
	        for(int i = digits.length-1; i>= 0;i --){
	        	if(digits[i]+1 == 10){
	        		digits[i] = 0;
	        		if (i == 0){
	        			addOneDigit = true;
	        		}
	        		continue;
	        	}else{
	        		digits[i]++;
	        		break;
	        	}
	        }
	        
	     if (addOneDigit){
	    	 int [] newDigits = new int[digits.length+1];
	    	 newDigits[0] = 1;
	    	 for(int i=1; i<digits.length+1;i++){
	    		 newDigits[i] = digits[i-1];
	    	 }
	    	 return newDigits;
	     }
	     
	     return digits;
	    }
}
