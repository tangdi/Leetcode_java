public class SingleNumberII {
	public int singleNumber(int[] A) {
		int[] bit = new int[32];
		for (int i = 0; i < 32; i++) {
			bit[i] = 0;
		}

		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) == 1) {
					bit[i] = (bit[i] + 1) % 3;
				}
			}
			result += (bit[i]<<i);
		}
		return result;

	}

}
