
public class SelectionSort {
	
	public static void sort(Comparable[] A) {
		int n = A.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (less(A[j], A[min])) {
					min = j;
				}
			}
			swap(A, i, min);
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
		Integer[] A = {85, 4, 22, 16, 33, 9, 11, 1, 19, 8, 6, 7};
		sort(A);
		print(A);
	}
}
