package stacks;

import java.util.Scanner;

public class Stack {
	
	protected final int MAXSIZE = 5;
	public int top = -1;
	protected String[] myStack = new String[MAXSIZE];
	
	
	Stack(){
	}
	
	public void push(String userInput){
			if(!isFull()){
			top++;
			myStack[top]=userInput;
			}else{
				System.out.println("Stack limit of "+MAXSIZE+" has beed reached.\nCould not add element to the stack.");
				}
	}
	
	public String pull(){
		if(!isEmpty()){
			String temp = myStack[top];
			myStack[top]=null;
			top--;
			return temp;
		}else{
		return "Stack is empty. You must and a least one element to the stack inorder to pull ann element.";
		}
	}
	
	public String peek(){
		if(!isEmpty()){return myStack[top];}
		return "Stack is empty.";
	}
	
	public boolean isFull(){
		if(top+1 == MAXSIZE){return true;}
		return false;
	}
	
	public boolean isEmpty(){
		if(top == -1){return true;}
		return false;
	}
	
	public void printStack(){
		if(!isEmpty()){
			System.out.print("You have "+(top+1)+" elements in the stack.\nHere are the elements in pull order: ");
			for(int i=top; i>=0; i--){
				System.out.print(myStack[i]+", ");
			}
		}else{System.out.println("Stack is empty. No elements in the stack.");} 
		
	}

	public static void main(String[] args) {
		String exit;
		String pull;
		Stack myStack = new Stack();
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.println("Add data to the stack: ");
			String input = scan.next();
			
			myStack.push(input);
			
			System.out.println("Do you want to pull an element form the stack? y/n: ");
			pull = scan.next();
			
			if(pull.equals("y")){
				myStack.pull();
			}
			
			myStack.printStack();
			
			System.out.println("The number of elements in the stack are: "+(myStack.top+1));
			
			System.out.println("Do you want to exit? y/n: ");
			exit = scan.next();
			
		}while(!exit.equals("y"));
		scan.close();
	}

}
