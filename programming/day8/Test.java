import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws Exception {
        // Read in some words
        System.out.println("Reading in the words");
        BufferedReader br=new BufferedReader(new FileReader("shortlist.txt"));
        // !!! Choose your favorite list implementation here !!!
        IList<String> words=new SingleLinkList<String>();
        String l=br.readLine();
        while(l!=null) {
            words.append(l);
            l=br.readLine();
        }

        System.out.println("Doing the inserts");
        // Add them to the dictionaries in random order
        String[] allwords = new String[words.size()];
        IDict<String,Integer> linear = new Dict<String,Integer>();
        IDict<String,Integer> tree   = new BSTree<String,Integer>();
        Random rand = new Random();
        long linearIns = 0;
        long treeIns = 0;
        long a; long b; long c;
        for(int i=0; words.size() > 0; i++) {
            int idx = rand.nextInt(words.size());
            allwords[i]=words.fetch(idx);
            words.remove(idx);
            a = System.currentTimeMillis();
            linear.add(allwords[i],i);
            b = System.currentTimeMillis();
            tree.add(allwords[i],i);
            c = System.currentTimeMillis();
            linearIns = linearIns + (b - a);
            treeIns = treeIns + (c - b);
        }
        System.out.println("List inserts took "+ linearIns + "ms");
        System.out.println("Tree inserts took "+ treeIns +"ms");


        System.out.println("Timing 100,000 fetches");
        long s;
        long e;
        rand.setSeed(0);
        s = System.currentTimeMillis();
        for(int i=0; i<100000; i++) {
            int idx = rand.nextInt(allwords.length);
            if(linear.fetch(allwords[idx]) != idx) {
                System.out.println("bad fetch "+allwords[idx]+" got "+linear.fetch(allwords[idx])+" should have "+idx);
            }
        }
        e = System.currentTimeMillis();
        System.out.println("List dict took "+(e-s)+"ms");
        rand.setSeed(0);
        s = System.currentTimeMillis();
        for(int i=0; i<100000; i++) {
            int idx = rand.nextInt(allwords.length);
            if(tree.fetch(allwords[idx]) != idx) {
                System.out.println("bad fetch "+allwords[idx]);
            }
        }
        e = System.currentTimeMillis();
        System.out.println("Tree dict took "+(e-s)+"ms");
    }
}
