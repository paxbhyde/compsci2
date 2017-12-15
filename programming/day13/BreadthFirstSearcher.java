/**
 * Breadth first graph search implementation.
 */
public class BreadthFirstSearcher<N, W> implements ISearcher<N, W> {
    IQueue<INode<N>> q;
    IQueue<ISLink<INode<N>>> p;
    INode<N> curr;

    //max size of queue
    public BreadthFirstSearcher(int m){
      q = new Queue<INode<N>>(m);
      p = new Queue<ISLink<INode<N>>>(m);
    }
    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) {
      boolean deadend = false;
      try { q.enqueue(s); } catch (OverFlowException o ) {
        System.out.println("bSearch error line 22");
        System.exit(0);
      }
      //while loop processing neighbors
      while (q.getSize() > 0) {
        deadend = false;
        //dequeue
        INode<N> next = null;
        try { next = q.dequeue(); } catch (UnderFlowException u ) {
          System.out.println("bSearch error line 28");
          System.exit(0);
        }
        if (next.equals(e)) {
          //reset marks & return true
          INode<N>[] nodes = g.getNodeSet();
          for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
          return true;
        }
        next.setMark(true);
        IEdge<N, W>[] primeEdges = g.getEdgesFrom(next);

        if (primeEdges.length == 0) {
          System.out.println("No outgoing edges from " + next.getValue());
          deadend = true;
        }
        if (!deadend){
          //queue up neighbors if unvisited
          for (int i = 0; i < primeEdges.length; i++) {

            INode<N> neighbor = primeEdges[i].getDestination();
            if (!neighbor.getMark()){
              try { q.enqueue(neighbor); } catch (OverFlowException o ) {
                System.out.println("bSearch error line 49");
                System.exit(0);
              }
            }
          }
        }
      }
      //reset marks
      INode<N>[] nodes = g.getNodeSet();
      for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
      return false;
    }

    /**
     * Finds a path based on the properties of the search algorithm.
     * If there is no path in graph g from node s to node e, null should be
     * returned. If node s and node e are the same, an empty list should be returned.
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return the list of nodes in the path
     */
    public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
      boolean deadend = false;
      //list to store final node list
      IList<INode<N>> trigger = new SingleLinkList<INode<N>>();
      //queue entries containing a node to be processed and a pointer to the parent than enqueued it.
      //if the end is found, the list can be built by tracing the pointers back to the start.
      ISLink<INode<N>> first = new SLink<INode<N>>(s, null);
      try { p.enqueue(first); } catch (OverFlowException o ) {
        System.out.println("bSearch error line 44");
        System.exit(0);
      }
      //while loop processing neighbors
      while (p.getSize() > 0) {
        deadend = false;
        //dequeue and unwrap the node
        ISLink<INode<N>> nextwrapped = null;
        try { nextwrapped = p.dequeue(); } catch (UnderFlowException u ) {
          System.out.println("bSearch error line 28");
          System.exit(0);
        }
        INode<N> next = nextwrapped.getValue();
        if (next.equals(e)) {
          //reset marks
          INode<N>[] nodes = g.getNodeSet();
          for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
          //follow the breadcrumbs back to s, to build the list
          trigger.insert(0, next);
          ISLink<INode<N>> crumb = nextwrapped.getNext();
          while (crumb.getNext() != null) {
            trigger.insert(0, crumb.getValue());
            crumb = crumb.getNext();
          }
          trigger.insert(0, s);
          return trigger;
        }
        next.setMark(true);
        IEdge<N, W>[] primeEdges = g.getEdgesFrom(next);
        if (primeEdges.length == 0) {
          System.out.println("No outgoing edges from " + next.getValue());
          deadend = true;
        }
        if (!deadend) {
          //queue up neighbors if unvisited
          for (int i = 0; i < primeEdges.length; i++) {
            INode<N> neighbor = primeEdges[i].getDestination();
            if (!neighbor.getMark()){
              //wrap nodes
              ISLink<INode<N>> queueup = new SLink<INode<N>>(neighbor, nextwrapped);
              try { p.enqueue(queueup); } catch (OverFlowException o ) {
                System.out.println("bSearch error line 44");
                System.exit(0);
              }
            }
          }
        }
      }
      //reset marks
      INode<N>[] nodes = g.getNodeSet();
      for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
      return null;
    }
}
