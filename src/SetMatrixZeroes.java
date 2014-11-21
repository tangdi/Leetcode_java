import java.util.HashSet;
import java.util.Set;


public class SetMatrixZeroes {
	 public void setZeroes(int[][] matrix) {
		
		 Set<Integer> cols = new HashSet<Integer>();
		 Set<Integer> rows = new HashSet<Integer>();
		 for (int i=0; i< matrix.length; i++){
			 for(int j = 0; j<matrix[0].length; j++){
				 if(matrix[i][j] == 0){
					 cols.add(j);
					 rows.add(i);	 
				 }
			 }
		 }
		 
		 for(int col: cols){
			 for(int i=0; i<matrix.length; i++){
				 matrix[i][col] = 0;
			 }
		 }
		 
		 for(int row: rows){
			 for (int i=0; i<matrix[0].length;i++){
				 matrix[row][i]=0;
			 }
		 }
		 
	        
	    }
}
