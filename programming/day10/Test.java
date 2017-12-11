import java.util.Random;

/**
 * Runs a performance test on sort algorithms using ISort interface and optionally prints a manual check for sortedness.
 */
public class Test {
    public static void main(String[] argv) {
        long s;
        long e;
        ISort[] sorts = new ISort[3];
        sorts[0] = new ArrayMergeSort<Integer>();
        sorts[1] = new MergeSort<Integer>();
        sorts[2] = new SelectSort<Integer>();

        Random r = new Random();
        // Process each algorithm
        for(int i=0; i<sorts.length; i++) {
            // Scale from 100 to 1000000 by 10s
            for(int l=101; l<1010000; l*=10) {
                // Prepare the array
                Integer[] a = new Integer[l];
                for(int j=0; j<l; j++) {
                    a[j] = r.nextInt();
                }
                // Time the sort
                s = System.currentTimeMillis();
                sorts[i].sort(a);
                e = System.currentTimeMillis();
                System.out.println("Sorted "+l+" items in "+(e-s)+"ms using "+sorts[i].sortName());
                /*
                //manual check if the items are sorted for the 100 item length list
                if (l == 101) {
                  for (int j = 0; j < 101; j++){
                    System.out.println(a[j]);
                  }
                }
                */
            }
            System.out.print("\n");
        }
    }
}
