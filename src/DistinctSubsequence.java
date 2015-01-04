public class DistinctSubsequence {
	public int numDistinct(String S, String T) {
		int[][] D = new int[S.length() + 1][T.length() + 1];
		for (int i = 0; i < S.length() + 1; i++) {
			for (int j = 0; j < T.length() + 1; j++) {
				if(i ==0 && j==0){
					D[i][j] = 0;
					continue;
				}
				
				if(i == 0 || i < j){
					D[i][j] = 0;
					continue;
				}
				
				if(j ==0){
					D[i][j] = 1;
					continue;
				}
				
				if(i == j){
					D[i][j] = S.substring(0, i).equals(T.substring(0, j))? 1: 0; 
					continue;
				}
				D[i][j] = D[i-1][j] + (S.charAt(i-1) == T.charAt(j-1)? D[i-1][j-1]:0);
			}
		}
		return D[S.length()][T.length()];
	}
	
	public static void main(String[] args) {
		DistinctSubsequence s1 = new DistinctSubsequence();
		String S = "rabbbit", T = "rabbit";
		System.out.println(s1.numDistinct(S, T));
	}
}
