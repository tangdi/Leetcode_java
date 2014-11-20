import java.util.HashMap;


public class UniquePaths {
	
	 public int uniquePaths(int m, int n) {
		 int[][] dict = new int[m][n];
		 
		 for(int i=0; i<m;i++){
			 dict[i][0] = 1;
		 }
		 for(int i=0; i<n;i++){
			 dict[0][i] = 1;
		 }
		 
		 for(int i=1 ; i < m; i++){
			 for(int j=1; j<n; j++){
				 dict [i][j] = dict[i-1][j] + dict[i][j-1];
			 }
		 }
		 
		 
	     return dict[m-1][n-1];
	    }
	 
	 public static void main(String[] args){
		 UniquePaths s1 = new UniquePaths();
		 System.out.println(s1.uniquePaths(23, 12));
	 }

}
