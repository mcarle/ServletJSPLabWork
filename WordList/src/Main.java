import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set; 

public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader br = Files.newBufferedReader(new File("pg42671.txt").toPath()); 
      String line = null; 
      Set<String> words = new HashSet<>(); 
      while((line = br.readLine()) != null) {
        String[] vals = line.split("\\W+"); 
        for(String word : vals) {
          words.add(word.toLowerCase()); 
        }
      }
      
      // print out all words
      for(String word : words) {
        System.out.println(word);
      }
      
    } catch(IOException ioEx) {
      System.out.println("Error opening file: ");
      System.out.println(ioEx.getMessage()); 
      ioEx.printStackTrace();
    }
  }
}
