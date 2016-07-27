/**
 * ClassName: MaxSumofRectangleNoLargerThanK Function: TODO
 *
 * @Author: dtang
 * @Date: 7/27/16, 9:14 PM
 */
public class MaxSumofRectangleNoLargerThanK {
    private int max(int[] array, int k){
        int max = Integer.MIN_VALUE;
        for(int i =0; i< array.length; i++){
            int sum = array[i];
            if(sum <= k){
                max = Math.max(sum, max);
            }
            for(int j =i+1; j<array.length;j++){
                sum += array[j];
                if(sum <= k){
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int small = Math.min(rows,cols);
        int large = Math.max(rows,cols);
        boolean colLarger = cols>rows;

        for (int i =0; i <small; i++){
            int[] temp = new int[large];
            for(int j = i; j < small; j++){
                for(int x =0; x<large; x++){
                    temp[x] += colLarger? matrix[j][x]: matrix[x][j];
                }
                int tempMax = max(temp, k);
                max = Math.max(max, tempMax);

            }
        }
        return max;

    }
}
