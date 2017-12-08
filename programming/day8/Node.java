/**
 * Class of dictionary Node objects to place in the binary tree dictionary implementation.
 */
public class Node<K extends Comparable<K>, V>{
  private K key;
  private V value;
  private Node<K, V> rPt;
  private Node<K, V> lPt;
  private boolean isLeaf;

  /**
   * Node constructor sets the key and the value of the object.
   * @param K the key of the new Node
   * @param V the value to store in the new Node
   */
  public Node(K t, V p){
    key = t;
    value = p;
  }

  /**
   * Determines if the node is a leaf in the tree.
   * @return true if the node has no children, else false.
   */
  public boolean isLeaf(){
    if (lPt == null && rPt == null){
      return true;
    }
    return false;
   }

  /**
   * Gets the key of an Node object.
   * @return the key of the Node
   */
  public K getKey(){ return key; }

  /**
   * Gets the value stored in an Node object.
   * @return the value stored in the Node
   */
  public V getValue(){ return value; }

  /**
   * Sets the value stored in an Node object.
   * @param K the new value to be stored
   */
  public void setValue(V s){ value = s; }

  /**
   * Sets the key of the Node. (swaps?)
   * @param y the new key of the Node
   */
  public void setKey(K y){ key = y; }

  /**
   * Returns the pointer to the right child of the node.
   * @return the pointer to the right child
   */
  public Node<K, V> getRight(){ return rPt; }

  /**
   * Sets the pointer to the right child.
   * @param Node<K,V> the new right child node.
   */
  public void setRight(Node<K, V> nR){ rPt = nR; }

  /**
   * Returns the pointer to the left child of the node.
   * @return the pointer to the left child
   */
  public Node<K, V> getLeft(){ return lPt; }

  /**
   * Sets the pointer to the left child.
   * @param Node<K,V> the new left child node.
   */
  public void setLeft(Node<K, V> nL){ lPt = nL; }

}
