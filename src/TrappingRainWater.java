
public class TrappingRainWater {
	int result;
	 public int trap(int[] A) {
		 if(A.length<=2 || A==null){
			 return 0;
		 }
		 result = 0;
		 helper(A, 0);
		 return result;
	        
	    }
	 
	 	
	 
	 public void helper(int[] A, int start){
		 System.out.println("start is " + start);
		 System.out.println(result);
		 if(start >= A.length-1) return;
		 
		 if(A[start]<=A[start+1]){
			 helper(A, start+1);
			 return;
		}
		 
		 int left_border = A[start];
		 int right_border = A[start+1];
		 
		 int min = Integer.MAX_VALUE;
		 int border_index = -1;
		 for(int i=start+1; i<A.length;i++){
			 
			
			 
			 
			 if(A[i] >= right_border){
				 border_index = i;
				 right_border = Math.max(A[i], right_border);
				 continue;
			 }
			 
			 if(A[i]>=A[start] || right_border>=left_border){
				 break;
			 }
			 if(A[i] < min){
				 min = A[i];
				 continue;
			 }
			 
			 
		 }
		 if(border_index==-1){
			 helper(A, start+1);
		 }else{
			 for(int i=start+1; i<border_index; i++){
				 int border = Math.min(left_border, right_border);
				 if(A[i]>border) continue;
				 result += border-A[i];
			 }
			 helper(A, border_index);
		 }	 
	 }
	 
	 public static void  main(String[] args){
		 TrappingRainWater s1 = new TrappingRainWater();
		 int [] A= {4,2,3,5,1,9,9,6};
		 System.out.println(s1.trap(A));
	 }
}
