import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class ExcelSheetColumnTitle {
	 public String convertToTitle(int n) {
	        StringBuilder sb = new StringBuilder();
	        Deque<Character> list = new LinkedList<Character>();
	        while (n > 0){
	        	System.out.println(n%26);
	        	list.push((char)('A' + (n-1) %26));
	        	n = (n-1)/26 ;
	        }
	        while(!list.isEmpty()){
	        	sb.append(list.poll());
	        }
	        return sb.toString();
	        
	    }
	 
	 public static void main(String[] args) {
		ExcelSheetColumnTitle s1 = new ExcelSheetColumnTitle();
		String s = s1.convertToTitle(27*26);
		s.to
		System.out.println(s);
	 }
}
