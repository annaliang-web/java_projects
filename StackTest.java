import java.util.Scanner;
public class StackTest {

	public static void main(String[] args) {

		Stack myStack = new Stack();
		test_constructor(myStack);
		test_push(myStack);
		test_toString(myStack);
		test_isFull(myStack);
		test_peek(myStack);
		test_pop(myStack);
		
		test_isEmpty(myStack);
		test_copy(myStack);
		
		Stack myStack7 = new Stack(7);
		// Stack myStack7 = new Stack(5);
		test_constructor(myStack7);
		test_equals(myStack, myStack7);
		test_push(myStack7);
		test_toString (myStack7);
		test_isFull(myStack7);
		test_peek(myStack7);
		test_pop(myStack7);
		test_isEmpty(myStack7);
		test_equals(myStack, myStack7);
	palindrome();

	} // Main ends -------------

	public static void palindrome(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String input = keyboard.nextLine();
		Stack palindromes_Stack = new Stack(input.length());
		for (int i = 0; i < input.length(); i++) {
			palindromes_Stack.push(input.charAt(i)); // add each character to char stack
		}
		System.out.println("Original word: " + palindromes_Stack.toString());
		String reverseInput = "";
		System.out.println(palindromes_Stack.getSize());
		while(!palindromes_Stack.isEmpty()){
			reverseInput += palindromes_Stack.pop();
		}
		System.out.println("Reverse word: " + reverseInput.toLowerCase());
		Stack reverseStack = new Stack(reverseInput.length());
		for (int i = 0; i < reverseStack.getCapacity(); i++) {
			reverseStack.push(reverseInput.charAt(i));
		}
		if(palindromes_Stack.equals(reverseStack))
			System.out.print("Equal!");
		else
			System.out.println("Not equal!");
	}
	
  public static void test_constructor(Stack theStack){
	System.out.println("***** Test constructor ****");
	System.out.println("Stack size: " + theStack.getSize());
	System.out.println("Stack capacity: " + theStack.getCapacity());
  }

  public static void test_push(Stack theStack){
	System.out.println("***** Test push ****");
	theStack.push('a'); 
	System.out.println("Stack size: " + theStack.getSize());
	System.out.println("Stack capacity: " + theStack.getCapacity());
	theStack.push('b');
	System.out.println("Stack size: " + theStack.getSize());
	System.out.println("Stack capacity: " + theStack.getCapacity());
	theStack.push('c');
	System.out.println("Stack size: " + theStack.getSize());
	System.out.println("Stack capacity: " + theStack.getCapacity());
	theStack.push('d');
	System.out.println("Stack size: " + theStack.getSize());
	System.out.println("Stack capacity: " + theStack.getCapacity());
	theStack.push('e');
	System.out.println("Stack size: " + theStack.getSize());
	System.out.println("Stack capacity: " + theStack.getCapacity());
  }
  
  public static void test_peek(Stack theStack){
	  System.out.println("***** Test peek ****");
	  System.out.println("top element: "+ theStack.peek());  
  }
  
  public static void test_pop(Stack theStack){
	  System.out.println("***** Test pop ****");
	  System.out.print("Stack size: " + theStack.getSize());
	  System.out.println(", top element: "+ theStack.peek());
	  theStack.pop();
	  System.out.print("top element removed: ");
	  System.out.print("Stack size: " + theStack.getSize());
	  System.out.println(", top element: "+ theStack.peek());
  }
  
  public static void test_isEmpty(Stack theStack){
	  System.out.println("***** Test isEmpty ****");
	  if (theStack.isEmpty()){
		  System.out.print("Stack is empty, ");
		  System.out.println("Stack size: " + theStack.getSize());
	  }	  
      else{
    	  System.out.print("Stack is not empty, ");
		  System.out.println("Stack size: " + theStack.getSize());
	  }
  }
  
  public static void test_isFull(Stack theStack){
	  System.out.println("***** Test isFull ****");
	  if (theStack.isFull()){
		  System.out.print("Stack is full, ");
		  System.out.print("Stack size: " + theStack.getSize());
		  System.out.println(", Stack capacity: " + theStack.getCapacity());
	  }	  
      else{
    	  System.out.print("Stack is not full, ");
		  System.out.print("Stack size: " + theStack.getSize());
		  System.out.println(", Stack capacity: " + theStack.getCapacity());
	  }
  }
  
  public static void test_toString (Stack theStack){
	  System.out.println("***** Test toString ****");
	  System.out.println(theStack);
  }
  
  public static void test_equals (Stack theStack, Stack theOtherStack){
	  System.out.println("***** Test equals ******");
	  if (theStack.equals(theOtherStack))
		  System.out.println("both stacks are equal");
	  else 
		  System.out.println("both stacks are not equal");
  }
  
  public static void test_copy (Stack original){
	  System.out.println("***** Test copy constructor ******");

	  Stack clone = new Stack(original);
	  
	  System.out.println("The original: " + original.getCapacity()+" " + original.getSize()+" "+ original );
	  System.out.println("The clone: " + clone.getCapacity()+" " + clone.getSize()+" " + clone );
	  
	  test_equals(original, clone);
  }

}

  
