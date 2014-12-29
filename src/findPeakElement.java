
public class findPeakElement {
	 public int findPeakElement(int[] num) {
	     if(num.length == 1){
	    	 return 0;
	     }   
	     
	     for( int i =0;i < num.length ;i++){
	    	 int left;
	    	 int right;
	    	 if(i ==0){
	    		left = Integer.MIN_VALUE;
	    		right = num[1];
	    	 }else if(i == num.length-1){
	    		 left = num[num.length -2];
	    		 right = Integer.MIN_VALUE;
	    	 }else{
	    		 left = num[i-1];
	    		 right = num[i+1];
	    	 }
	    	 
	    	 if(left<num[i] && right < num[i]){
	    		 return i;
	    	 }
	     }
	     return -1;
	    }
}
