
public class UniquePathsII {
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 if (obstacleGrid.length==0 || obstacleGrid == null){
			 return 0;
		 }
		 int height = obstacleGrid.length;
		 int width = obstacleGrid[0].length;
		 System.out.println(height +", "+ width);
	    int [][] dict = new int[height][width];
	    dict[0][0] = obstacleGrid[height-1][width-1] ==1? 0:1;
	    
	    for(int i=1; i<height;i++){
	    	dict[i][0] = obstacleGrid[height-1-i][width-1] == 1? 0: dict[i-1][0];
	    }
	    
	    for(int i=1; i<width;i++){
	    	dict[0][i] = obstacleGrid[height-1][width-1-i] == 1? 0: dict[0][i-1];
	    }
	    
	    for(int i=1 ; i < height; i++){
			 for(int j=1; j<width; j++){
				 dict [i][j] = obstacleGrid[height-1-i][width-1-j] == 1? 0: dict[i-1][j] + dict[i][j-1];
			 }
		 }
	    
	    for(int i=height-1 ; i >=0 ; i--){
			 for(int j=width-1; j>=0; j--){
				 System.out.print(dict[i][j]);
		 }
			 System.out.println("");
	    }
	    return dict[height-1][width-1];
}
	 
	 public static void main(String[] args){
		 UniquePathsII s1 = new UniquePathsII();
		/* int[][] obstacleGrid = {
		                         {0,0,0},
		                         {0,1,0},
		                         {0,0,0}
		 };*/
		 
		 int[][] obstacleGrid = {{0,0},{1,0}};
		 System.out.println(s1.uniquePathsWithObstacles(obstacleGrid));
	 }
}
