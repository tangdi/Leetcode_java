import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MaxPointsOnALine {
	 public int maxPoints(Point[] points) {
		 if(points.length <=2) return points.length;
		 int max = 2;
		 int same = 0;
		 Map<Float, List<Integer>> map = new HashMap<Float, List<Integer>>();
	       	for(int i=0; i<points.length; i++){
	       		map.clear();
	       		same = 0;
	       		for(int j=i+1; j<points.length; j++){
	       			if(points[i].y == points[j].y && points[i].x==points[j].x){
	       				same++;
	       				continue;
	       			}
	       			float slope = 0;
	       			
	       			if(points[i].x == points[j].x){
	       				slope = Float.POSITIVE_INFINITY;
	       			}else if(points[i].y == points[j].y){
	       				slope = (float) 0;
	       			}else{
	       		
	       				slope = ((float)(points[i].y - points[j].y))/(points[i].x - points[j].x); }
	       			if (!map.containsKey(slope)){
	       				List<Integer> list = new ArrayList<Integer>();
	       				list.add(i);
	       				list.add(j);
	       				map.put(slope, list);
	       			}else{
	       				List<Integer> list = map.get(slope);
	       				list.add(j);
	       				
	       			}
	       			
	       		}
	       		for(List<Integer> list: map.values()){
		       		   max = Math.max(max, same+list.size());
		       		}
	       		max = Math.max(same+1, max);
	       		//System.out.println(map);
	       	}
	     return max;
	 }
	 
	 public static void main(String[] args){
		 MaxPointsOnALine s1 = new MaxPointsOnALine();
		 Point[] points = {new Point(2,3), new Point(2,4), new Point(2,-3)};
		 System.out.println(s1.maxPoints(points));
	 }
}
