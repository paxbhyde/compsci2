import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

public class keysTest<K extends Comparable<K>> {
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
      for(int i=0; i < 100; i++) {
          int idx = rand.nextInt(words.size());
          allwords[i]=words.fetch(idx);
          words.remove(idx);
          linear.add(allwords[i],i);
          tree.add(allwords[i],i);
      }
    //!!

    Comparable[] listKeys1 = linear.keys();
    System.out.println("\nunordered Linear list:");
    for(int i=0; i < linear.size(); i++) {
      System.out.println(i +" : "+listKeys1[i]);
    }

    Comparable[] treeKeys1 = tree.keys();
    System.out.println("\nordered Tree list:");
    for(int i=0; i < tree.size(); i++) {
      System.out.println(i +" : "+ treeKeys1[i]);
    }
  }
}
