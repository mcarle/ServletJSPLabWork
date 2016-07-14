import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); 
    
    while(true) {
      System.out.println("Enter src file name: ");
      String srcPath = sc.nextLine(); 
      
      FileChannel inChannel = null; 
      FileChannel outChannel; 
      try {
        File sF = new File(srcPath); 
        if(!sF.exists()
            || !sF.isFile()) {
          System.out.println("Invalid path provided for source file!");
          continue; 
        }
        
        System.out.println("Enter target file name: ");
        String tPath = sc.nextLine(); 
        
        // open files and copy content
        File oF = new File(tPath); 
        inChannel = new FileInputStream(sF).getChannel(); 
        outChannel = new FileOutputStream(oF).getChannel(); 
        outChannel.transferFrom(inChannel, 0, inChannel.size()); 
        
        System.out.println("Copy complete!");
        break; 
      } catch(FileNotFoundException fnfEx) {
        System.out.println("Target output file counld not be found: ");
        System.out.println(fnfEx.getMessage());
      } catch (SecurityException secEx) {
        System.out.println("Invalid permissions to execute operation: ");
        System.out.println(secEx.getMessage());
      } catch(IOException ioEx) {
        System.out.println("IO failure: ");
        System.out.println(ioEx.getMessage());
      } 
    }
  }
}
