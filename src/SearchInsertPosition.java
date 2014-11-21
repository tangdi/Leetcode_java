
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
      if(A==null || A.length ==0){
    	  return 0;
      }
		int start =0;
		int  end= A.length-1;
		
		while(true){
			
			if(start>end){
				return start;
			}
			int median = (start+end)/2;
			if (A[median] == target){
				return median;
			}
			
			if(A[median] > target){
				end = median-1;
				continue;
			}else{
				start = median+1;
				continue;
			}
		}
		
    }
}
