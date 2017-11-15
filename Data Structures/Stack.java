import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
	private int size;
	private Node head;
	
	private class Node {
		Item item;
		Node next;
		
		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	public Stack() {
		size = 0;
		head = null;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void push(Item item){
		Node oldHead = head;
		head = new Node(item, oldHead);
		size++;
	}
	
	public Item pop(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item top = head.item;
		head = head.next;
		size--;
		return top;
	}
	
	public Item top(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return head.item;
	}
	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		for (Item item : this){
			result.append(item + " ");
		}
		return result.toString();
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
		Stack<String> stack = new Stack<>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println(stack);
		stack.pop();
		System.out.println(stack.top());
	}

}
