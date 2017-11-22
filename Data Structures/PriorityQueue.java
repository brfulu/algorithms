import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class PriorityQueue<Item> {
	private Item[] pq;
	private int size;

	public PriorityQueue(int capacity) {
		pq = (Item[]) new Object[capacity + 1];
		size = 0;
	}
	
	public PriorityQueue(Item[] A){
		int n = A.length;
		for (int i = 0; i < n; i++)
			pq[i + 1] = A[i];
		for (int i = n / 2; i >= 1; i--)
			sink(i);
	}
	
	public PriorityQueue(){
		this(1);
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public Item peek(){
		if (isEmpty()) throw new NoSuchElementException("Empty pq");
		return pq[1];
	}
	
	private void resize(int capacity){
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 1; i <= size; i++){
			temp[i] = pq[i];
		}
		pq = temp;
	}
	
	private void push(Item item){
		//System.out.println(size);
		if (size == pq.length - 1) resize(pq.length * 2);
		pq[++size] = item;
		swim(size);
	}
	
	public Item pop(){
		if (isEmpty()) throw new NoSuchElementException("Empty pq");
		Item item = pq[1];
		swap(1, size--);
		sink(1);
		pq[size + 1] = null;
		if (size > 0 && size == pq.length / 4) resize(pq.length / 2);
		return item;
	}
	
	private void swap(int i, int j){
		Item temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	private int compare(int i, int j){
		return ((Comparable<Item>) pq[i]).compareTo(pq[j]);
	}
	
	private void swim(int k){
		while (k > 1 && compare(k, k / 2) > 0){
			swap(k, k / 2);
			k /= 2;
		}
	}
	
	private void sink(int k){
		while (2 * k <= size){
			int j = k * 2;
			if (j < size && compare(j, j + 1) < 0) j++;
			if (compare(k, j) >= 0) break;
			swap(k, j);
			k = j;
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.push(5);
		pq.push(4);
		pq.push(7);
		pq.push(9);
		pq.push(3);
		while (!pq.isEmpty()){
			System.out.println(pq.pop());
		}
	}
}
