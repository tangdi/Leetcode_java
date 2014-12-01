public class JumpGame {
	public boolean canJumpSlow(int[] A) {
		
		if(A.length ==0) return false;
		if(A.length ==1 || A[0] >= A.length-1) return true;
		
		boolean[] result = new boolean[A.length];
		result[A.length-1] = true;
		
		for(int i= A.length-2; i>= 0; i--){
			if(i+A[i] >= A.length-1){
				result[i] = true;
			}else{
				boolean temp = false;
				int val = 1;
				while(!temp &&val <= A[i]){
					temp = temp || result[i+val];
					val++;
				}
				result[i] = temp;
			}
		}
		return result[0];
	}
	
	public boolean canJump(int[] A){
		int maxCover = A[0];
		for(int start = 0; start <=maxCover && start<A.length; start++){
			maxCover = Math.max(maxCover, start +A[start]);
			if(maxCover >= A.length-1) return true;
		}
		return false;
	}

}
