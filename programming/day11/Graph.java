/**
 * Implementation of a graph based on IGraph.java, using singly linked lists to hold nodes and edges.
 */
public class Graph<N, W> implements IGraph<N, W> {
    SingleLinkList<INode<N>> nodes = new SingleLinkList<INode<N>>();
    SingleLinkList<IEdge<N, W>> edges = new SingleLinkList<IEdge<N, W>>();
    INode<N> curr = null;

    // No constructor needed for me

    /**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet(){
      INode<N>[] nodeset = new INode[nodes.size()];
        nodes.jumpToHead();
      for (int j = 0; j < nodes.size(); j++){
        nodeset[j] = nodes.fetch();
        nodes.next();
      }
      return nodeset;
    }

    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n){
      SingleLinkList<INode<N>> neighbs = new SingleLinkList<INode<N>>();
      edges.jumpToHead();
      for (int j = 0; j < edges.size(); j++){
        IEdge<N, W> examine = edges.fetch();
        //.equals? ==?
        if (examine.getSource().equals(n)) { neighbs.append(examine.getDestination()); }
        else if (examine.getDestination().equals(n)) { neighbs.append(examine.getSource()); }
        edges.next();
      }
      INode<N>[] neighbors = new INode[neighbs.size()];
      neighbs.jumpToHead();
      for (int i = 0; i < neighbs.size(); i++){
        neighbors[i] = neighbs.fetch();
        neighbs.next();
      }
      return neighbors;
    }

    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v){
      INode<N> plus = new Node<N>(v);
      nodes.append(plus);
      curr = plus;
      return plus;
    }

    /**
     * Gets an array of all the edges in the graph
     * @return the edge set
     */
    public IEdge<N, W>[] getEdgeSet(){
      IEdge<N, W>[] edgeset = new IEdge[edges.size()];
      edges.jumpToHead();
      for (int j = 0; j < edges.size(); j++){
        edgeset[j] = edges.fetch();
        edges.next();
      }
      return edgeset;
    }

    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
      SingleLinkList<IEdge<N,W>> srcEdges = new SingleLinkList<IEdge<N,W>>();
      edges.jumpToHead();
      for (int j = 0; j < edges.size(); j++){
        IEdge<N, W> examine = edges.fetch();
        if (examine.getSource().equals(n)) { srcEdges.append(examine); }
        edges.next();
      }
      IEdge<N,W>[] srcs = new IEdge[srcEdges.size()];
      srcEdges.jumpToHead();
      for (int i = 0; i < srcEdges.size(); i++){
        srcs[i] = srcEdges.fetch();
        srcEdges.next();
      }
      return srcs;
    }

    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n){
      SingleLinkList<IEdge<N,W>> dstEdges = new SingleLinkList<IEdge<N,W>>();
      edges.jumpToHead();
      for (int j = 0; j < edges.size(); j++){
        IEdge<N, W> examine = edges.fetch();
        //.equals? ==?
        if (examine.getDestination().equals(n)) { dstEdges.append(examine); }
        edges.next();
      }
      IEdge<N,W>[] dsts = new IEdge[dstEdges.size()];
      dstEdges.jumpToHead();
      for (int i = 0; i < dstEdges.size(); i++){
        dsts[i] = dstEdges.fetch();
        dstEdges.next();
      }
      return dsts;
    }


    /**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
    public void addEdge(INode<N> s, INode<N> d, W w){
      IEdge<N, W> newE = new Edge<N, W>(s, d, w);
      edges.append(newE);
    }
}
