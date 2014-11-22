public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int n = matrix.length;
		int counter = (n-1) / 2;
		for (int i = 0; i <= counter; i++) {
			helper(matrix, n, i);
		}

	}

	public void helper(int[][] matrix, int n, int counter) {

		if (n - 2 * counter == 1) {
			return;
		}

		for (int i = counter; i < n - counter - 1; i++) {
			int temp = matrix[i][n-counter-1];
			matrix[i][n-counter-1] = matrix[counter][i];
			int temp2 = matrix[n-counter-1][n-1-i];
			
			matrix[n-counter-1][n-1-i] = temp;
			
			int temp3 = matrix[n-1-i][counter];
			matrix[n-1-i][counter] = temp2;
			
			matrix[counter][i] = temp3;
		}
	}
}
