public class Number1Bit {
	public int hammingWeight(int n) {
		String binaryStr = Integer.toBinaryString(n);
		int weight = 0;
		for(int i =0; i<binaryStr.length(); i++){
			if (binaryStr.charAt(i) == '1'){
				weight++;
			}
		}
		
		return weight;
	}
	
	public static void main(String[] args) {
		Number1Bit s1 = new Number1Bit();
		System.out.println(s1.hammingWeight(Integer.MIN_VALUE));
	}
}
