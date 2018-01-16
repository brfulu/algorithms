
public class ShellSort {
	
	public static void sort(Comparable[] A) {
		int n = A.length;

		int h = 1;
		while (h < n / 3) h = 3 * h + 1;
		
		while (h > 0) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(A[j], A[j - h]); j -= h) {
					swap(A, j, j - h);
				}
			}
			h /= 3;
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
		Integer[] A = {8, 4, 22, 16, 3, 9, 11, 1, 19, 8, 6, 7};
		sort(A);
		print(A);
	}
}
