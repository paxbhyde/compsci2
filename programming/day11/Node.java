/**
 * Implementation of a node class based on INode.java. Node values are mutable and do not recognize edge objects.
 */
public class Node<N> implements INode<N> {
    // Implementors should provide a constructor that takes in a single argument, the
    // value for the node to initially hold.
    N val;

    /**
     * Constructor sets the value of a new node
     * @param b new value
     */
     public Node(N b){
       val = b;
     }

    /**
     * Updates the value at the node
     * @param v new value
     */
    public void setValue(N v){
      val = v;
    }

    /**
     * Fetches the value at the node
     * @return the current value
     */
    public N getValue(){
      return val;
    }


    // No equals method should be implemented for Nodes since nodes are only equal if
    // they are exactly the same instance (which is the default behavior for objects
    // in java.
}
