/**
 * A singly-linked list backed implementation of the IDict interface.
 */
public class Dict<K extends Comparable<K>,V> implements IDict<K, V> {
      private int leng;
      SingleLinkList<Entry> sll;   //T is the key of the dictionary (a string)

      /**
       * ListDict constructor creates a new SingleLinkList object to hold dictionary Entry objects.
       */
      public Dict(){
        sll = new SingleLinkList<Entry>();
      }
      /**
       * Adds a value to the dictionary, replacing the existing value if any.
       * @param k key for the new value
       * @param v value
       * @return the value replaced, otherwise null
       */
      public V add(K p, V q){
        sll.jumpToHead();
        for (int i = 0; i < sll.size(); i++) {
          Entry scanner = sll.fetch();
          K scan = (K) scanner.getKey(); //!!cast
          if (scan.compareTo(p) == 0){
            V replaced = (V) scanner.getValue(); //!!cast
            scanner.setValue(q);
            return replaced;
          }
          sll.next();
        }
        Entry plus = new Entry(p, q);
        sll.append(plus);
        leng++;
        return null;
      }

      /**
       * Removes a value and key from the dictionary. An unmatched key should return null.
       * @param k key to remove
       * @return the value of the removed key
       */
      public V remove(K p){
        sll.jumpToHead();
        for (int i = 0; i < sll.size(); i++) {
          Entry scanner = sll.fetch();
          K scan = (K) scanner.getKey(); //!!cast
          if (scan.compareTo(p) == 0){
            V removed = (V) scanner.getValue(); //!!cast
            sll.remove();
            return removed;
          }
          sll.next();
        }
        leng--;
        return null;
      }

      /**
       * Returns the size of the dictionary
       * @return the number of values stored in the dictionary
       */
      public int size(){
        return leng;
      }

      /**
       * Returns the value associated with a particular key in the dictionary.
       * Returns null if there is no matching key.
       * @param k key to retrieve the value for
       * @return the value
       */
      public V fetch(K k){
        sll.jumpToHead();
        for (int j = 0; j < sll.size(); j++){ //could do a faster search?
          Entry fetcher = sll.fetch();
          K f = (K) fetcher.getKey(); //!!cast
          if (f.compareTo(k) == 0){
            return (V) fetcher.getValue(); //!!cast
          }
          sll.next();
        }
        return null;
      }

      /**
       * Returns an unordered array of the keys in the dictionary
       * @return array of all keys
       */
      public K[] keys(){
        K[] keyA = (K[]) new Comparable[sll.size()];
        sll.jumpToHead();
        for (int i = 0; i < sll.size(); i++){
          Entry<K, V> getter = sll.fetch();
          K kVal = getter.getKey();
          keyA[i] = kVal;
          sll.next();
        }
        return keyA;
      }

  }
