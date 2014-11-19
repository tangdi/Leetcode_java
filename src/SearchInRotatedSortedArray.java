public class SearchInRotatedSortedArray {
	public int search(int[] A, int start, int end, int target) {
		if (start > end)
			return -1;
		if (start == end) {
			if (A[start] == target) {
				return start;
			} else {
				return -1;
			}
		}

		int middle = start + (end - start) / 2;
		if (A[middle] == target)
			return middle;
		if (A[middle] > target) {
			return search(A, start, middle - 1, target);
		}
		return search(A, middle + 1, end, target);
	}

	public int search(int[] A, int target) {
		int pivot = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				pivot = i + 1;
			}
		}
		if (pivot == 0) {
			return search(A, 0, A.length - 1, target);
		}
		if (A[pivot] <= target && A[A.length - 1] >= target) {
			return search(A, pivot, A.length - 1, target);
		}
		return search(A, 0, pivot - 1, target);
	}

	public static void main(String args) {
		SearchInRotatedSortedArray s1 = new SearchInRotatedSortedArray();
		int[] A = { 1, 3 };
		int target = 0;
		System.out.println(s1.search(A, target));
	}

}
