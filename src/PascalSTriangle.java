import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalSTriangle {
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows <1){
        	return result;
        }
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        result.add(new ArrayList<Integer>(row));
        
        for (int i =2; i<= numRows; i++){
        	Integer[] thisRow = new Integer[i];
        	thisRow[0] =1;
        	thisRow[i-1] =1;
        	List<Integer> prev_row = result.get(result.size()-1);
        	for( int j=1; j<i-1; j++){
        		
        		thisRow[j] = prev_row.get(j)+prev_row.get(j-1);
        	}
        	result.add(Arrays.asList(thisRow));
        	
        }
       return result;
    }

public static void main(String[] args){
	PascalSTriangle s1 = new PascalSTriangle();
	System.out.println(s1.generate(5));
}
}

