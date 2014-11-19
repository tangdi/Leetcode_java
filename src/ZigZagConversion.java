
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		StringBuilder newString = new StringBuilder();
		int length = s.length();
		if (length <= 1 || nRows <=1) {
			return s;
		}

		for (int i = 0; i < nRows; i++) {
			int index = i;
			if (i == 0 || i == nRows - 1) {
				while (index < length) {
					newString.append(s.charAt(index));
					index += 2 * nRows - 2;

				}

			} else {
				while (index < length) {
					newString.append(s.charAt(index));
					if (index + 2*(nRows-1-i) < length) {
						newString.append(s.charAt(index + 2*(nRows-1-i)));
					}
					index += 2 * nRows - 2;

				}

			}
		}
		return newString.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion zig = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int nRows = 5;
//		String s = "ABCDE";
		System.out.println(zig.convert(s, nRows));
	}
}
