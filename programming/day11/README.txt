The files provided define an interface for a graph implementation. You will need to
implement the Graph, Node, and Edge classes. Additionally, you will need to implement
an IGraphReader that can read in a directed graph from a file. You are free to use any
of the data structures you have implemented this block to help with implementation of
your graph class.

The included graph file has three nodes and three edges. "node1" connects to "node2" with
an edge of weight 5.5, "node1" connects to "node3" with an edge of weight -0.2, and
"node2" connects to "node3" with a weight of 1.2.

Scaffold code for the class to read a graph from file has been provided. The value at
each node using the reader should be the String name of the node. Fill in the missing
logic for DiGraphReader.java; when the code is working you should get the following
output:
node1 -> node2  w: 5.5
node1 -> node3  w: -0.2
node2 -> node3  w: 1.2

Files:
IGraph.java - An interface for a graph implementation
INode.java  - An interface for nodes used by IGraph instances
IEdge.java  - An interface for edges used by IGraph instances
Node.java  – Implementation of a node class based on INode.java. Node values are mutable and do not recognize edge objects.
Edge.java  – Implementation of an edge class based on IEdge.java. Edge terminuses and weight are immutable.
Graph.java  – Implementation of a graph based on IGraph.java, using singly linked lists to hold nodes and edges.
IList.java  –  An interface for a list implementation (copied from compsci2 day4 scaffold code)
SingleLinkList.java –  Singly-linked list implementation of IList.java (copied from compsci2 day4 implementations)
ISLink.java - An interface for link cells in a singly-linked list (copied from compsci2 day4 scaffold code)
SLink.java  - Implementation for link cells in a singlely linked list (copied from compsci2 day4 implementations)
IGraphReader.java - An interface for classes that read in graphs
GraphReader.java – Implementation of a class to read graphs from files modelled on IGraph.java
                  and tests edgeSet, nodeSet, edgesTo, edgesFrom, and neighbors methods.
DiGraphReader.java - The start of an implementation of IGraphReader
graphfile.cs2 - A sample graph file containing 3 nodes and 3 edges
graphtest.cs2 – Another graph input file slightly longer than graphfile.cs2 for testing

Paxton Hyde - due 12/13/2017 – honor code upheld
