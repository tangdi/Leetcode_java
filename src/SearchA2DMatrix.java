/**
 * ClassName: SearchA2DMatrix Function: TODO
 *
 * @Author: dtang
 * @Date: 8/3/16, 11:00 PM
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int rows = matrix.length;
        if(rows == 0) return false;
        int cols = matrix[0].length;
        if(cols ==0) return false;
        int start = 0;
        int end = rows-1;

        int targetRow = -1;
        while(true){
            if(start>end){
                return false;
            }
            int mid = start  + (end-start)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][cols-1]){
                targetRow = mid;
                break;
            }
            if(matrix[mid][0] > target ){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        start = 0;
        end = cols -1;

        while(true){
            if(start>end){
                return false;
            }
            int mid = start  + (end-start)/2;
            if(matrix[targetRow][mid] == target){
                return true;
            }
            if(matrix[targetRow][mid] > target ){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

    }
}
