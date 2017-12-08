/**
 * Class of dictionary entry objects to place in the list-based dictionary implementation.
 */
public class Entry<K extends Comparable<K>, V>{
  private K key;
  private V value;

  /**
   * Entry constructor sets the key and the value of the object.
   * @param K the key of the new Entry
   * @param V the value to store in the new Entry
   */
  public Entry(K t, V p){
    key = t;
    value = p;
  }

  /**
   * Gets the key of an Entry object.
   * @return the key of the Entry
   */
  public K getKey(){ return key; }

  /**
   * Gets the value stored in an Entry object.
   * @return the value stored in the Entry
   */
  public V getValue(){ return value; }

  /**
   * Sets the value stored in an Entry object.
   * @param K the new value to be stored
   */
  public void setValue(V s){ value = s; }

}
