import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class SudokuSolver {
	 public void solveSudoku(char[][] board) {
		 	HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
		 	LinkedList<Integer> list = new LinkedList<Integer>();
	        List<Set<Integer>> row_house = new ArrayList<Set<Integer>>();
	        List<Set<Integer>> col_house = new ArrayList<Set<Integer>>();
	        List<List<Set<Integer>>> box_house = new ArrayList<List<Set<Integer>>>();
	        for(int i=0; i<9; i++){
	        	row_house.add(new HashSet<Integer>());
	        	col_house.add(new HashSet<Integer>());
	        }
	        
	        for(int i=0;i<3;i++){
	        	box_house.add(new ArrayList<Set<Integer>> ());
	        	for(int j=0; j<3; j++){
	        		box_house.get(i).add(new HashSet<Integer>());
	        	}
	        }
	        
	        for(int i=0; i<9;i++){
	        	for(int j=0; j<9;j++){
	        		if(board[i][j] != '.'){
	        			row_house.get(i).add(board[i][j] - '0');
	        			col_house.get(j).add(board[i][j] - '0');
	        			box_house.get(i/3).get(j/3).add(board[i][j] - '0');
	        			
	        		}else{
	        			memory.put(10*i+j, 0);
	        			list.add(10*i+j);
	        		}
	        	}
	        }
	        int index = 0;
	       
	       
	        while(index<list.size()){
	        	
	        	
	        	int key = list.get(index);
	        	int i = key/10;
        		int j = key%10;
        		int start = memory.get(key);
      
        		row_house.get(i).remove(start);
    			col_house.get(j).remove(start);
    			box_house.get(i/3).get(j/3).remove(start);
        		boolean found = false;
        		for(int candidate = start+1; candidate <=9 ; candidate++){
    				if( !row_house.get(i).contains(candidate)
    					&& !col_house.get(j).contains(candidate)
    					&& !box_house.get(i/3).get(j/3).contains(candidate)){
    					board[i][j] = Character.forDigit(candidate, 10);
    					row_house.get(i).add(candidate);
	        			col_house.get(j).add(candidate);
	        			box_house.get(i/3).get(j/3).add(candidate);        			
	        			memory.put(key, candidate);
	        			found = true;
	        			break;
    				}
    			}
        		if(!found){
        			index--;
        			memory.put(key, 0);
        		}else{
        			index++;
        		}
	        }
	               
	    }
	 public void solveSudoku(String[] args){
		 char[][] temp = new char[args.length][];
		 for(int i=0; i<args.length; i++){
			 temp[i] = args[i].toCharArray();
		 }
		 
		 solveSudoku(temp);
		 for(char[] point: temp){
			 for(char c: point){
				 System.out.print(c);
				 System.out.print(' ');
			 }
			 System.out.println();
		 }
	 }
	 public static void main(String[] args){
		 SudokuSolver s1 = new SudokuSolver();
		 String[] strings = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		 s1.solveSudoku(strings);
	 }
}
