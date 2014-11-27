import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		if (height.length < 1) {
			return 0;
		}

		LinkedList<Integer> stack = new LinkedList<Integer>();
		int max = Integer.MIN_VALUE;
		int top;

		for(int i=0; i<height.length;i++){
			if(stack.isEmpty() || height[stack.peek()]<= height[i]){
				stack.push(i);
			}else{
				do{
					top = stack.pop();
					max= Math.max(max, height[top]*(stack.isEmpty()? i: i - stack.peek() -1));
				} while(!stack.isEmpty() && height[stack.peek()] > height[i]);
				stack.push(i);
			}
			
		}
		
		while(!stack.isEmpty()){
			top = stack.pop();
			max = Math.max(max, height[top]*(stack.isEmpty()? height.length: height.length- stack.peek() -1));
		}
		
		return max;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram s1 = new LargestRectangleInHistogram();
		 int [] height= {2,1,5,6,2,3};
		// int[] height ={1,2,2};
		//int[] height = { 1, 2, 3, 4, 5 };
		System.out.println(s1.largestRectangleArea(height));
	}
}
