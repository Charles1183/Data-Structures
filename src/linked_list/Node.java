package linked_list;

public class Node {

	public int element;
	public Node next;
	
	Node(int num, Node nextval){
		element = num;
		next = nextval;
	}
	
	Node(Node nextval){
		next = nextval;
	}
	
	public Node next(){
		return next;
	} 
	
	public Node setNext(Node nextval){
		return next = nextval;
	}
	
	public int element(){
		return element;
	}
	
	public int setElement(int num){
		return element = num;
	}
	
	public int getElement(){
		return element;
	}
	
	public Node getNext(){
		return next;
	}
	
}
