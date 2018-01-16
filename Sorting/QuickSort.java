import java.util.Random;

public class QuickSort {
	
	public static void sort(Comparable[] A) {
		int n = A.length;
		shuffle(A);
		sort(A, 0, n - 1);
	}
	
	private static void sort(Comparable[] A, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(A, lo, hi);
		sort(A, lo, j - 1);
		sort(A, j + 1, hi);
	}
	
	private static int partition(Comparable[] A, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable pivot = A[lo];
		
		while (i < j) {
			while (less(A[++i], pivot)) {
				if (i == hi) break;
			}
			while (less(pivot, A[--j])) {
				if (j == lo) break;
			}
			if (i >= j) break;
			swap(A, i, j);
		}
		swap(A, lo, j);
		return j;
	}
	
	private static void shuffle(Comparable[] A) {
		Random random = new Random();
		for (int i = 1; i < A.length; i++) {
			int j = random.nextInt(i + 1);
			swap(A, i, j);
		}
	}

	public static Comparable select(Comparable[] A, int k) {
		shuffle(A);
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi) {
			int j = partition(A, lo, hi);
			if (k > j) 
				lo = j + 1;
			else if (k < j)
				hi = j - 1;
			else 
				return A[j];
		}
		return A[lo];
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
		Integer[] A = {105, 8, 45, 22, 16, 31, 9, 11, 12, 19, 8, 6, 7};
		sort(A);
		print(A);
		
		Integer[] B = {6, 2, 3, 11, 7, 5, 9};
		System.out.println("Select k-th = " + select(B, 4));
	}
}
