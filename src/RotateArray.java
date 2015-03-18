
public class RotateArray {
	 public void rotate(int[] nums, int k) {
	        if(k ==0){
	        	return;
	        }
	        
	        k %= nums.length;
	        
	        if (k>0){
	        	int[] temp = new int[k];
	        	for(int i = nums.length - k;i <nums.length; i++){
	        		temp[i-(nums.length -k)] = nums[i];
	        	}
	        	
	        	for(int i=nums.length-k-1; i >=0; i--){
	        		nums[i +k] = nums[i];
	        	}
	        	
	        	for(int i=0;i <k; i++){
	        		nums[i] = temp[i];
	        	}
	        }
	        
	 }
	 
	 public static void main(String[] args) {
		RotateArray s1= new RotateArray();
		int [] nums = {1,2,3,4,5,6,7};
		int k =3;
		s1.rotate(nums, k);
		for(int i: nums){
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
