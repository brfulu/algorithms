
public class InsertionSort {
	
	public static void sort(Comparable[] A) {
		int n = A.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(A[j], A[j - 1]); j--) {
				swap(A, j, j - 1);
			}
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
		Integer[] A = {8, 4, 2, 6, 3, 9, 11, 1, 2};
		sort(A);
		print(A);
	}
}
