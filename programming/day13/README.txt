You should copy in your graph implementation from day11 including the DiGraphReader. You will use your graph implementation to support implementing two different path finding algorithms.
DepthFirstSearcher will implement a depth first graph search and conform to the ISearcher interface. BreadthFirstSearcher will implement a breadth first graph search and conform to the ISearcher interface.

We will test your searcher implementations with several graph files. Sometimes a path will exist from the starting node to the target node, sometimes there will not be a path.

You should feel free to use any data structures you have implemented earlier in the block when implementing your searchers.

Files:
BreadthFirstSearcher.java – Breadth first graph search implementation.
DepthFirstSearcher.java   – Depth first graph search implementation.
DiGraphReader.java   – Implementation of a class to read graphs from files modelled on IGraph.java
                     and tests edgeSet, nodeSet, edgesTo, edgesFrom, and neighbors methods. (copied from day11)
Edge.java          – Implementation of an edge class from IEdge.java. Edge terminuses and weight are immutable. (copied from day11)
Graph.java         – Implementation of a graph from IGraph.java, using singly linked lists to hold nodes and edges. (copied from day11)
GraphSearchTest.java – Class to test depth-first and breadth-first search implementations.
graphfile.cs2      - A simple graph file for a basic test.
graphtest.cs2      – A longer graph input file for testing.
graphtest2.cs2     – An even longer and more complicated graph input file for testing.
IEdge.java         - An interface for edges used by IGraph instances
IGraph.java        - An interface for a graph implementation
IList.java         –  An interface for a list implementation (copied from compsci2 day4 scaffold code)
INode.java         - An interface for nodes used by IGraph instances
IGraphReader.java  - An interface for reading in graph files
IQueue.java        – Interface for a generic fixed length queue (copied from day4)
ISearcher.java     - An interface for classes that provide graph searches.
ISLink.java        - An interface for link cells in a singly-linked list (copied from compsci2 day4 scaffold code)
Link.java          – ink class implementation adapted from ISLink<T> interfact from CS2 day4 programming assignment for building a linked stack and queue. (copied from RPN)
Node.java          - Implementation of a node class from INode.java. Node values are mutable and do not recognize edge objects. (copied from day11)
OverFlowException.java – Empty exception class for queue overflow. (lifted from RPN scaffold code)
Queue.java         – Link-based implementation of queue interface IQueue. (copied from RPN implementations)
SingleLinkList.java –  Singly-linked list implementation of IList.java (copied from day4 implementations)
SLink.java         - Implementation for link cells in a singlely linked list (copied from day4 implementations)
UnderFlowException.java – Empty exception class for queue underflow. (lifted from RPN scaffold code)

Paxton Hyde - 12/15/2017 - honor code upheld
