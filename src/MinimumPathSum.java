public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		if(height <=0 || width <=0){
			return 0;
		}
		
		int[][] result = new int[height][width];
		result [0][0] = grid[0][0];
		for(int i =1; i<height; i++){
			result[i][0] = result[i-1][0] + grid[i][0];
		}
		
		for(int i =1; i<width; i++){
			result[0][i] += result[0][i-1] + grid[0][i];
		}
		
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				result[i][j] = Math.min(result[i - 1][j],
						result[i][j - 1])+ grid[i][j];
			}
		}
		return result [height-1][width-1];
	}
}
