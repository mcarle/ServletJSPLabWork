import java.util.Scanner;

public class Main {
  public static int[] daysInMonth = {
      31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
  }; 

  public static void main(String[] args) {
    Scanner sc; 
    
    while(true) {
      try {
        sc = new Scanner(System.in); 
        System.out.println("Enter month name: ");
        String month = sc.nextLine(); 
        
        if("Quit".equalsIgnoreCase(month))
          break; 
        
       System.out.println("Enter day of month: ");
       int day = sc.nextInt(); 
       validateDate(month, day); 
       System.out.println("Date is valid!");
        
      } catch(BadMonthException bmEx) {
        System.out.println("ERROR: " + bmEx.getMessage());
      } catch(BadDayException bdEx) {
        System.out.println("ERROR: " + bdEx.getMessage());
      } catch(Exception ex) {
        System.out.println("Error occured! " + ex.getMessage());
      }
    }
  }
  
  public static void validateDate(String month, int day) throws BadMonthException, BadDayException {
    Month m; 
    try {
      m = Month.valueOf(month); 
    } catch(Exception ex) {
      throw new BadMonthException(ex); 
    }
    
    if (day < 1 || day > daysInMonth[m.ordinal()]) {
      throw new BadDayException("Day needs to be in domain 1 to " + daysInMonth[m.ordinal()]); 
    }
    
  }
}
