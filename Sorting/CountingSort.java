
public class CountingSort {

	public static void sort(int[] A) {
		int n = A.length;
		int maxi = 0;
		for (int i = 0; i < n; i++) {
			maxi = Math.max(maxi, A[i]);
		}
		countingSort(A, maxi);
	}
	
	private static void countingSort(int[] A, int k) {
		int n = A.length;
		int[] output = new int[n];
		
		int[] cnt = new int[k + 1];
		for (int i = 0; i <= k; i++) {
			cnt[i] = 0;
		}
		
		for (int i = 0; i < A.length; i++) {
			cnt[A[i]]++;
		}
		for (int i = 1; i <= k; i++) {
			cnt[i] += cnt[i-1];
		}
		
		for (int i = A.length - 1; i >= 0; i--) {
			output[cnt[A[i]] - 1] = A[i];
			cnt[A[i]]--;
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = output[i];
		}
	}
	
	private static void print(int[] A) {
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
		int[] A = {8, 4, 13, 19, 11, 2, 6, 3, 9, 11, 1, 2};
		sort(A);
		print(A);
	}
}
