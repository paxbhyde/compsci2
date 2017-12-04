public class StackTest{
	public static void main(String[] argv){
		Stack<String> myStack = new Stack<String> (100);
		try {
					myStack.push("paxton");
		myStack.push("adam");
		myStack.push("ella");
		myStack.push("hayden");
		myStack.push("jacob");
		myStack.push("gabi");
		} catch (OverFlowException tooMuch) {
			System.out.println("stack full");
		}
		
		try {
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
		} catch (UnderFlowException tooLittle) {
			System.out.println("stack empty");
		}
	}
}