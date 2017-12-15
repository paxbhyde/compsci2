/**
 * Depth first graph search implementation.
 */
public class DepthFirstSearcher<N, W> implements ISearcher<N,W> {
    private INode<N> curr;

    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
      if (e.equals(s)) { return true; }

      curr = s;
      s.setMark(true);
      boolean found = false;

      IEdge<N, W>[] primeEdges = g.getEdgesFrom(s);
      if (primeEdges.length == 0) {
        System.out.println("No outgoing edges from " + s.getValue());
        //reset marks
        INode<N>[] nodes = g.getNodeSet();
        for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false); }
        return false;
      }

      for (int i = 0; i < primeEdges.length; i++){
        //check whether the dest of the first edge is visited
        if (!primeEdges[i].getDestination().getMark()){
          //pass curr along first edge
          curr = primeEdges[i].getDestination();
          found = pathExists(g, curr, e);
          curr.setMark(true);
          if (found) {
            //reset marks
            INode<N>[] nodes = g.getNodeSet();
            for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
            return true;
          }
        }
      }
      //reset marks
      INode<N>[] nodes = g.getNodeSet();
      for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
      return false; //if no trues are found
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
      if (s.equals(e)){
        IList<INode<N>> trigger = new SingleLinkList<INode<N>>();
        trigger.insert(0, s);
        return trigger;
      }
      //IList<INode<N>> path = new SingleLinkList<INode<N>>();
      //boolean pathcomplete = false;
      curr = s;
      s.setMark(true);
      //path.append(s);

      IEdge<N, W>[] primeEdges = g.getEdgesFrom(s);
      if (primeEdges.length == 0) {
        System.out.println("No outgoing edges from " + s.getValue());
        //reset marks
        INode<N>[] nodes = g.getNodeSet();
        for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
        return null;
      }

      for (int i = 0; i < primeEdges.length; i++){
        System.out.println(s.getValue() + " tried branch "+ i);
        //check whether the dest of the first edge is visited
        if (!primeEdges[i].getDestination().getMark()){
          //pass curr along first edge
          curr = primeEdges[i].getDestination();
          IList<INode<N>> gunpowder = this.getPath(g, curr, e);
          //check if the list has the requested search object
          gunpowder.jumpToTail();
          if (gunpowder.fetch().equals(e)) {
              gunpowder.insert(0, s);
              //reset marks etc.
              INode<N>[] nodes = g.getNodeSet();
              for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
              //return complete list.
              return gunpowder;
          }
        }
      }
      //reset marks
      INode<N>[] nodes = g.getNodeSet();
      for (int j = 0; j < nodes.length; j++){ nodes[j].setMark(false);}
      return null; //if nothing is found
    }
}
