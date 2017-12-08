import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

public class removeTest<K extends Comparable<K>> {
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
      String[] allwords = new String[100];
      IDict<String,Integer> linear = new Dict<String,Integer>();
      IDict<String,Integer> tree   = new BSTree<String,Integer>();
      Random rand = new Random();
      tree.add("f", 1);
      tree.add("a", 2);
      tree.add("b", 2);
      tree.add("c", 2);
      tree.add("e", 2);
      tree.add("h", 3);
      tree.add("g", 3);
      tree.add("k", 3);
      tree.add("i", 3);
      System.out.println(tree.remove("f"));
      System.out.println(tree.remove("g"));
      System.out.println(tree.remove("a"));
      /*for(int i=0; i < 100; i++) {
          int idx = rand.nextInt(words.size());
          //allwords contains words in random order
          allwords[i] = words.fetch(idx);
          words.remove(idx);
          //dictionaries contain a random word, with i (value) corresponding to the order added
          linear.add(allwords[i],i);
          tree.add(allwords[i],i);
      }
      //remove 100 values and check the values against the values in allwords array
      for(int i = 99; i >= 0; i--){
        String thisOne = allwords[i];
        int listVal = linear.remove(thisOne);
          try {
          int binVal = tree.remove(thisOne);
          System.out.println(i+": "+thisOne+", "+listVal+", "+binVal);
        } catch (NullPointerException n) {
          System.out.println(allwords[i] + " not found in tree.");
        }
      }*/

  }
}
