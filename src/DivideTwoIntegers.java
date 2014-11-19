public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == 0)
			return 0;

		boolean minus = ((dividend ^ divisor) >>> 31 == 1);
		
		int result = 0;
		int digit = 0;

		if (dividend == Integer.MIN_VALUE) {
			result = 1;
			dividend += Math.abs(divisor);
		}
		
		if(divisor == Integer.MIN_VALUE){
			return result;
		}

		int absDivisor = Math.abs(divisor);

		int absDividend = Math.abs(dividend);

		

		while (absDivisor <= (absDividend >> 1)) {
			absDivisor <<= 1;
			digit++;

		}

		while (digit >= 0) {
			if (absDividend >= absDivisor) {
				absDividend -= absDivisor;
				result += 1 << digit;
			}
			absDivisor >>= 1;
			digit--;
		}

		return minus ? -result : result;
	}

	public static void main(String[] args) {
		DivideTwoIntegers s1 = new DivideTwoIntegers();
		System.out.println(s1.divide(10, 3));
	}
}
