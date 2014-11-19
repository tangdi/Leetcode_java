public class MedianofTwoSortedArrays {
	int total_length;

	

	public double findMedianSortedArrays(int A[], int B[]) {
		total_length = A.length + B.length;
		if (total_length % 2 != 0) {
			if (A.length >= B.length) {
				return findK(A, 0, A.length, B, 0, B.length,
						total_length / 2 + 1);
			}
			return findK(B, 0, B.length, A, 0, A.length, total_length / 2 + 1);
		} else {
			if (A.length >= B.length) {
				return (double)(findK(A, 0, A.length, B, 0, B.length, total_length / 2) + findK(
						A, 0, A.length, B, 0, B.length, total_length / 2 + 1)) / 2;
			}
			return (double)(findK(B, 0, B.length, A, 0, A.length, total_length / 2) + findK(
					B, 0, B.length, A, 0, A.length, total_length / 2 + 1)) / 2;

		}
	}

	public int findK(int l[], int l_start, int l_len, int s[], int s_start,
			int s_len, int k) {
		
		if (s_len == 0) {
			return l[l_start + k - 1];
		}
		if (l_len == 0) {
			return s[s_start + k - 1];
		}
		if (k == 1) {
			return Math.min(l[l_start], s[s_start]);
		}

		int s_pivot, l_pivot;
		if (s_len < k / 2) {
			s_pivot = s_start + s_len - 1;
			l_pivot = l_start + k - s_len - 1;
		} else {
			s_pivot = s_start + k / 2 - 1;
			l_pivot = l_start + k - k / 2 - 1;
		}

		
		System.out.println("k is "+ k);
		System.out.println("l_len is "+ l_len);
		System.out.println("s_len is "+ s_len);
		System.out.println("s_pivot is "+ s_pivot);
		System.out.println("l_pivot is "+ l_pivot);

		if (  l[l_pivot] > s[s_pivot] && (s_pivot -s_start +1 == s_len  || l[l_pivot] < s[s_pivot + 1])) {
			return l[l_pivot];
		}

		if (s[s_pivot] > l[l_pivot] && (l_pivot -l_start +1 == l_len ||s[s_pivot] < l[l_pivot + 1])) {

			return s[s_pivot];
		}

		if (l[l_pivot] > s[s_pivot]) {
			l_len = (l_pivot - l_start) + 1;
			s_len = s_len - (s_pivot - s_start + 1);
			k = k - (s_pivot - s_start + 1);
			if (l_len >= s_len) {
				return findK(l, l_start, l_len, s, s_pivot + 1, s_len, k);
			} else {
				return findK(s, s_pivot + 1, s_len, l, l_start, l_len, k);
			}

		}

		l_len = l_len - (l_pivot - l_start + 1);
		s_len = (s_pivot - s_start) + 1;
		k = k - (l_pivot - l_start + 1);
		if (l_len >= s_len) {
			return findK(l, l_pivot + 1, l_len, s, s_start, s_len, k);
		} else {
			return findK(s, s_start, s_len, l, l_pivot + 1, l_len, k);
		}

	}

	

	public static void main(String[] args) {
		MedianofTwoSortedArrays s1 = new MedianofTwoSortedArrays();
		int[] A = { 100000};
		int[] B = { 100001 };
		System.out.println(s1.findMedianSortedArrays(A, B));
	}

}
