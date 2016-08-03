import java.util.Arrays;

/**
 * ClassName: NumbersOfIslands Function: TODO
 *
 * @Author: dtang
 * @Date: 7/30/16, 11:47 AM
 */
public class NumbersOfIslands {
    boolean isSafe(char [][]grid, int row, int col,
                   boolean [][]visited, int ROW, int COL)
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (grid[row][col]=='1' && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(char[][] grid, int row, int col, boolean [][]visited, int ROW, int COL)
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] {-1, 1, 0,  0};
        int colNbr[] = new int[] {0,  0, -1, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 4; ++k)
            if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visited, ROW, COL) )
                DFS(grid, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
    }
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int nums = 0;
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        if(cols ==0) return 0;
        boolean[][] visited = new boolean[rows][cols] ;
        for(int i=0; i<rows; i++ ){
            for(int j =0; j<cols; j++){
                if(grid[i][j] == '0' || visited[i][j]) continue;

                DFS(grid, i, j , visited, rows, cols);
                nums ++;

            }
        }
        return nums;
    }

    int findRoot(int[] id, int n){
        while(n != id[n]){
            id[n] = id[id[n]];
            n = id[n];
        }
        return n;
    }

    public int numIslandsWithDisjointSet(char[][] grid) {
        if(grid == null) return 0;
        int nums = 0;
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        if(cols ==0) return 0;
        int[] id =new int[cols * rows];
        Arrays.fill(id, -1);

        int[] dx ={-1, 1 , 0, 0};
        int[] dy= {0, 0, -1, 1};
        for(int i=0; i<rows; i++ ){
            for(int j =0; j<cols; j++){
                if(grid[i][j] == '1'){
                    int root = i*cols + j;
                    id[root] = root;
                    nums ++;
                    for(int delta = 0; delta <4 ;delta++){
                        int neigX = i +dx[delta];
                        int neigY = j +dy[delta];
                        if(neigX <0 || neigX>= rows || neigY <0 || neigY >= cols || id[neigX * cols + neigY] == -1){
                            continue;
                        }
                        int anotherRoot = findRoot(id, neigX * cols + neigY);
                        if(anotherRoot != root){
                            nums --;
                            id[anotherRoot] = root;
                        }
                    }
                }
            }
        }

        return nums;
    }
}
