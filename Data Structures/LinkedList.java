
public class LinkedList<Item> {
	private int size;
	private Node head;
	
	private class Node {
		Item item;
		Node next;
		
		public Node(Item item) {
			this.item = item;
			this.next = null;
		}
		
		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	public LinkedList() {
		size = 0;
		head = null;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void addToFront(Item item){
		Node oldHead = head;
		head = new Node(item, oldHead);
		size++;
	}
	
	public void addToBack(Item item){
		Node newNode = new Node(item);
		size++;
		if (head == null){
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null){
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void remove(Item item){
		if (head.item.equals(item)){
			head = head.next;
			size--;
			return;
		}
		Node current = head;
		Node previous = null;
		while (current != null && !current.item.equals(item)){
			previous = current;
			current = current.next;
		}
		if (current != null){
			previous.next = current.next;
			size--;
		}
	}
	
	public void reverse(){
		Node current = head;
		Node previous = null;
		while (current != null){
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	public void concatenate(LinkedList<Item> other){
		Node current = head;
		while (current.next != null){
			current = current.next;
		}
		current.next = other.head;
	}
	
	public void removeDuplicates(){
		Node current = head;
		while (current != null){
			removeDuplicatesToTheRight(current);
			current = current.next;
		}
	}
	
	private void removeDuplicatesToTheRight(Node node){
		Node current = node.next;
		Node previous = node;
		while (current != null){
			if (current.item.equals(node.item)){
				previous.next = current.next;
			}
			else {
				previous = current;
			}
			current = current.next;
		}
	}
	
	public boolean isPalindrome(){
		LinkedList<Item> reversed = new LinkedList<>();
		Node current = head;
		Node previous = null;
		while (current != null){
			Node newNode = new Node(current.item);
			newNode.next = previous;
			previous = newNode;
			current = current.next;
		}
		reversed.head = previous;
		System.out.println(reversed);
		return isSame(reversed);
	}
	
	public boolean isSame(LinkedList<Item> other){
		Node current1 = head;
		Node current2 = other.head;
		while (current1 != null){
			if (current2 == null || !current1.item.equals(current2.item)){
				return false;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		return current2 == null;
	}
	
	public boolean containsCycle(){
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String result = "List = [";
		Node current = head;
		while (current != null){
			result += current.item + ", ";
			current = current.next;
		}
		result = result.substring(0, result.length() - 2) + "]";
		return result;
	}
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.addToBack("one");
		list.addToBack("two");
		list.addToFront("three");
		list.addToBack("four");
		list.addToFront("five");
		System.out.println(list);
		list.remove("three");
		System.out.println(list);
		list.remove("five");
		System.out.println(list);
		
		list.reverse();
		System.out.println(list);
		
		LinkedList<String> otherList = new LinkedList<>();
		otherList.addToBack("two");
		otherList.addToBack("four");
		
		list.concatenate(otherList);
		System.out.println(list);
		
		System.out.println(list.isPalindrome());
		
		list.removeDuplicates();
		System.out.println(list);	
		
		System.out.println(list.containsCycle());
	}	
	
}













