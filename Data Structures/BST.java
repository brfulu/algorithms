import java.util.NoSuchElementException;

public class BST <Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int size;
		
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public BST() {
		root = null;
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node node){
		return node == null ? 0 : node.size;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean contains(Key key){
		return key != null && get(key) != null;
	}
	
	public Value get(Key key){
		return get(root, key);
	}
	
	private Value get(Node x, Key key){
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;
	}
	
	public void put(Key key, Value value){
		if (key == null) throw new IllegalArgumentException("Key can't be null");
		if (value == null)
			delete(key);
		else 
			root = put(root, key, value);
	}
	
	private Node put(Node x, Key key, Value value){
		if (x == null) return new Node(key, value);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = value;
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Node min(){
		if (isEmpty()) throw new NoSuchElementException("Empty tree");
		return min(root);
	}
	
	private Node min(Node x){
		if (x.left == null) 
			return x;
		else 
			return min(x.left);
	}
	
	public void delete(Key key){
		if (key == null) throw new IllegalArgumentException("Key can't be null");
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key){
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left = delete(x.left, key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			if (x.left == null)  return x.right;
			if (x.right == null) return x.left;
			
			Node temp = x;
			x = min(temp.right);
			x.right = deleteMin(temp.right);
			x.left = temp.left;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void deleteMin(){
		if (isEmpty()) throw new NoSuchElementException("Empty tree");
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x){
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public String inOrder(){
		return inOrder(root).toString();
	}
	
	public boolean isBST(){
		return isBST(root, null, null);
	}
	
	private boolean isBST(Node x, Key lo, Key hi){
		if (x == null) return true;
		if (lo != null && x.key.compareTo(lo) < 0) return false;
		if (hi != null && x.key.compareTo(hi) > 0) return false;
		return isBST(x.left, lo, x.key) && isBST(x.right, x.key, hi);
	}
	
	private StringBuilder inOrder(Node x){
		if (x == null) return new StringBuilder();
		StringBuilder sb = inOrder(x.left);
		if (sb.length() > 0) sb.append(" ");
		sb.append(x.value);
		StringBuilder right = inOrder(x.right);
		if (right.length() > 0) sb.append(" ");
		sb.append(right);
		return sb;
	}
	
	public static void main(String[] args) {
		BST<Integer, String> bst = new BST<>();
		bst.put(4, "Four");
		bst.put(1, "One");
		bst.put(2, "Two");	
		bst.put(3, "Three");
		bst.put(5, "Five");	
		bst.put(0, "Zero");
		System.out.println(bst.isBST());
		System.out.println(bst.inOrder());
		bst.deleteMin();
		System.out.println(bst.inOrder());
		bst.delete(3);
		System.out.println(bst.inOrder());
	}
}


