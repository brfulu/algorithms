
public class MergeSort {
	
	public static void sort(Comparable[] A) {
		Comparable[] aux = new Comparable[A.length];
		sort(A, aux, 0, A.length - 1);
	}
	
	private static void sort(Comparable[] A, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = (lo + hi) / 2;
		sort(A, aux, lo, mid);
		sort(A, aux, mid + 1, hi);
		merge(A, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable[] A, Comparable[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = A[i];
		}
		
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) 
				A[k] = aux[j++];
			else if (j > hi)
				A[k] = aux[i++];
			else if (less(aux[i], aux[j]))
				A[k] = aux[i++];
			else 
				A[k] = aux[j++];
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
		Integer[] A = {105, 42, 22, 16, 36, 91, 11, 1, 19, 82, 6, 77};
		sort(A);
		print(A);
	}
}
