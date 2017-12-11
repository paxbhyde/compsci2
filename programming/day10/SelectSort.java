/**
 * Selection sort type implementation of ISort interface.
 */
public class SelectSort<T extends Comparable> implements ISort<T> {
    String typeName = "Selection sort";
    /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public void sort(T[] in){
      if (in.length <= 1) {return;}
      for (int i = 0; i < in.length - 1; i++) {
        int lowidx = i;
        for (int j = i + 1; j < in.length; j++){
          if (in[j].compareTo(in[lowidx]) < 0){
            lowidx = j;
          }
        }
        T destVal = in[i];
        in[i] = in[lowidx];
        in[lowidx] = destVal;
      }
    }

    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName(){
      return typeName;
    }
}
