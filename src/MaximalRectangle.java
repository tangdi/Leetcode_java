import java.util.LinkedList;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int max = 0;
		if (matrix.length == 0 || matrix[0].length == 0) {
			return max;
		}

		int[][] heightMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0) {
						heightMatrix[i][j] = 1;
					} else {
						heightMatrix[i][j] = heightMatrix[i - 1][j] + 1;
					}
				} else {
					heightMatrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			max = Math.max(max, largestHist(heightMatrix[i]));
		}

		return max;
	}

	public int largestHist(int[] height) {
		int max = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();

		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
				int top = stack.pop();
				max = Math.max(max, height[top]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			max = Math.max(max,
					height[top]
							* (stack.isEmpty() ? height.length : height.length
									- stack.peek() - 1));
		}
		return max;
	}

}
