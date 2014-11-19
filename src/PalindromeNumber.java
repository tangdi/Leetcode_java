public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x >= 0 && x <= 9)
			return true;
		
		
		int length = 1;
		do {
			length++;
			
		} while ((int)(x / Math.pow((double)10, (double)length)) > 0);
		System.out.println(length);
		for (int i = 0; i < length / 2; i++) {
			if((x%((int)Math.pow(10, i+1))/((int)Math.pow(10, i))) != (x%((int)Math.pow(10, length-i))/((int)Math.pow(10, length-i-1))) ) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		PalindromeNumber s1 = new PalindromeNumber();
		//System.out.println(s1.isPalindrome(100));
		//System.out.println(s1.isPalindrome(101));
		System.out.println(s1.isPalindrome(2147483647));
	}
}
