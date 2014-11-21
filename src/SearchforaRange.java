
public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
    	
    	int [] result = new int[2];
    	result[0] = -1;
    	result[1] = -1;
    	
    	if(A.length ==0 || A ==null){
    		return result;
    	}
    	int start = 0;
    	int end = A.length-1;
    	helper(A, target, result, start, end);
    	return result;

        
    }
    
    public void helper(int[]A , int target, int[] result, int start ,int end){
    	if(start>end){
    		return;
    	}
    	int median = (start +end)/2;

    	if(A[median] == target){
    		result[0] = result[0] == -1? median: Math.min(median, result[0]);
    		result[1] = result[1] == -1? median: Math.max(median, result[1]);
    		helper(A, target, result, start, median-1);
    		helper(A, target, result, median+1, end);
    		return;
    	}
    	if(A[median] > target){
			helper(A, target, result, start, median-1);
		}
    	helper(A, target, result, median+1, end);
    }
}
