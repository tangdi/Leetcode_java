public class CountPrimes {
	public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}
		boolean[] notPrimes = new boolean[n];
		notPrimes[0] = notPrimes[1] = true;

		for (int i = 2; i * i < n; i++) {
			if (!notPrimes[i]) {
				int c = i * i;
				while (c < n) {
					notPrimes[c] = true;
					c += i;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < notPrimes.length; i++) {
			if (!notPrimes[i]) {
				count++;
			}
		}
		return count;
	}
}
