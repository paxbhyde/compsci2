/**
 * Interface for a generic fixed length queue
 */
public interface IQueue<T> {
    /**
     * Dequeues the Front element from the queue
     * @return dequeued element
     * @throws UnderFlowException if dequeueing an empty queue
     */
    public T dequeue() throws UnderFlowException;

    /**
     * Enqueues an element at the back of the queue
     * @param v enqueued element
     * @throws OverFlowException if enqueueing a full queue
     */
    public void enqueue(T v) throws OverFlowException;

    /**
     * Returns the current number of items in the queue.
     * @return the current length of the queue
     */
    public int getSize();

}
