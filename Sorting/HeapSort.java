
public class HeapSort {
	
	public static void sort(Comparable[] A) {
		int n = A.length;
		for (int i = n / 2; i > 0; i--) {
			sink(A, i, n);
		}
		while (n > 1) {
			swap(A, 1, n);
			n--;
			sink(A, 1, n);
		}
	}
	
	private static void sink(Comparable[] pq, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(pq, j, j + 1)) j++;
			if (!less(pq, k, j)) break;
			swap(pq, k, j);
			k = j;
		}
	}
	
	private static void swap(Comparable[] A, int i, int j) {
		Comparable temp = A[i-1];
		A[i-1] = A[j-1];
		A[j-1] = temp;
	}
	
	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i-1].compareTo(pq[j-1]) < 0;
	}
	
	private static void print(Comparable[] A) {
		System.out.print("Array = [");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
			if (i < A.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		Integer[] A = {105, 99, 3, 65, 12, 336, 8, 4, 2, 6, 3, 9, 11, 1, 2};
		sort(A);
		print(A);
	}
}
