/**
 * Link class implementation adapted from ISLink<T> interfact from CS2 day4 programming assignment for building a linked stack and queue.
 */
public class Link<T> {

	private T value;
	private Link<T> pointer;
	
	 /**
     * Link constructor creates a new link node storing value q and pointer p
     * @param q the value to be stored
     * @param p the pointer to the next cell in the list
     */
	public Link(T q, Link<T> p){
		value = q;
		pointer = p;
	}
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue(){
    	return value;
    }
    
    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v){
    	value = v;
    }
    
    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public Link<T> getNext(){
    	return pointer;
    }
    
    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(Link<T> c){
    	pointer = c;
    }
    
}