import java.util.ArrayList;
import java.util.List;


public class MinStack {
	private List<Integer> list;
	private List<List<Integer>> min_list;
	
    public void push(int x) {
       if(list == null){
    	   list = new ArrayList<Integer>();
    	   min_list = new ArrayList<List<Integer>>();
       }
       
       list.add(x);
       if(min_list.size() ==0){
    	   List<Integer> newTail = new ArrayList<Integer>();
    	   newTail.add(x);
    	   newTail.add(1);
           min_list.add(newTail);
       }else{
    	   List<Integer> tail = min_list.get(min_list.size()-1);
    	   int min = tail.get(0);
    	   int min_count = tail.get(1);
           if(min <= x){
               min_count ++;
               tail.set(1, min_count);
           }else{
        	   List<Integer> newTail = new ArrayList<Integer>();
        	   newTail.add(x);
        	   newTail.add(1);
               min_list.add(newTail);
           }
       }
      
    }

    public void pop() {
        int last = list.get(list.size() -1 );
        List<Integer> tail = min_list.get(min_list.size() - 1);
        int min = tail.get(0);
        int min_count = tail.get(1);
        if(last == min){
            min_count --;
        }
        
        if(min_count ==0){
            min_list.remove(min_list.size()-1);
        } 
        
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
    	List<Integer> tail = min_list.get(min_list.size() -1);
        return tail.get(0);
    }
	public static void main(String[] args) {
		MinStack s1 = new MinStack();
		s1.push(2147483646);
		s1.push(2147483646);
		s1.push(2147483647);
		s1.top();
		s1.pop();
		s1.getMin();
		s1.pop();
		s1.getMin();
		s1.pop();
		s1.push(2147483647);
		s1.top();
		s1.getMin();
		s1.push(-2147483648);
		s1.top();
		s1.getMin();
		s1.pop();
		s1.getMin();
	}
}
