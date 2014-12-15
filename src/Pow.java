import java.util.HashMap;
import java.util.Map;

public class Pow {
	public double pow(double x, int n) {
		if (x == 0)
			return 0;
		if (n == 0)
			return 1;

		boolean positive = n > 0 ? true : false;
		boolean positive_double = x > 0 ? true : false;

		double product = 1;

		Map<Integer, Double> memory = new HashMap<Integer, Double>();

		if (positive) {
			memory.put(1, x);
		} else {
			memory.put(1, 1 / x);
		}
		int left = Math.abs(n);

		while (left != 0) {
			int i = 2;
			for (; i <= left && i <= Integer.MAX_VALUE / 2; i *= 2) {
				if (memory.containsKey(i)) {
					continue;
				}

				memory.put(i, memory.get(i / 2) * memory.get(i / 2));

			}

			i = i / 2;

			product *= memory.get(i);
			left -= i;
			if (left == 1) {
				product *= memory.get(1);
				return product;
			}

		}

		return product;

	}

	public static void main(String[] args) {
		Pow s1 = new Pow();
		double x = 8.88023;
		int n = 3;
		System.out.println(s1.pow(x, n));
	}
}
