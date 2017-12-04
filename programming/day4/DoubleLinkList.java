/**
 * A doubly linked list implementation of IList.
 */
public class DoubleLinkList<T> implements IList<T> { // <T> is a generic (non-specific) variable type.

	private int leng = 0;
	private DLink<T> head; //pointer
	private DLink<T> tail; //pointer
	private DLink<T> current; //pointer to previous link(i.e. headLink for the first filled link)
	
    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v){
    	if (idx > leng || idx < 0) {
    		System.out.println("Requested insertion out of range.");
    		return;
    	}
    	
    	DLink<T> ins = new DLink<T>(v, null, null);
    	if (leng == 0) { //if the list is empty
    		head = ins;
    		tail = ins;
    	} else if (idx == 0) {
    		DLink<T> zero = (DLink<T>) head.getNext();
    		ins.setNext(zero);
    		head = ins;
    		
    		zero.setPrev(ins);
    	} else if (idx == leng){
    		this.append(v);
    	} else {
    		DLink<T> point = head;
    		for (int i = 0; i < idx - 1; i++){ 
    			point = (DLink<T>) point.getNext();
    		}	// pointer points to link before insert index
    		ins.setNext(point.getNext());
    		ins.setPrev(point);
    		
    		point.getNext().setPrev(ins);
    		point.setNext(ins); 
    	}
    	leng++;
    }
    
	/**
	 * Adds an item to the end of list. Called 'Add' in class, but more usually called 
	 * append in other libraries. Moves <i>current</i> to the end of the list.
	 * @param v Item to add
	 */
	public void append(T v){
		DLink<T> app = new DLink<T>(v, null, null);
		if (leng == 0) { 
			head = app;
		} else {
			app.setPrev(tail);
			tail.setNext(app);
		}
		tail = app;
		current = app;
		leng++;
	}
	
	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes 
	 * the previous item in the list, if such element exists.
	 */
	public void remove(){
		if (leng == 0) {
			System.out.println("Nothing to remove.");
    		return;
		}
		
		if (current == head){
			head = (DLink<T>) head.getNext();
			head.setPrev(null);
			current = head;
		} else if (current == tail) {
			tail = (DLink<T>) tail.getPrev();
			tail.setNext(null);
			current = tail;
		} else {
			DLink<T> afterRemove = (DLink<T>) current.getNext();
			DLink<T> b4Remove = (DLink<T>) current.getPrev();
			b4Remove.setNext(afterRemove);
			afterRemove.setPrev(b4Remove);
			current = b4Remove;
		}

		leng--;
	}
	
	/**
	 * Removes the item at a specific index
	 * @param idx index of item to remove
	 */
	public void remove(int idx){
		if (leng == 0) {
			System.out.println("Nothing to remove.");
    		return;
		} else if (idx >= leng || idx < 0) {
    		System.out.println("Requested insertion out of range.");
    		return;
    	}
    	
    	if (idx == 0) {
    		DLink<T> index1 = (DLink<T>) head.getNext();
    		head = index1;
    		index1.setPrev(null);
    	} else if (idx == leng - 1){
    		DLink<T> m2 = (DLink<T>) tail.getPrev();
    		m2.setNext(null);
    		tail = m2;
    	} else {
    		DLink<T> rem2 = head;
    		for (int i = 0; i < idx - 1; i++) { rem2 = (DLink<T>) rem2.getNext(); }
    		DLink<T> afterRemov2 = (DLink<T>) rem2.getNext().getNext();
    		rem2.setNext(afterRemov2);
    		afterRemov2.setPrev(rem2);
    	}
    	leng--;
	}
	
	/**
	 * Changes the location of an existing element in the list
	 * @param sidx - The initial index for the element to move
	 * @param didx - The final index for the element to move
	 */
	public void move(int sidx, int didx){
		if (sidx == didx) { return; } 
		if (sidx < 0 || didx < 0 || sidx > leng - 1  || didx > leng) {
			System.out.println("Requested move out of bounds.");
			return;
		}
		DLink<T> pointer = head; //points to the actual object with the value to be moved
		for (int i = 0; i < sidx; i++){
			pointer = (DLink<T>) pointer.getNext();
		}
		T elem = pointer.getValue();
		this.remove(sidx);
		this.insert(didx, elem);
	}
	
	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public T fetch(){
		return current.getValue();
	}
	
	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch(int idx){
		DLink<T> fetch1 = head;
		for (int i = 0; i < idx; i++) { fetch1 = (DLink<T>) fetch1.getNext(); }
		return fetch1.getValue(); //null pointer exception here
	}
	
	/**
	 * Advances the <i>current</i> index to the next index, if possible.
	 */
	public void next(){
		current = (DLink<T>) current.getNext();
	}
	
	/**
	 * Advances the <i>current</i> index to the previous index, if possible.
	 */
	public void prev(){
		current = (DLink<T>) current.getPrev();
	}
	
	/**
	 * Advances the <i>current</i> to the tail element
	 */
	public void jumpToTail(){
		current = tail;
	}
	
	/**
	 * Advances the <i>current</i> to the head element
	 */
	public void jumpToHead(){
		current = head;
	}

	/**
	 * Returns the number of elements in the list
	 */
	public int size(){ return leng; }
}