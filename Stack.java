/**
	Stack ADT 
 */

public class Stack {
	private char[] stackArray;
	private int top;
	final int DEFAULT_CAPACIIY = 5;
	
	
	/* no-arg constructor 
	 * initializes a stack with the DEFAULT_CAPACIIY, 
	 * and initializes the private fields
	*/
	public Stack(){ //initializes default values; -1 means an empty stack 
		top = -1;
		stackArray = new char[DEFAULT_CAPACIIY];
	}
	public void push (char item){ //add one item on top
      if (top == stackArray.length - 1) {
				System.out.println("The stack is full.");
			}
			else
				top++;
				stackArray[top] = item; //add up an item to the empty spot
	}
	public char pop(){ //remove the top item
		if(top < 0){
			System.out.println("The stack is empty.");
			return ' ';
		}
		else{
			top--;
			return stackArray[top+1]; // return the item that just is removed
		}
	}
	/* if the stack is not empty, returns the value of the last element from a stack, but does not emove the element from the stack, 
	 */
	public char peek(){
		if(top < 0){
			System.out.println("No items to peek, it's empty.");
			return ' ';
		}
		else
		return stackArray[top];
	}
	public int getSize(){ // how many elements are currently in the stack
		return top + 1;
	}
	
	/*  returns the capacity of the stack 
	 */
	public int getCapacity(){
		return stackArray.length;
	}
	public boolean isFull(){ // returns true if the stack is full
		if (top == stackArray.length -1) {
			return true;
		} else 
			return false;
	}
	
	/*
	 *  returns true if the stack is empty
	 */
	public boolean isEmpty(){ 
		if (top == -1)
			return true;
		else 
			return false;
	}
	public String toString (){ // returns a string of all the elements.
		String str = "";
		for (int i = 0; i <= top; i++) {
			str += stackArray[i] + " ";
		}
		return str;
	}	
	public boolean equals(Stack otherStack){
		int i =0;
		boolean stackEqual = true; // use one flag var. to determine length and every element. //1 rock 2 birds!!
		if (!(this.stackArray.length == otherStack.stackArray.length)) {
			stackEqual = false;
			return stackEqual;
		} 
		while(stackEqual && i < stackArray.length){ // AMAZING perfect logic!!
			if(stackArray[i] == otherStack.stackArray[i]){
				stackEqual = true;
			}
			else
				stackEqual = false;
			i++;
		}
		return stackEqual;
	}
	public Stack(int capacity){
		top = -1;
		stackArray = new char[capacity];
	}		
	//Copy constructor
	public Stack (Stack existingStack){ 
		top = existingStack.top;
		stackArray = new char[existingStack.stackArray.length]; 
		for (int i = 0; i < stackArray.length; i++) {
			this.stackArray[i] = existingStack.stackArray[i];
		}
	}
}
