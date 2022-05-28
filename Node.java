package myStore;

public class Node<T> {
	private T ele; //infomation of Node
	private Node<T> prev; //indicate to previous point
	private Node<T> next; //indicate to next point
	
	public Node(T ele, Node<T> prev, Node<T> next) {
		this.ele = ele;
		this.prev = prev;
		this.next = next;
	}
	
	
	

}
