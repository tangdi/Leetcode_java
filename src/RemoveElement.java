import java.util.ArrayList;
import java.util.List;


public class RemoveElement {
	 public int removeElement(int[] A, int elem) {
	        List<Integer> newList = new ArrayList<Integer>();
	        for(int i: A){
	        	if(i != elem){
	        		newList.add(i);
	        	}
	        }
	        for(int i=0; i<newList.size();i++){
	        	A[i] = newList.get(i);
	        }
	        return newList.size();
	    }
}
