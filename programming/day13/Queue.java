/**
 * Link-based implementation of queue interface IQueue.
 */
public class Queue<T> implements IQueue<T> {

	private Link<T> front;
	private Link<T> back;
	private int leng;
	private int maxsize;

	/**
	 * Queue constructor takes the maxsize and initializes <i>leng</i> to zero.
	 * @ param m the maxsize of the queue
	 */
	public Queue(int m){
		maxsize = m;
		leng = 0;
	}

    /**
     * Dequeues the Front element from the queue
     * @return dequeued element
     * @throws UnderFlowException if dequeueing an empty queue
     */
    public T dequeue() throws UnderFlowException{
    	if (leng == 0) {
    		System.out.println("queue empty.");
    		throw new UnderFlowException();
    	}

    	T val = front.getValue();
		Link<T> ptr = front.getNext();
		front.setNext(null);
		front = ptr;
		leng--;

		//System.out.println("token dequeued.");
    	return val;

    }

    /**
     * Enqueues an element at the back of the queue
     * @param v enqueued element
     * @throws OverFlowException if enqueueing a full queue
     */
    public void enqueue(T v) throws OverFlowException{
    	if (leng >= maxsize) {
    		System.out.println("queue overflow.");
    		throw new OverFlowException();
    	}

    	Link<T> nouveau = new Link<T>(v, null);
    	if (front == null) {
    		front = nouveau;
    	} else {
    		back.setNext(nouveau);
    	}
    	back = nouveau;
    	leng++;
    	//System.out.println("token queued.");
    }

		/**
     * Returns the current number of items in the queue.
     * @return the current length of the queue
     */
		public int getSize(){
			return leng;
		}
}
