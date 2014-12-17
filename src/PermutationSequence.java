import java.util.Arrays;


public class PermutationSequence {
    public String getPermutationSlow(int n, int k) {
        int[] digits = new int[n];
        for(int i=1;i<=n;i++){
            digits[i-1] = i;
        }
        
        while(k-->1){
            nextPermuation(digits); 
            StringBuilder str = new StringBuilder();
            for(int i: digits){
                str.append(i);
            }
            System.out.println(str.toString());
            
        }
        
        StringBuilder str = new StringBuilder();
        for(int i: digits){
            str.append(i);
        }
        return str.toString();
    }
    
    public void nextPermuation(int[] digits){
        for(int i=digits.length -2; i>=0 ;i--){
            if(digits[i] < digits[i+1]){
                int min = digits[i+1];
                int min_index = i+1;
                System.out.println("yes");
                for(int j =digits.length -1; j> i+1 ; j--){
                    if(digits[j] > digits [i] && digits[j] < min){
                        min = digits[j];
                        min_index = j;
                    }
                }
                digits[min_index] = digits[i];
                digits[i] = min;
                Arrays.sort(digits, i+1, digits.length);
                return;
                
            }
        }
    }
    
    public String getPermutation(int n, int k) {
    	 
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
 
		// change k to be index
		k--;
 
		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}
 
		String result = "";
 
		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;
 
			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}
 
		return result.toString();
	}
    
    public static void main(String[] args) {
		PermutationSequence s1 = new  PermutationSequence();
		int n = 3;
		int k = 5;
		System.out.println(s1.getPermutation(n, k));
	}
    
}
