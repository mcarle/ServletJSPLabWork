import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

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
      
      // print out all words
      for(String word : wordCount.keySet()) {
        System.out.println("Word " + word + " occurs " + wordCount.get(word) + " times");
      }
      
    } catch(IOException ioEx) {
      System.out.println("Error opening file: ");
      System.out.println(ioEx.getMessage()); 
      ioEx.printStackTrace();
    }
  }
}
