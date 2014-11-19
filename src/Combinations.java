import java.util.ArrayList;
import java.util.List;


public class Combinations {
	 List<List<Integer>> result;
	 public List<List<Integer>> combine(int n, int k) {
		 result = new ArrayList<List<Integer>>();
		 if(n<=0 || k<=0) return result;
		 ArrayList<Integer> source = new ArrayList<Integer>();
		 for (int i=1; i<=n;i++){
			 source.add(i);
		 }
		 help(source, 0, k, new ArrayList<Integer>());
		 return result;
	        
	    }
	 
	 void help(ArrayList<Integer> source, int start, int length, ArrayList<Integer> container){
		 if (length == 0){
			 result.add(new ArrayList<Integer>(container));
			 return;
		 }
		 for(int i=start; i<source.size();i++){
			 container.add(source.get(i));
			 help(source, i+1, length-1, container);
			 container.remove(container.size()-1);
		 }
		 
	 }
	 
	 public static void main(String[] args){
		 Combinations s1 = new Combinations();
		 int n =4;
		 int k=2;
		 System.out.println(s1.combine(n, k));
	 }

}
