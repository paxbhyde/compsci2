/**
 * Merge type sort implementation of ISort interface using new subarrays for each recursion.
 */
public class ArrayMergeSort<T extends Comparable> implements ISort<T> {
    String typeName = "Merge sort";
    /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public void sort(T[] in){
      if (in.length <= 1) {return;}
      int mid;
      if (in.length%2 != 0){ //odd number of elements
        mid = (in.length + 1) / 2; //first list will be one item longer than the second. if length = 41, mid = 21 (22nd index)
      } else {
        mid = (in.length / 2); // if length = 40, mid = 20 (21st index)
      }
      //how to do it "in place"?
      /*
      T[] sub = (T[]) new Comparable[in.length];
      */
      //split array into two
      T[] list1 = (T[]) new Comparable[mid];
      T[] list2 = (T[]) new Comparable[in.length - mid];
      for (int i = 0; i < mid; i++) { //mid = 21
        list1[i] = in[i];
        if (mid + i < in.length) {
          list2[i] = in[mid + i];
        }
      }
      //create the substitute array
      T[] sub = (T[]) new Comparable[in.length];

      this.sort(list1);
      this.sort(list2);
      //this.sortAux(list1, sub, 0, mid - 1);
      //this.sortAux(list2, sub, mid, in.length - 1);
      //merge...
      //pointers to current elements in list
      int curr1 = 0;
      int curr2 = 0;
      for (int i = 0; i < in.length; i++) {
        //if reached the end of one of the lists, take items from the other list
        //could use a ArrayOutOfBoundsException catch
        if (curr1 == list1.length && curr2 != list2.length) {
          in[i] = list2[curr2];
          curr2++;
        } else if (curr2 == list2.length && curr1 != list1.length) {
          in[i] = list1[curr1];
          curr1++;
        }
        //if have not reached the end of either list
        if (curr1 < list1.length && curr2 < list2.length){
          //compare items of the lists in order and assign to orig list
          if (list1[curr1].compareTo(list2[curr2]) < 0) { //!!
            in[i] = list1[curr1];
            curr1++;
          } else if (list1[curr1].compareTo(list2[curr2]) > 0) {
            in[i] = list2[curr2];
            curr2++;
          } else if (list1[curr1].compareTo(list2[curr2]) == 0) {
            in[i] = list1[curr1];
            in[i + 1] = list2[curr2];
            curr1++; curr2++; i++;
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
