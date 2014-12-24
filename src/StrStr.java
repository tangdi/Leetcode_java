public class StrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null
				|| needle.length() > haystack.length()) {
			return -1;
		}

		int index = -1;

		for (int i = 0; i + needle.length() - 1 < haystack.length(); i++) {
			String s = haystack.substring(i, i + needle.length());
			if (needle.equals(s)) {
				return i;
			}
		}

		return index;

	}
}
