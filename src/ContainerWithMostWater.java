import java.util.LinkedList;

public class ContainerWithMostWater {
	public int maxAreaSlow(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return max;
	}

	public int maxArea(int[] height) {
		int max = 0;
		int i =0;
		int j = height.length-1;
		while(i<j){
			max = Math.max(max, Math.min(height[i], height[j])*(j-i));
			if(height[i]<height[j]){
				i++;
			}else{
				j--;
			}
		}
		return max;
	}

}
