public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int [] C = new int[m+n];
		int i = 0;
		int j = 0;
		int z = 0;
		while(i<m && j<n){
			if(A[i]<B[j]){
				C[z++]=A[i++]; 
			}else{
				C[z++]=B[j++];
			}
		}
		
		if (i<m){
			while(i<m){
				C[z++] = A[i++];
			}
		}else{
			while(j<n){
				C[z++] = B[j++];
			}
		}
		
		for(int d=0; d<C.length;d++){
			A[d]=C[d];
		}
	}
}
