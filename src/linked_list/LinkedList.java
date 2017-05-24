package linked_list;

import java.util.Scanner;

class LinkedList{
	public static Node head;
	public Node tail;
	public Node cur;
	int count;
	
	LinkedList(int size){ this(); }
	
	LinkedList(){
		cur=head=tail=new Node(null);
	}
	
	public void insert(int num){
		cur.setNext(new Node(num, cur.next()));
		if (tail == cur) tail = cur.next();
		count++;
	}
	
	public void append(int num){
		tail = tail.setNext(new Node(num, null));
		LinkedList.removeHead();
		count++;
	}
	
	public int remove(){
		if (cur.next()==null){ return 0;}
		int num = cur.next().element();
		if (tail == cur.next()) tail=cur;
		cur.setNext(cur.next().next());
		count--;
		return num;
	}
	
	private static void removeHead(){
		if(head.element() == 0){head = head.next();}
	}
	
	public void clear(){
		head.setNext(null);
		cur=tail=head=new Node(null);
		count=0;
	}
	
	public void moveToStart(){
		cur=head;
	}
	
	public void moveToEnd(){
		cur=tail;
	}
	
	public void prev(){
		if(cur==head) return;
		Node temp = head;
		while(temp.next() != null) temp=temp.next();
		cur=temp;
	}
	
	public void next(){
		if(cur != tail) cur=cur.next();
	}
	
	public int length(){
		return count;
	}
	
	public int curPos(){
		Node temp = head;
		int i;
		for(i=0; cur != temp; i++) temp=temp.next();
		return i;
	}
	
	public void moveToPos(int pos){
		assert (pos>=0)&&(pos<=count): "Position out of range!";
		cur = head;
		for(int i = 0; i<pos; i++) cur=cur.next();
	}
	
	public int getValue(){
		if(cur.next()==null) return cur.element();
		return cur.next().element();
	}
	
	public static void main(String[] args) {
		
		int userNum;
		String stop = "";
		LinkedList list = new LinkedList();
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("Type in a number: ");
			userNum = scan.nextInt();
		
			list.append(userNum);	
			
			System.out.println("User Number: "+userNum);
			System.out.println("List length: "+list.length());
			//System.out.println("Node made with element: "+node.getElement());
			System.out.println("Element added to list: "+list.getValue());
			
			System.out.println("Want to exit? Y/N: ");
			stop = scan.next();
		} while (stop.equals("n"));
		
		list.moveToStart();
		System.out.print("Here is the current list: ");
		for (int i = 0; i<list.count; i++){
			//if(list.cur.element() != 0){
				System.out.print(list.cur.element()+", ");	
				//}
			list.next();	
		}
		System.out.println("The head of the list is: "+LinkedList.head.element());
		
		scan.close();
		
		
	}

}
