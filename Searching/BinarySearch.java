import java.util.Arrays;

public class BinarySearch {
	
	public static int indexOf(int[] A, int key){
		int lo = 0;
		int hi = A.length - 1;
		while (lo <= hi){
			int mid = (lo + hi) / 2;
			if (A[mid] < key){
				lo = mid + 1;
			} else if (A[mid] > key){
				hi = mid - 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int firstOccurence(int[] A, int key){
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi){
			int mid = (lo + hi) / 2;
			if (A[mid] < key){
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		if (A[lo] != key) return -1;
		return lo;
	}
	
	public static int lastOccurence(int[] A, int key){
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi){
			int mid = (lo + hi + 1) / 2;
			if (A[mid] > key){
				hi = mid - 1;
			} else {
				lo = mid;
			}
		}
		if (A[lo] != key) return -1;
		return lo;
	}
	
	public static int numberOfOccurences(int[] A, int key){
		int first = firstOccurence(A, key);
		int last = lastOccurence(A, key);
		if (last == -1){
			return 0;
		} else {
			return last - first + 1;
		}
	}
	
	public static void main(String[] args) {
		int[] A = { 5, 1, 3, 8, 5, 4, 8, 8};
		Arrays.sort(A);
		System.out.println(indexOf(A, 8));
		System.out.println(indexOf(A, 5));
		System.out.println(indexOf(A, 6));
		System.out.println(firstOccurence(A, 8));
		System.out.println(firstOccurence(A, 5));
		System.out.println(lastOccurence(A, 8));
		System.out.println(lastOccurence(A, 5));
		System.out.println(numberOfOccurences(A, 8));
		System.out.println(numberOfOccurences(A, 3));
	}
	
}
