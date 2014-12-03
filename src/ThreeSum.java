import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
	  public List<List<Integer>> threeSum(int[] num) {
		  List<List<Integer>> solSet = new ArrayList<List<Integer>>();
	      Arrays.sort(num);  
		  for(int i=0; i<num.length-2 ;i++){
	        	if(i> 0 && num[i]== num[i-1]){
	        		continue;
	        	}
	        	
	        	int head = i+1;
	        	int tail = num.length-1;
	        	while(head<tail){
	        		if(num[head]+num[tail]+num[i] == 0){
	        			Integer[] sol = {num[i], num[head], num[tail]};
	        			solSet.add(Arrays.asList(sol));
	        			
	        			head++;
	        			tail--;
	        			while(head<tail&&num[head] == num[head-1]){
	        				head++;
	        			}
	        			while(tail>head&&num[tail] == num[tail+1]){
	        				tail--;
	        			}
	        		}else if(num[head]+num[tail]+num[i] > 0){
	        			tail--;
	        		}else{
	        			head++;
	        		}
	        	}
	        }
		  return solSet;
	    }
}
