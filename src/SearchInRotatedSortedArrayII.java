
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int start, int end, int target) {
	    	if (start > end)
		return false;
	if (start == end) {
		if (A[start] == target) {
			return true;
		} else {
			return false;
		}
	}
	
	int middle = start + (end-start)/2;
	if(A[middle] == target) return true;
	if (A[middle]>target){
		return search(A, start, middle-1, target);
	}
	return search(A, middle+1, end, target);
}
	  public boolean search(int[] A, int target) {
		  int pivot = 0;
			for (int i = 0; i < A.length - 1; i++) {
				if (A[i] > A[i + 1]) {
					pivot = i + 1;
				}
			}
			if (pivot ==0){
				return search(A, 0 , A.length-1, target);
			}
			
		
			return search(A, 0, pivot-1, target) || search(A, pivot, A.length-1, target);
	    }
}
