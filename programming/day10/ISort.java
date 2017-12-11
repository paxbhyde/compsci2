/**
 * Interface for classes that due sorts
 */
public interface ISort<T extends Comparable> {
    /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public void sort(T[] in);
    /**
     * Helper method for a sort() in place
     * @param in An array to sort
     * @param temp An empty array of equal length to in
     * @param l Start index of subsection of array to be sorted
     * @param r End index of subsection of array to be sorted 
    public void sortAux(T[] in, T[] temp, int l, int r);
    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName();
}
