/**
 * Implementation of a node class based on INode.java. Node values are mutable and do not recognize edge objects.
 */
public class Node<N> implements INode<N> {
    // Implementors should provide a constructor that takes in a single argument, the
    // value for the node to initially hold.
    N val;
    boolean mark;

    /**
     * Constructor sets the value of a new node
     * @param b new value
     */
     public Node(N b){
       val = b;
       mark = false;
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
    /**
     * Updates the mark at the node
     * @param a new mark value
     */
    public void setMark(boolean a){
      mark = a;
    }

    /**
     * Fetches the mark at the node
     * @return the current mark value
     */
    public boolean getMark(){
      return mark;
    }

    // No equals method should be implemented for Nodes since nodes are only equal if
    // they are exactly the same instance (which is the default behavior for objects
    // in java.
}
