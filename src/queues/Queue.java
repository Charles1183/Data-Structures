package queues;

import java.util.Scanner;

public class Queue {

	//protected String element;
	protected int top;
	protected int bottom;
	protected final int MAXSIZE = 5;
	protected String[] myQueue;
	
	Queue(){
		//element = null;
		top = -1;
		bottom = -1;
		myQueue = new String[MAXSIZE];
	}
	
	public String enqueue(String input){
		if(!isFull()){
				top++;
				top=top%MAXSIZE;
				myQueue[top]=input;
		}else{System.out.println ("Queue is full. Can not add element to queue.");}
		return input;
		
	}
	
	public void dequeue(){
		if(bottom==-1){bottom++;}
		if(!isEmpty()){
			myQueue[bottom]=null;
			if(myQueue[(bottom+1)%MAXSIZE]!=null){
				bottom++;
				bottom=bottom%MAXSIZE;
			}
		}else{System.out.println ("Queue is empty.");}
		
	}
	
	public String peek(){
		return myQueue[bottom];
	}
	
	public void printQueue(){
		if(!isEmpty()){
			System.out.print("Here is the current queue: ");
			for(int i=0; i<MAXSIZE; i++){
				if(myQueue[i]!=null){
					System.out.print(myQueue[i]+", ");
				}
			}
		}else{System.out.println("Queue is empty. No elements in queue.");}
		
	}
	
	public boolean isFull(){
		if(bottom>top){
			if(bottom-1==top){
				return true;
			} return false;
		}
		if(myQueue[(top+1)%MAXSIZE]!=null){
			return true;
		}return false;
	}
	
	public boolean isEmpty(){
		if(top==bottom && myQueue[bottom]==null){
			return true;
		}return false;
	}
	
	public static void main(String[] args) {
		Queue myQueue = new Queue();
		String dequeue;
		String exit;
		
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.println(myQueue.top);
			System.out.print("Do you want to add an element to the queue: ");
			String add = scan.next();
			
			if(add.equals("y")){
				System.out.print("Type the element you want to add to the queue: ");
				String input = scan.next();
				myQueue.enqueue(input);
				System.out.println(myQueue.top);
			}
			
			
			
			System.out.print("Do you want to dequeue an element form the queue? y/n: ");
			dequeue = scan.next();
			
			if(dequeue.equals("y")){
				myQueue.dequeue();
			}
			
			myQueue.printQueue();
			
			
			System.out.print("\nDo you want to exit? y/n: ");
			exit = scan.next();
			
		}while(!exit.equals("y"));
		scan.close();
	}

}
