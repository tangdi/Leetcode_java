public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {

		if (A.length == 0 || A == null) {
			return 0;
		}
		int base = A[0];
		int del = 0;
		for (int i = 1; i< A.length; i++){
			if(A[i] == base){
				del++;
			}else{
				A[i-del] = A[i];
				base = A[i];
			}
		}
		return A.length - del;
	}
	public static void main(String[] args){
		RemoveDuplicatesfromSortedArray s1 = new RemoveDuplicatesfromSortedArray();
		int [] A = {1,2,2,2,3,3,4,5,5};
		System.out.println(s1.removeDuplicates(A));
		for(int i:A){
			System.out.print(i + ", ");
		}
	}

}

