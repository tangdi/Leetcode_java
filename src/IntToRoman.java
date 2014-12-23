import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntToRoman {
	public String intToRoman(int num) {
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				ret.append(symbols[i]);
				num -= values[i];
			}
		}
		return new String(ret);
	}

	public static void main(String[] args) {
		IntToRoman s1 = new IntToRoman();
		System.out.println(s1.intToRoman(45));
	}
}
