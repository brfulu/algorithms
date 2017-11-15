import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
	private int size;
	private Node head;
	private Node tail;
	
	private class Node {
		Item item;
		Node next;
		
		public Node(Item item) {
			this.item = item;
			this.next = null;
		}
	}
	
	public Queue() {
		size = 0;
		head = null;
		tail = null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void enqueue(Item item){
		Node oldTail = tail;
		tail = new Node(item);
		if (isEmpty()) 
			head = tail;
		else 
			oldTail.next = tail;
		size++;
	}
	
	public Item dequeue(){
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = head.item;
		head = head.next;
		size--;
		if (isEmpty()) tail = null;
		return item;
	}
	
	public Item peak(){
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return head.item;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Item item : this)
			sb.append(item + " ");
		return sb.toString();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue.peak());
		System.out.println(queue);
	}
}
