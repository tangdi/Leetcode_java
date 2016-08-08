/**
 * ClassName: SearchA2DMatrixII Function: TODO
 *
 * @Author: dtang
 * @Date: 8/6/16, 11:10 AM
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int rows = matrix.length;
        if(rows ==0) return false;
        int cols = matrix[0].length;
        if(cols ==0) return false;

        for(int row = rows-1, col = 0; row >=0 && col <cols; ){
            if (matrix[row][col] == target){
                return true;
            }
            if (matrix[row][col] < target){
                col ++;
            }else{
                row--;
            }

        }
        return false;


    }
}
