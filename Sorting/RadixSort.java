import java.util.Arrays;

public class RadixSort {

	public static void sort(int[] A) {
		int n = A.length;
		int maxNum = getMax(A);
		
		for (int exp = 1; maxNum / exp > 0; exp *= 10) {
			countingSort(A, exp);
		}
	}
	
	private static void countingSort(int[] A, int exp) {
		int n = A.length;
		int[] output = new int[n];
		
		int[] cnt = new int[10];
		Arrays.fill(cnt, 0);
		
		for (int i = 0; i < A.length; i++) {
			cnt[(A[i] / exp) % 10]++;
		}
		for (int i = 1; i < 10; i++) {
			cnt[i] += cnt[i-1];
		}
		
		for (int i = A.length - 1; i >= 0; i--) {
			output[cnt[(A[i] / exp) % 10] - 1] = A[i];
			cnt[(A[i] / exp) % 10]--;
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = output[i];
		}
	}
	
	private static int getMax(int[] A) {
		int maxi = A[0];
		for (int i = 1; i < A.length; i++) {
			maxi = Math.max(maxi, A[i]);
		}
		return maxi;
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
		int[] A = {871, 4223, 2003115, 2003116, 19056, 98711, 999, 123456, 6121, 9, 111, 13, 20, 987};
		sort(A);
		print(A);
	}
}
