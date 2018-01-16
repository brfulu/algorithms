
public class BubbleSort {
	
	public static void sort(Comparable[] A) {
		int n = A.length;
		while (true) {
			int swaps = 0;
			for (int i = 0; i < n - 1; i++) {
				if (less(A[i + 1], A[i])) {
					swap(A, i, i + 1);
					swaps++;
				}
			}
			if (swaps == 0) break;
		}
	}
	
	private static void swap(Comparable[] A, int i, int j) {
		Comparable temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
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
		Integer[] A = {105, 8, 4, 22, 16, 3, 9, 11, 1, 19, 8, 6, 7};
		sort(A);
		print(A);
	}
}
