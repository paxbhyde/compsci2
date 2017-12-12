/**
 * Implementation of an edge class based on IEdge.java. Edge terminuses and weight are immutable.
 */
public class Edge<N, W> implements IEdge<N,W> {
    // Implementors should implement a construct that takes in the
    // source, destination, and weight
    INode<N> a;
    INode<N> b;
    W w;

    /**
     * Constructor sets the node ends and the weight of the edge
     * @param first one of the nodes on the edge
     * @param second the other of the nodes on the edge
     * @param weight the weight of the edge
     */
    public Edge(INode<N> first, INode<N> second, W weight){
      a = first;
      b = second;
      w = weight;
    }

    /**
     * The source node of the edge
     * @return the source node
     */
    public INode<N> getSource(){
      return a;
    }

    /**
     * The destination node of the edge
     * @return the destination node
     */
    public INode<N> getDestination(){
      return b;
    }

    /**
     * The weight of the edge
     * @return the weight
     */
    public W getWeight(){
      return w;
    }

    /**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
    public boolean equals(Object o){
      Edge<N, W> other = (Edge<N, W>) o;
      if (this.a == other.getSource() && this.b == other.getDestination()){
        return true;
      } else { return false; }
    }
}
