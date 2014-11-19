import java.util.HashSet;


public class ValidSudoku {
	 public boolean isValidSudoku(char[][] board) {
		 HashSet<Character> set;
		 if(board == null) return false;
		 for(int i =0; i<9 ;i++ ){
			 set = new HashSet<Character>();
			 for(int j=0; j<9; j++){
				 if (board[i][j] != '.'){
					 if (set.contains(board[i][j])){
						 return false;
					 }else{
						 set.add(board[i][j]);
					 }
				 }
			 }
			 
		 }
		 
		 for(int i =0; i<9 ;i++ ){
			 set = new HashSet<Character>();
			 for(int j=0; j<9; j++){
				 if (board[j][i] != '.'){
					 if (set.contains(board[j][i])){
						 return false;
					 }else{
						 set.add(board[j][i]);
					 }
				 }
			 }
			 
		 }
		 
		 for(int i=0; i<9; i+=3){
			 for(int j=0;j <9; j+=3){
				 set = new HashSet<Character>();
				 for(int x=0; x<3; x++){
					 for(int y=0;y<3;y++){
						 if (board[i+x][j+y] != '.'){
							 if (set.contains(board[i+x][j+y])){
								 return false;
							 }else{
								 set.add(board[i+x][j+y]);
							 }
						 }
					 }
				 }
				 
			 }
			
			 
		 }
		 return true;

	 }
	 
	 
}
