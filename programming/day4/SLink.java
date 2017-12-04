/**
 * Implementation for link cells in a singlely linked list.
 */
public class SLink<T> implements ISLink<T> {

	private ISLink<T> pointer;
	private T element;

	/**
	* Constructor for the SLink<T> object
	* @ param f the value held in the cell
	* @ param q the pointer to the next cell in the list
	*/
	public SLink(T f, ISLink<T> q){
		element = f;
		pointer = q;
	}
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue(){ return element; }
    
    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v){ element = v; }
    
    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public ISLink<T> getNext(){ return pointer; }
    
    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(ISLink<T> c){ pointer = c; }
    
}