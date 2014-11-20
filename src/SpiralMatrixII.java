
public class SpiralMatrixII {
	public int value;
	public int[][] generateMatrix(int n) {
		
		int[][] result = new int[n][n];
		if (n<1){
			return result;
		}
		value =1;
		int counter = (n-1) / 2;
		System.out.println(counter);
		for (int i = 0; i <= counter; i++) {
			helper(result, i, n);
		}

		return result;
    }
	
	public void helper(int[][] matrix, int counter, int n) {
		for (int i = counter; i <= n - counter - 1; i++) {
			matrix[counter][i] = value++;
		}
		if(n - 2*counter==1){
			return;
		}
		for (int i = counter + 1; i <= n - counter - 1; i++) {
			
			matrix[i][n - counter - 1] = value++;
		}
		
		if(n - 2*counter ==1){
			return;
		}

		for (int i = counter + 1; i <= n - counter - 1; i++) {
			
			matrix[n - counter - 1][n - 1 - i] = value++;
		}

		for (int i = counter + 1; i < n - counter - 1; i++) {
			
			matrix[n - i - 1][counter] = value++;
			
		}
	}
}
