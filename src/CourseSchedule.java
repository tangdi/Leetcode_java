import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CourseSchedule {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if(numCourses ==0){
	            return true;
	        }
	        boolean[] finishableCourses = new boolean[numCourses];
	        Map<Integer, List<Integer>> relation = new HashMap<Integer, List<Integer>>();
	        for(int i = 0; i <prerequisites.length; i++){
	                if(relation.containsKey(prerequisites[i][0])){
	                    relation.get(prerequisites[i][0]).add(prerequisites[i][1]);
	                }else{
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(prerequisites[i][1]);
	                    relation.put(prerequisites[i][0], list);
	                }
	        }
	        
	        for(int i =0; i< finishableCourses.length; i++){
	            if(!relation.containsKey(i)){
	                finishableCourses[i] = true;
	                numCourses--;
	            }
	        }
	        
	        while (numCourses >0){
	            boolean reduce = false;
	            for(int i = 0; i <prerequisites.length; i++){
	            	if(finishableCourses[prerequisites[i][0]]){
	            		continue;
	            	}
	                boolean finishable =true;
	                List<Integer> list = relation.get(prerequisites[i][0]);
	                for(Integer n: list){
	                    if(!finishableCourses[n]){
	                        finishable = false;
	                        break;
	                    }
	                }
	                 if(finishable){
	                     finishableCourses[prerequisites[i][0]] = true;
	                     numCourses--;
	                     reduce = true;
	                }
	            }
	            if(!reduce){
	                return false;
	            }
	        }
	        return true;
	       
	    }
	public static void main(String[] args) {
		CourseSchedule s1 = new CourseSchedule();
		int[][] prerequisites = {{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5},{5,1},{6,4}};
		System.out.println(s1.canFinish(8, prerequisites));
	}
}
