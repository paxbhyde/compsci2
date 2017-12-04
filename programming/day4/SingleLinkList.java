/**
 * Singly-linked list implementation of IList.
 */
public class SingleLinkList<T> implements IList<T> { // <T> is a generic (non-specific) variable type.

	private int leng = 0;
	private int currentidx = 0;
	private SLink<T> head;
	private SLink<T> tail;
	private SLink<T> current;
	
    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v){
    	if (idx > leng || idx < 0) {
    		System.out.println("Requested insertion out of range.");
    		return; // is it safe to do this?
    	}
    	
    	SLink<T> ins = new SLink<T>(v, null);
    	if (leng == 0) { //if the list is empty
    		head = ins;
    		tail = ins;
    		current = ins;
    	} else if (idx == 0) {
    		ins.setNext(head);
    		head = ins;
    	} else if (idx == leng){
    		this.append(v);
    	} else {
    		SLink<T> point = head;
    		for (int i = 0; i < idx - 1; i++){ 
    			point = (SLink<T>) point.getNext();
    		}	// for loop moves point down the chain to the idxTH index
    		ins.setNext(point.getNext());
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
		SLink<T> app = new SLink<T>(v, null);
		if (leng == 0) { 
			head = app;
			tail = app;
			current = app;
		} else {
			tail.setNext(app); //setNext for the SLink pointed at by "tail"
			tail = app; //move the tail pointer to the newly added item
			current = tail;
		}
		leng++;
		currentidx = leng - 1;
	}
	
	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes 
	 * the previous item in the list, if such element exists.
	 */
	public void remove(){
		if (leng == 0) {
			System.out.println("No items to remove.");
			return;
		}
		if (current == head){
			head = (SLink<T>) head.getNext();
			current = head;
		} else if (current == tail) {
			this.prev();
			currentidx--;
			current.setNext(null);
		} else {
			SLink<T> rem = (SLink<T>) current.getNext();
			this.prev();
			currentidx--;
			current.setNext(rem);
		}
		leng--;		
	}
	
	/**
	 * Removes the item at a specific index
	 * @param idx index of item to remove
	 */
	public void remove(int idx){
		if (leng == 0) {
			System.out.println("No items to remove.");
			return;
		}
		if (idx > leng - 1 || idx < 0){
			System.out.println("Requested remove out of range.");
			return;
		}
		if (idx == 0) {
			if (current == head) { current = (SLink<T>) head.getNext(); }
			head = (SLink<T>) head.getNext();
			/* -- any way to set the previous head's Next value to null?
			SLink<T> secondLink = head.getNext();
			head.setNext(null);
			head = secondLink;
			*/
		} else {
			SLink<T> remidx = head;
			
			for (int i = 0; i < idx - 1; i++) {
				remidx = (SLink<T>) remidx.getNext(); //remidx points to the SLink before the remove target
			}
			
			if (remidx.getNext() == tail) { //or idx == maxidx
				if (current == tail) { 
					current = remidx;
					currentidx--;
				}
				tail = remidx;
				remidx.setNext(null);
			} else {
				SLink<T> remNext = (SLink<T>) remidx.getNext();
				remidx.setNext(remNext.getNext());
				if (currentidx >= idx) { currentidx--; }
			}
			
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
		if (sidx < 0 || didx < 0 || sidx > leng - 1 || didx > leng) {
			System.out.println("Requested move out of bounds.");
			return;
		}
		SLink<T> pointer = head;
		for (int i = 0; i < sidx; i++){
			pointer = (SLink<T>) pointer.getNext();
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
		T elm = current.getValue();
		return elm;
	}
	
	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch(int idx){
		SLink<T> fetchi = head;
		for (int i = 0; i < idx; i++) { fetchi = (SLink<T>) fetchi.getNext(); }
		return fetchi.getValue();
	}
	
	/**
	 * Advances the <i>current</i> index to the next index, if possible.
	 */
	public void next(){
		if (current != tail) {
			current = (SLink<T>) current.getNext();
			currentidx++;
		}	
	}
	
	/**
	 * Advances the <i>current</i> index to the previous index, if possible.
	 */
	public void prev(){
		if (current == head) {
			// System.out.println("CURRENT at beginning of list.");
			return;
		} else {
			SLink<T> prev = head;
			while ( (SLink<T>) prev.getNext() != current) {
				prev = (SLink<T>) prev.getNext();
			}
			current = prev;
			if (currentidx > 0) { currentidx--; }
		}
	}	
	/**
	 * Advances the <i>current</i> to the tail element
	 */
	public void jumpToTail(){
		current = tail;
		currentidx = leng - 1;
	}
	/**
	 * Advances the <i>current</i> to the head element
	 */
	public void jumpToHead(){
		current = head;
		currentidx = 0;
	}
	/**
	 * Returns the number of elements in the list
	 */
	public int size(){
		return leng;
	}	
}