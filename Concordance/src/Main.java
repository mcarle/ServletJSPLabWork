import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader br = Files.newBufferedReader(new File("pg42671.txt").toPath()); 
      String line = null; 
      Map<String, Integer> wordCount = new HashMap<>(); 
      while((line = br.readLine()) != null) {
        String[] vals = line.split("\\W+"); 
        for(String word : vals) {
          String lwrWrd = word.toLowerCase(); 
          if (wordCount.containsKey(lwrWrd)) {
            wordCount.put(lwrWrd, wordCount.get(lwrWrd) + 1); 
          } else {
            wordCount.put(lwrWrd, 1); 
          }
        }
      }
      
      /* print out all words
      for(String word : wordCount.keySet()) {
        System.out.println("Word " + word + " occurs " + wordCount.get(word) + " times");
      }*/
      
      List<Map.Entry<String, Integer>> wordList
        = new ArrayList<>(wordCount.entrySet()); 
      
      wordList.sort(new Comparator<Entry<String, Integer>>() {

        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
          return o1.getValue().compareTo(o2.getValue()) ;
        }
      });
      
      for(Entry<String, Integer> entry : wordList) {
        String word = entry.getKey(); 
        System.out.println("Word " + word + " occurs " + wordCount.get(word) + " times");
      }
        
      
    } catch(IOException ioEx) {
      System.out.println("Error opening file: ");
      System.out.println(ioEx.getMessage()); 
      ioEx.printStackTrace();
    }
  }
}
