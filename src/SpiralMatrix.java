import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	List<Integer> result;

	public List<Integer> spiralOrder(int[][] matrix) {
		result = new ArrayList<Integer>();
		if (matrix == null || matrix.length ==0 || matrix[0].length==0)
			return result;

		int m = matrix.length;
		int n = matrix[0].length;

		int counter = (Math.min(m, n) - 1) / 2;
		System.out.println(counter);
		for (int i = 0; i <= counter; i++) {
			helper(matrix, i, m, n);
		}

		return result;
	}

	public void helper(int[][] matrix, int counter, int m, int n) {
		for (int i = counter; i <= n - counter - 1; i++) {
			result.add(matrix[counter][i]);
			System.out.println(result);
		}
		if(m - 2*counter==1){
			return;
		}
		for (int i = counter + 1; i <= m - counter - 1; i++) {
			result.add(matrix[i][n - counter - 1]);
			
		}
		
		if(n - 2*counter ==1){
			return;
		}

		for (int i = counter + 1; i <= n - counter - 1; i++) {
			System.out.println("yes");
			result.add(matrix[m - counter - 1][n - 1 - i]);
			
		}

		for (int i = counter + 1; i < m - counter - 1; i++) {
			
			result.add(matrix[m - i - 1][counter]);
			
		}
	}

	public static void main(String[] args) {
		SpiralMatrix s1 = new SpiralMatrix();
		//int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		//int[][] matrix = { { 2, 3 } };
		int[][] matrix = { { 1, 2, 3,4 }, { 5, 6,7,8 }, { 9,10,11,12 } };
		
		System.out.println(s1.spiralOrder(matrix));

	}
}
