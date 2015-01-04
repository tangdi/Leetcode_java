public class ClimbingChairs {
	public int climbStairs(int n) {
		int[] num = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				num[i] = 1;
				continue;
			}

			if (i == 2) {
				num[i] = 2;
				continue;
			}
			num[i] = num[i - 1] + num[i - 2];
		}
		return num[n];
	}
}
