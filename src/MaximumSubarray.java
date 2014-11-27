public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int temp = A[0];
		for (int i = 1; i < A.length; i++) {
			temp = A[i] + Math.max(0, temp);
			// temp += Math.max(0, A[i]);
			max = Math.max(max, temp);
		}
		return max;
	}

	public static void main(String[] args){
		 MaximumSubarray s1 = new MaximumSubarray();
		 int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(s1.maxSubArray(A));
		 
	 }
}
