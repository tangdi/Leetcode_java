import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Triangle {
   
   
     public int minimumTotal(List<List<Integer>> triangle) {
        int listSize = triangle.size();
        int[] matrix = new int[listSize];
        matrix[0] = triangle.get(0).get(0);
        
      
        
        for (int i=1; i<listSize; i++){
            List<Integer> temp = new ArrayList<Integer>();
            int previous_head = matrix[0];
            int previous_tail =  matrix[triangle.get(i).size()-2];
            
            for(int j=1; j<triangle.get(i).size()-1; j++){
                temp.add(triangle.get(i).get(j) + Math.min(matrix[j-1], matrix[j]));
                
            }
            matrix[0] =  triangle.get(i).get(0) + previous_head;
            
            matrix[triangle.get(i).size()-1] = triangle.get(i).get(triangle.get(i).size()-1) + previous_tail;
            int l = 1;
            for(Integer x: temp){
                matrix[l] = x;
                l++;
            }
          
        }
        int min=Integer.MAX_VALUE;
        for(Integer temp:matrix){
            min=Math.min(temp,min);
        }
        return min;
        
    }
    
    public int minimumTotal2(List<List<Integer>> triangle) {
        int listSize = triangle.size();
        int[] matrix = new int[listSize];
        for (int i=0; i<triangle.get(listSize-1).size(); i++){
            matrix[i] = triangle.get(listSize-1).get(i);
        }
        
        for (int i=listSize-2; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                matrix[j] = triangle.get(i).get(j) + Math.min(matrix[j], matrix[j+1]);
                
            }
        }
         return matrix[0];
        
    }
    
   
}