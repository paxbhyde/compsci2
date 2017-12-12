import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.PatternSyntaxException;
/**
 * Implementation of a class to read graphs from files modelled on IGraph.java and tests edgeSet, nodeSet, edgesTo, edgesFrom, and neighbors methods.
 * BufferedReader code idea lifted from compsci2/day8/Test.java scaffold code
 */
public class GraphReader implements IGraphReader {
    /**
     * Constructor doesn't need to do anything, because we create a new reader object for each filename.
     */
    public GraphReader() {}
    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     * @throws FileNotFoundException if the file name is bogus
     * @throws IOException if there are problems reading the file
     */
    public IGraph<String, Double> read(String filename) throws FileNotFoundException, IOException{
      BufferedReader reader = null;
      try {
        reader = new BufferedReader(new FileReader(filename));
      } catch (FileNotFoundException f) {
        System.out.println("Input file not found.");
        System.exit(0);
      }
      Graph<String, Double> g = new Graph<String, Double>();
      /* input
      node1:node2:5.5
      node1:node3:-0.2
      node2:node3:1.2
      */
      //list of strings to store as new node values
    //  SingleLinkList<Node<String>> uniqueNodes = new SingleLinkList<Node<String>>();
      String l = null;
      try {
         l = reader.readLine();
      } catch (IOException q) {
        System.out.println("First line not read.");
        q.toString();
        System.exit(0);
      }
      //read through file, adding edges to graph (unique based on file format), adding unique nodes to the sll nodesToAdd
      int errctr = 1;
      while(l != null) {
          String[] items = null;
          try {
             items = l.split(":");
          } catch (PatternSyntaxException p){
            System.out.println("Bad input syntax, line " + errctr);
            System.exit(0);
          }
          //construct the new nodes and check if the nodes are repeats
          boolean matchfirst = false;
          INode<String> matcha = null;
          boolean matchsecond = false;
          INode<String> matchb = null;
          g.nodes.jumpToHead();
          for (int i = 0; i < g.nodes.size(); i++){
            String compare = g.nodes.fetch().getValue();
            //compare values of this line nodes and nodes already in list
            if (compare.equals(items[0])) {
              matchfirst = true;
              matcha = g.nodes.fetch();
            }
            if (compare.equals(items[1])) {
              matchsecond = true;
              matchb = g.nodes.fetch();
            }
            g.nodes.next();
          }
          //add new edges and unique nodes to graph
          double newW = Double.parseDouble(items[2]);
          if (!matchfirst && !matchsecond) {
            g.addEdge(g.addNode(items[0]), g.addNode(items[1]), newW); //nodes are created in both the sll and the graph
          } else if (!matchfirst && matchsecond) {
            g.addEdge(g.addNode(items[0]), matchb, newW);
          } else if (matchfirst && !matchsecond) {
            g.addEdge(matcha, g.addNode(items[1]), newW);
          } else if (matchfirst && matchsecond) {
            g.addEdge(matcha, matchb, newW);
          }
          //read next line
          try {
             l = reader.readLine(); //moves the reader to the next line
          } catch (IOException p) {
            System.out.println("Line " + errctr + " not read.");
            p.toString();
            System.exit(0);
          }
          errctr++;
      }
      return g;
    }
    /**
     * Simple main method to open and process a file, copied from DiGraphReader.java - compsci2 day11 scaffold code
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new GraphReader();
        Graph<String,Double> g = (Graph<String,Double>) r.read("graphtest.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        System.out.print("All edges\n");
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
        System.out.print("\nEdges from node5\n");
        IEdge<String,Double>[] edgesFrom = g.getEdgesFrom(g.nodes.fetch(4));
        for(int i=0; i<edgesFrom.length; i++) {
            System.out.println(edgesFrom[i].getSource().getValue()+" -> "+edgesFrom[i].getDestination().getValue()+"  w: "+edgesFrom[i].getWeight());
        }
        System.out.print("\nEdges to node1\n");
        IEdge<String,Double>[] edgesTo = g.getEdgesTo(g.nodes.fetch(0));
        for(int i=0; i<edgesTo.length; i++) {
            System.out.println(edgesTo[i].getSource().getValue()+" -> "+edgesTo[i].getDestination().getValue()+"  w: "+edgesTo[i].getWeight());
        }
        System.out.print("\nAll nodes\n");
        INode<String>[] nodes = g.getNodeSet();
        for(int i=0; i<nodes.length; i++) {
            System.out.println(nodes[i].getValue());
        }
        System.out.print("\nNeighbors of node6\n");
        INode<String>[] neighbors = g.getNeighbors(g.nodes.fetch(5));
        for(int i=0; i<neighbors.length; i++) {
            System.out.println(neighbors[i].getValue());
        }
    }

}
