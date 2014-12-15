public class ReverseInteger {
	public int reverse(int x) {
		if (x == 0)
			return 0;
		if (x == Integer.MIN_VALUE)
			return 0;

		boolean positive = x > 0 ? true : false;
		x = Math.abs(x);
		List<Integer> digits = new ArrayList<Integer>();
		int n = x;
		do {
			digits.add(n % 10);

			n = n / 10;
		} while (n != 0);

		int newValue = 0;

		for (int i = 0; i < digits.size(); i++) {
			if (newValue > Integer.MAX_VALUE / 10) {
				return 0;
			}
			newValue *= 10;
			newValue += digits.get(i);
		}

		return positive ? newValue : 0 - newValue;

	}
}
