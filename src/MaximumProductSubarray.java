public class MaximumProductSubarray {
	public int maxProductBF(int[] A) {
		if (A == null || A.length <= 0)
			return 0;
		if (A.length == 1)
			return A[0];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++){
			int cumu = 1;
			
			for(int j=i;j<A.length;j++){
				cumu*=A[j];
				max = Math.max(max, cumu);
			}
		}
		return max;
	}
	
	  public int maxProduct(int A[]) {  
	        if(A==null||A.length==0) {  
	          return 0;  
	        }  
	        int maxProduct = A[0];  
	        int max_temp   = A[0];  
	        int min_temp   = A[0];  
	          
	        for(int i=1;i<A.length;i++) {  
	            int a = A[i]*max_temp;  
	            int b = A[i]*min_temp;  
	            max_temp = Math.max(Math.max(a,b), A[i]);  
	            min_temp = Math.min(Math.min(a,b), A[i]);  
	            maxProduct = Math.max(maxProduct, max_temp);  
	        }  
	        return maxProduct;  
	    }  
	
	public int maxProductDP(int A[]) {  
        if(A==null||A.length==0) {  
          return 0;  
        }  
        int[][] productArray =  new int[A.length][A.length];  
        int maxProduct = A[0];  
          
        for(int i=0;i<A.length;i++) {  
            for(int j=i;j<A.length;j++) {  
                if(j==i) {  
                    productArray[i][i] = A[i];  
                } else {  
                    productArray[i][j] = productArray[i][j-1]*A[j];  
                }  
                if(productArray[i][j]>maxProduct) {  
                    maxProduct = productArray[i][i];  
                }  
            }  
        }  
        return maxProduct;  
    }  


	public static void main(String[] args) {
		MaximumProductSubarray s1 = new MaximumProductSubarray();
		int[] A = { 8, 0, 2, 2};
		System.out.println(s1.maxProduct(A));
	}
}
