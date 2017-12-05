/**
 * Link-based implementation of stack interface IStack 
 */
public class Stack<T> implements IStack<T> {
	
	private Link<T> top;
	private int maxsize;
	private int leng;
	
	/**
	 * Stack constructor takes the maxsize and initializes <i>leng</i> to zero.
	 * @ param m the maxsize of the stack
	 */
	public Stack(int m){
		leng = 0;
		maxsize = m;
	}
	
    /**
     * Pushes a new value onto the stack
     * @param v the value to push
     */
    public void push(T v) throws OverFlowException{
    	if (leng >= maxsize) { //list has reached maxsize
    		System.out.println("stack overflow.");
    		throw new OverFlowException();
    	}
    	
    	Link<T> serrano = new Link<T>(v, null);
    	if (leng == 0) { //list is empty
			top = serrano;
    	} else {
    		serrano.setNext(top);
    		top = serrano;
    	}
    	leng++;
    	//System.out.println("token pushed.");
    }
    
    /**
     * Pops the top value from the stack
     * @return the value
     */
    public T pop() throws UnderFlowException{
    	if (leng <= 0) {
    		System.out.println("stack empty.");
    		throw new UnderFlowException();
    	}
    
    	T val = top.getValue();
    	top = top.getNext();
    	leng--;
    	
    	//System.out.println("token popped.");
    	return val;
    }
}