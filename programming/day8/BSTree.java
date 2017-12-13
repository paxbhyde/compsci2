/**
 * Binary tree implementation of IDict. Remove still to be tested
 */
public class BSTree<K extends Comparable<K>,V> implements IDict<K, V> {
    private Node<K, V> curr;
    Node<K, V> root;
    private int size;
    private SingleLinkList<Node> inorderSll; //used for the keys method
    /**
     * BSTree constructor sets the curr pointer to the root and instatiates the inorderSll list.
     */
     public BSTree(){
       curr = root;
       inorderSll = new SingleLinkList<Node>();
     }

    /**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param p key for the new value
     * @param q value
     * @return the value replaced, otherwise null
     */
    // options >> (0) add to empty tree (1) find match and replace
    // (2) fit at the end (3) move to the end and swap up
    public V add(K p, V q){
      curr = root;
      //0 empty tree case
      if (root == null) {
        Node<K, V> plus = new Node<K, V>(p, q);
        root = plus;
        size++;
        return null;
      }
      //option 1
      //move down the tree trying to find a match until reach a leaf
      boolean deadend = false;
      while ( deadend == false && p.compareTo(curr.getKey()) != 0 ) {
        //other wise place with one of the current children and save a pointer to parent
        if (p.compareTo(curr.getKey()) < 0 && curr.getLeft() != null){
          curr = curr.getLeft();
        } else if (p.compareTo(curr.getKey()) > 0 && curr.getRight() != null){
          curr = curr.getRight();
        }
        if ((p.compareTo(curr.getKey()) < 0 && curr.getLeft() == null) ||
            (p.compareTo(curr.getKey()) > 0 && curr.getRight() == null)){
          deadend = true;
        }
      }
      //matching key is found, change the value in the existing node and return the old value
      if (p.compareTo(curr.getKey()) == 0) {
        V replaced = (V) curr.getValue();
        curr.setValue(q);
        return replaced;
      }
      //option 2
      //failed to match, move down the tree a second time looking for an empty space
      curr = root;
      while (curr != null) {
        //check if the current node has the right empty space or is a leaf.
        if((p.compareTo(curr.getKey()) < 0 && curr.getLeft() == null) || //...
          (p.compareTo(curr.getKey()) > 0 && curr.getRight() == null) ){
            if(p.compareTo(curr.getKey()) < 0) {
                curr.setLeft(new Node<K, V>(p, q));
            } else {
                curr.setRight(new Node<K, V>(p, q));
            }
            size++;
            return null;
        }
        if (p.compareTo(curr.getKey()) < 0){
          curr = curr.getLeft();
        } else {
          curr = curr.getRight();
        }
      }
      //move down the tree a fourth time looking for an intermediate place
      curr = root;
      Node<K, V> cParent = curr;
      while (curr != null) {
        //...
        //option 3
        //check to see if new key fits on a spot with two children
        //line 67 is TRUE if key < key of curr right child & key > key of curr left child
        if (p.compareTo((K) curr.getRight().getKey()) < 0 && p.compareTo((K) curr.getLeft().getKey()) > 0 ){
          Node<K, V> plus = new Node<K, V>(p, q);
          // p < insertMark key
          if (p.compareTo(curr.getKey()) < 0){
            plus.setRight(curr);
            plus.setLeft(curr.getLeft());
            if (cParent.getLeft() == curr) { cParent.setLeft(plus); } else {cParent.setRight(plus);}
            curr.setLeft(null);
            size++;
            System.out.println("node added method 3");
            return null;
          // p > insertMark key
          } else if (p.compareTo(curr.getKey()) > 0) {
            plus.setLeft(curr);
            plus.setRight(curr.getRight());
            if (cParent.getRight() == curr) { cParent.setRight(plus); } else {cParent.setLeft(plus);}
            curr.setRight(null);
            size++;
            System.out.println("node added method 3");
            return null;
          }
        }
        //place with a child and save a pointer to parent
        if (curr.getRight() != null || curr.getLeft() != null) {
          if (p.compareTo(curr.getKey()) < 0){
            cParent = curr;
            curr = curr.getLeft();
          } else {
            cParent = curr;
            curr = curr.getRight();
          }
        }
      }

      //impossible catch
      System.out.println("add failed");
      return null;
    }

    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k){
      curr = root;
      Node<K, V> parent = curr;
      //empty tree case
      //not getting this anymore
      if (root == null) {
        System.out.println("Nothing to remove from tree.");
        return null;
      }
      //while we have not found the right key
      while (k.compareTo(curr.getKey()) != 0){
        //place with one of the current children
        if (k.compareTo(curr.getKey()) < 0){
          parent = curr;
          curr = curr.getLeft();
        } else if (k.compareTo(curr.getKey()) > 0) {
          parent = curr;
          curr = curr.getRight();
        }
        //check if there was a failure with the fetch
        //not getting this
        if (curr == null) {
          System.out.println("No matching key.");
          return null;
        }
      }
      //register the value to be removed
      //!!!from this point out curr marks the value to be removed
      V removed = (V) curr.getValue();
      if (curr.equals(root)) {
        //compare the children
        if (curr.isLeaf()) { size = 0; return root.getValue(); }
        //if one, new root is that child
        if (curr.getLeft() == null && curr.getRight() != null) {
            root = curr.getRight();
        } else if (curr.getLeft() != null && curr.getRight() == null) {
            root = curr.getLeft();
        }
        //if two, new root should be reassigned by 2 children method
      }
    //this is the only scenario that works
    //if isLeaf() == true, kill the node easy
    //this works flawlessly (because if removed from idx 100 to 0 it works)
      if (curr.isLeaf() == true){
        if (parent.getRight() == curr) { parent.setRight(null); }
        if (parent.getLeft() == curr) { parent.setLeft(null); }
        size--;
        return removed;
      }
    //if a node has one child, replace with child. (possibly redundant)
    //this looks airtight
      if ( (curr.getLeft() == null && curr.getRight() != null) ||
              (curr.getLeft() != null && curr.getRight() == null) ){
        if (parent.getRight().equals(curr)) {
          //if not root, assign parent pointer to correct child
           if (curr.getLeft() == null){
                parent.setRight(curr.getRight());
           }
           if (curr.getRight() == null){
                parent.setRight(curr.getLeft());
           }
        }
        else if (parent.getLeft().equals(curr)) {
           if (curr.getLeft() == null){
                parent.setLeft(curr.getRight());
           }
           if (curr.getRight() == null){
               parent.setLeft(curr.getLeft());
           }
        }

         size--;
         return removed;
      }
    //if 2 children, from node to remove go right once then left until can't
    //remove that node and set as value originally wanted to remove
      Node<K, V> swapParent = curr;   //replace with parent
      Node<K, V> swap = curr.getRight();
    //move to leftmost node in right subtree of root
    int counter = 0;
      while (swap.getLeft() != null){
        swapParent = swap;
        swap = swap.getLeft();
        counter++;
      }
    //reached leftmost node
      if (swap.getRight() == null){
        curr.setValue((V) swap.getValue());
        curr.setKey((K) swap.getKey());
        swapParent.setLeft(null);
        //if (currRoot) { };
        size--;
        return removed;
      } else if (swap.getRight() != null){
        curr.setValue((V) swap.getValue());
        curr.setKey((K) swap.getKey());
        if (counter == 0) {
          swapParent.setRight(swap.getRight());
        } else {
          swapParent.setLeft(swap.getRight());
        }
        size--;
        return removed;
      }
      //impossible case
      System.out.println("impossible");
      return null;
    }

    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size(){ return size; }

    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k){
      curr = root;
      while (k.compareTo(curr.getKey()) != 0){
        if (curr == null) { return null; }     //!!is this the way to check for no result? .isLeaf()?
        if (k.compareTo(curr.getKey()) > 0){
          curr = curr.getRight();
        } else {
          curr = curr.getLeft();
        }
      }
      return curr.getValue();
    }
    /**
     * Returns an ordered array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys(){
      K[] keyList = (K[]) new Comparable[size];
      this.inorder(root);
      inorderSll.jumpToHead();
      for(int i = 0; i < size; i++){
        //try {
        Node<K, V> next = inorderSll.fetch();
        //} catch
        K cKey = next.getKey();
        keyList[i] = cKey;
        inorderSll.next();
      }
      return keyList;
    }
    /**
     * Adds all nodes in the tree to SingleLinkList inorderSll
     * @param the root of the tree to be traversed
     */
    public void inorder(Node<K, V> rooot){
      curr = rooot;
      if (rooot == null) { return; }
      if (curr.isLeaf() == true) {
        inorderSll.append(curr);
        return;
      }
      if (curr.getLeft() != null) {
        curr = curr.getLeft();
        inorder(curr);
      }
      curr = rooot;
      inorderSll.append(rooot);
      if (curr.getRight() != null) {
        curr = curr.getRight();
        inorder(curr);
      }
    }
}
