import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class SurroundedRegion {
	public void solveWithDisjointSet(char[][] board) {
		int rows = board.length;
		if(rows ==0) return;
		int cols = board[0].length;
		if(cols ==0) return;
		int[] roots = new int[rows * cols];
		boolean[] surroundedMap = new boolean[rows*cols];
		int[] colDelta = {-1, 0, 1, 0};
		int[] rowDelta = {0, -1, 0, 1};
		for(int row =0; row<rows; row++){
			for(int col = 0; col< cols; col++){
				if(board[row][col] == 'O'){
					int index = row*cols + col;
					roots[index] = index;
					boolean surrounded = true;
					for( int i=0; i<colDelta.length; i++){
						int neigCol = col + colDelta[i];
						int neigRow = row + rowDelta[i];

						if(neigCol< cols && neigCol >=0 && neigRow <rows && neigRow >=0){
							int neigIndex = neigRow * cols + neigCol;
							if(board[neigRow][neigCol] == 'O' && roots[neigIndex] > 0){
								int neigRoot = findRoot(roots, neigIndex);
								roots[neigRoot] = index;
								if(neigRoot != index) surrounded = surrounded && surroundedMap[neigRoot];
							}
						}else{
							surrounded = false;
						}
					}
					surroundedMap[index] = surrounded;
				}
			}
		}

		for(int row =0; row<rows; row++){
			for(int col = 0; col< cols; col++){
				if(board[row][col] == 'O'){
					if(surroundedMap[findRoot(roots, row * cols + col)]){
						board[row][col] = 'X';
					}
				}
			}
		}
	}

	private int findRoot(int[] roots, int index){
		while(roots[index] != index){
			int temp = roots[index];
			roots[index] = roots[temp];
			index = roots[index];
		}
		return roots[index];
	}
	public void solve(char[][] board) {
		if(board == null || board.length <= 1 || board[0].length <=1){
			return;
		}
		Set<Integer> O_locs = new HashSet<Integer>();
		int rowSize = board.length;
		int colSize = board[0].length;
		for(int i =0; i<rowSize;i ++){
			for(int j=0; j<colSize; j++){
				if (board[i][j] == 'O'){
					O_locs.add(i * rowSize * colSize + j);
				}
			}
		}
		
		List<Set<Integer>> sets = getRegionList(O_locs, rowSize, colSize);
		
		for(Set<Integer> set: sets){
			boolean surrounded = true;
			for(Integer loc: set){
				if( isAtEdge(loc, rowSize, colSize)){
					surrounded = false;
					break;
				}
			}
			if (surrounded){
				
				for(Integer loc: set){
					
					int row = loc/(rowSize * colSize);
					int col = loc % colSize;
					board[row][col] = 'X';
					
				}
			}
			
		}
		
	}
	
	public boolean isAtEdge(int loc, int rowSize, int colSize){
		
		int row = loc/(rowSize * colSize);
		int col = loc % colSize;
		
		return row == 0 || row == rowSize -1 || col ==0 || col == colSize-1;
	}
	
	public List<Set<Integer>> getRegionList(Set<Integer> O_locs, int rowSize, int colSize){
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		while(!O_locs.isEmpty()){
			
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(O_locs.iterator().next());
			while(!stack.empty()){
				int loc = stack.pop();
				set.add(loc);
				O_locs.remove(loc);
				int row = loc/(rowSize * colSize);
				int col = loc % colSize;
				int up = 1, down =1, left=1, right = 1;
				while(row - up >=0 && O_locs.contains(loc - rowSize*colSize*up)){
					set.add(loc - rowSize*colSize *up);
					O_locs.remove(loc - rowSize*colSize*up);
					stack.add(loc - rowSize*colSize *up);
					up ++;
				}
				while(col - left >=0 && O_locs.contains(loc - left)){
					set.add(loc - left);
					stack.add(loc - left);
					O_locs.remove(loc - left);
					left ++;
				}
				while(col + right < colSize && O_locs.contains(loc + right)){
					set.add(loc + right);
					stack.add(loc + right);
					O_locs.remove(loc + right);
					right ++;
				}
				while(row + down < rowSize && O_locs.contains(loc + rowSize*colSize*down)){
					set.add(loc + rowSize*colSize*down);
					stack.add(loc + rowSize*colSize*down);
					O_locs.remove(loc + rowSize*colSize*down);
					down ++;
				}
			}
			list.add(set);
			set = new HashSet<Integer>();
		}
		return list;
	}
	
	public static void main(String[] args) {
		SurroundedRegion s1 = new SurroundedRegion();
		char[][] board = {
				{'O','X', 'X','X'},
				{'X','O', 'O','X'},
				{'X','O', 'O','X'},
				{'X','X', 'X','X'},
		};
		
		s1.solve(board);
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
