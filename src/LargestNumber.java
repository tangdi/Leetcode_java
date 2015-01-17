import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] num) {
		Integer[] nums = new Integer[num.length];
		for (int i = 0; i < num.length; i++) {
			nums[i] = num[i];
		}

		Arrays.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				if (arg0 == arg1) {
					return 0;
				}
				
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				sb1.append(arg0);
				sb2.append(arg1);
				int sb1_index = 0;
				int sb2_index = 0;
				while(sb1_index < sb1.length() && sb2_index < sb1.length()){
					if(sb1.charAt(sb1_index) - '0' > sb2.charAt(sb2_index) -'0'){
						return -1;
					}
					if(sb1.charAt(sb1_index) - '0' < sb2.charAt(sb2_index) -'0'){
						return 1;
					}
					if(sb1_index < sb1.length()-1){
						sb1_index ++;
					}
					
					if(sb2_index < sb2.length()-1){
						sb2_index ++;
					}
				}
				return 0;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(Integer i: nums){
			sb.append(i);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LargestNumber s1 = new LargestNumber();
		int[] num = {3,43,48,94,85,33,64,32,63,66};
		System.out.println(s1.largestNumber(num));
	}
}
