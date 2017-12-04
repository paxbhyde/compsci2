/**
 * ArrayList class implementing IList interface, an array-based list that is resized as needed.
 */
public class ArrayList<T> implements IList<T> { // <T> is a generic (non-specific) variable type.

	private T[] array;
	private int leng;
	private int current = 0; //need an initial value.

	/**
	 * ArrayList constructor initializes an array of type <T> with length <i>leng</i>.
	 */
	public ArrayList() {
		array = (T[]) new Object[leng];
	}
    /**
     * Inserts an item at a specific index in the list, without changing <i>current</i>.
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v){
    	if (idx > leng || idx < 0) {
    		System.out.println("requested index out of range.");
    		System.exit(0);
    	}
    	
 		T[] insArray = (T[]) new Object[leng + 1];   	
 		
    	for (int i = 0; i <= leng; i++){
    		if (i < idx){
    			insArray[i] = array[i];
    		} else if (i == idx) {
    			insArray[i] = v;
    		} else {				// when i > idx
    			insArray[i] = array[i - 1];
    		}
    	}
    	leng++;
    	array = insArray;  	
    }
	/**
	 * Adds an item to the end of list. Called 'Add' in class, but more usually called 
	 * append in other libraries. Moves <i>current</i> to the end of the list.
	 * @param v Item to add
	 */
	public void append(T v){
		T[] appArray = (T[]) new Object[leng + 1];
		current = leng;
		
		for (int i = 0; i < leng; i++){
			appArray[i] = array[i];
		}
		appArray[leng] = v;
		leng++;
		array = appArray;
	}
	
	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes 
	 * the previous item in the list, if such element exists.
	 */
	public void remove(){
		T[] remArray = (T[]) new Object[leng - 1];
		
		for (int i = 0; i < leng - 1; i++){
			if (i < current) {
				remArray[i] = array[i];
			} else { 
				remArray[i] = array[i + 1];
			}
		}
		if (current > 0){
			current--;
		}
		leng--;
		array = remArray;
	}
	
	/**
	 * Removes the item at a specific index, without changing <i>current</i>.
	 * @param idx index of item to remove
	 */
	public void remove(int idx){
		T[] remIdxArray = (T[]) new Object[leng - 1];
		
		for (int i = 0; i < leng - 1; i++){
			if (i < idx) {
				remIdxArray[i] = array[i];
			} else { 
				remIdxArray[i] = array[i + 1];
			}
		}
		leng--;
		array = remIdxArray;	
	}
	
	/**
	 * Changes the location of an existing element in the list
	 * @param sidx - The initial index for the element to move
	 * @param didx - The final index for the element to move
	 */
	public void move(int sidx, int didx){
		if (sidx == didx) { return; } 
		
		//T[] moveArray = (T[]) new Object[leng];
		T elem = array[sidx];
		
		this.remove(sidx);
		this.insert(didx, elem);
		
		/*
		//remove function
		for (int i = 0; i < leng - 1; i++){
			if (i < sidx) {
				moveArray[i] = array[i];
			} else {
				moveArray[i] = array[i + 1];  
			}
		}
		moveArray[leng - 1] = 0;
		
		//insert function
		for (int j = 0; j < leng; j++){
    		if (j < didx){
    			moveArray[j] = array[j];
    		} else if (j == didx) {
    			moveArray[j] = elem;
    		} else {				// when j > didx
    			moveArray[j] = array[j - 1];
    		}
    	}
    	array = moveArray;
		*/
	}
	
	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public T fetch(){
		return array[current];
	}
	
	/**
	 * Fetches the value at a specific index in the list, without changing <i>current</i>.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch(int idx){
		return array[idx];
	}
	
	/**
	 * Advances the <i>current</i> index to the next index, if possible.
	 */
	public void next(){
		if (current < leng - 1){
			current++;
		}
	}
	
	/**
	 * Advances the <i>current</i> index to the previous index, if possible.
	 */
	public void prev(){
		if (current > 0){
			current--;
		}
	}
	
	/**
	 * Advances the <i>current</i> to the tail element
	 */
	public void jumpToTail(){
		current = leng - 1;
	}
	
	/**
	 * Advances the <i>current</i> to the head element
	 */
	public void jumpToHead(){
		current = 0;
	}

	/**
	 * Returns the number of elements in the list
	 */
	public int size(){
		return leng;
	}
}