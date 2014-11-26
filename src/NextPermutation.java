import java.util.Arrays;


public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num.length <= 1) {
			return;
		}
		
		helper(num, 0);
		

	}

	public void helper(int[] num, int start) {
		for (int i = num.length - 2; i >= start; i--) {
			if (num[i] < num[i+1]) {
				for(int j = num.length-1; j> i; j--){
					if(num[i]<num[j]){
						int temp = num[j];
						num[j] = num[i];
						num[i] = temp;
						Arrays.sort(num, i+1, num.length);
						return;
					}
				}
			}
	

		}
		Arrays.sort(num, start, num.length);

		

	}

	public static void main(String[] args) {
		NextPermutation s1 = new NextPermutation();
		int[] num = {1,3,2};
		s1.nextPermutation(num);
		for (int i : num) {
			System.out.println(i);
		}
	}
}
