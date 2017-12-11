/**
 * Merge type sort implementation of ISort interface without new array writes.
 */
public class MergeSort<T extends Comparable> implements ISort<T> {
    String typeName = "in-place Merge sort";
    /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public void sort(T[] in){
      if (in.length <= 1) { return; }
      //create the substitute array
      T[] sub = (T[]) new Comparable[in.length];
      //recursive call sortAux
      this.sortAux(in, sub, 0, in.length - 1);
      }
    /**
     * Helper method for a sort() in place
     * @param in An array to sort
     * @param temp An empty array of equal length to in
     * @param l Start index of subsection of array to be sorted
     * @param r End index of subsection of array to be sorted
     */
    public void sortAux(T[] in, T[] temp, int l, int r){
      if (l == r) { return; } //length 1 array
      int length = r - l + 1;
      int mid;
      if (length%2 != 0){ //odd number of elements
        mid = l + ((length + 1) / 2); //first pseudolist will be one item longer than the second. if length = 41 (0-40 index), mid = 21 (index "20", 21st item )
      } else {
        mid = l+ (length / 2); // if length = 40, mid = 20 (21st item)
      }
      //pass down two halves
      this.sortAux(in, temp, l, mid - 1);
      this.sortAux(in, temp, mid, r);
      //merge...
      //copy values to subsection of temp
      for (int i = l; i < r + 1; i++){
        temp[i] = in[i];
      }
      //pointers to current elements in temp
      int curr1 = l;
      int curr2 = mid;

      for (int j = 0; j < length; j++) {
        //if reached the end of one of the lists, take items from the other list
        if (curr1 == mid && curr2 != r + 1) {
          in[l + j] = temp[curr2];
          temp[curr2] = null;
          curr2++;
        } else if (curr2 == r + 1 && curr1 != mid) {
          in[l + j] = temp[curr1];
          temp[curr1] = null;
          curr1++;
        }
        //if have not reached the end of either list
        if (curr1 < mid && curr2 < r + 1){
          //compare items of the lists in order and assign to orig list
          if (temp[curr1].compareTo(temp[curr2]) < 0) {
            in[l + j] = temp[curr1];
            temp[curr1] = null;
            curr1++;
          } else if (temp[curr1].compareTo(temp[curr2]) > 0) {
            in[l + j] = temp[curr2];
            temp[curr2] = null;
            curr2++;
          } else if (temp[curr1].compareTo(temp[curr2]) == 0) { //should test this section really
            in[l + j] = temp[curr1];
            in[l + j + 1] = temp[curr2];
            temp[curr1] = temp[curr2] = null;
            curr1++; curr2++; j++;
          }
        }
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
