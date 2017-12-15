import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * Test class for depth-first and breadth-first search implementations.
 */
 public class GraphSearchTest{
    public static void main(String[] argv){
      // This code should work without modification once your reader code is working
      IGraphReader r = new DiGraphReader();
      Graph<String,Double> g = null;
      try {
        g = (Graph<String,Double>) r.read("graphtest2.cs2");
      } catch (FileNotFoundException f) {
        System.out.println("file not found.");
        f.toString();
      } catch (IOException i) {
        i.toString();
      }
      IEdge<String,Double>[] edges = g.getEdgeSet();
      System.out.print("All edges\n");
      for(int i=0; i<edges.length; i++) {
          System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
      }

      System.out.println("::: Depth-first test :::");

      DepthFirstSearcher<String, Double> dSearch = new DepthFirstSearcher<String, Double>();
      INode<String>[] allNodes = g.getNodeSet();
      for (int i = 0; i<allNodes.length; i++){
        System.out.println(i +", " +allNodes[i].getValue());
      }
      INode<String> start = allNodes[5];
      INode<String> end = allNodes[2];
      System.out.println("Looking for a path from "+ start.getValue() +" to "+ end.getValue());
      if (dSearch.pathExists(g, start, end)){
        System.out.println("Path found.");
        IList<INode<String>> path = dSearch.getPath(g, start, end);
        path.jumpToHead();
        for (int p = 0; p < path.size(); p++){
          System.out.println(path.fetch().getValue());
          path.next();
        }
      } else {
        System.out.println("No path found.");
      }

      System.out.println("::: Breadth-first test :::");

      BreadthFirstSearcher<String, Double> bSearch = new BreadthFirstSearcher<String, Double>(100);
      INode<String> s = allNodes[10];
      INode<String> e = allNodes[0];
      System.out.println("Looking for a path from "+ s.getValue() +" to "+ e.getValue());
      if ( bSearch.pathExists(g, s, e) ){
        System.out.println("Path found.");
        IList<INode<String>> path = bSearch.getPath(g, s, e);
        path.jumpToHead();
        for (int p = 0; p < path.size(); p++){
          System.out.println(path.fetch().getValue());
          path.next();
        }
      } else {
        System.out.println("No path found.");
      }
    }

 }
