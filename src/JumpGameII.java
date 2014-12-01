public class JumpGameII {
	public int jump1(int[] A) {
		if (A.length <= 1)
			return 0;
		int[] result = new int[A.length];
		result[A.length - 1] = 0;

		for (int i = A.length - 2; i >= 0; i--) {
			if(i+A[i] >= A.length-1){
				result[i]= 1;
			} else{
				int min = 1;
				for(int val= 1; val <= A[i]; val++){
					min = Math.min(min, result[i+val]);
				}
				result[i] = min;
			}
		}
		return 0;
	}
	
	public int jump(int[] A) {
		int maxCover = 0;
		int cover = 0;
		int jumps = 0;
		
		for(int i=0; i <= maxCover && i<A.length; i++){
			if(i> cover){
				jumps++;
				cover = maxCover;
			}
			maxCover = Math.max(maxCover, A[i] +i);
		}
		return jumps;
	}
	
}
