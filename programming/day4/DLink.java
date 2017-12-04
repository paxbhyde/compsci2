/**
 * Implementation of link cells in a doubly linked list.
 */
public class DLink<T> implements IDLink<T> {

	private IDLink<T> ppointer;
	private IDLink<T> npointer;
	private T element;

	/**
	 * Constructor for doubly-linked cell
	 * @param f value to be held in the cell
	 * @param q pointer to previous cell in list
	 * @param n pointer to next cell in list
	 */
	public DLink(T f, IDLink<T> q, IDLink<T> n){
		element = f;
		ppointer = q;
		npointer = n;
	}
	
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue(){
    	return element;
    }
    
    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v){
    	element = v;
    }
    
    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public IDLink<T> getNext(){
    	return npointer;
    }
    
    /**
     * Gets the previous cell in the list
     * @return the cell
     */
    public IDLink<T> getPrev(){
    	return ppointer;
    }
    
    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(IDLink<T> c){
    	npointer = c;
    }
    
    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setPrev(IDLink<T> c){
    	ppointer = c;
    }
}