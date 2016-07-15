import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate; 

public class Main {
  public static void main(String[] args) {
    List<String> ls = Arrays.asList(
        "Fred", "Jim", "William", "Susannah", "Lucy", "Orinoco", "Toby"
      );
      
      List<String> longStrings = filterList(ls,(val) 
          -> val.length() > 6); 
      assert longStrings.size() == 3;
      assert longStrings.get(0).equals("William");
      assert longStrings.get(1).equals("Susannah");
      assert longStrings.get(2).equals("Orinoco");
      
      List<String> charRngStrings = filterList(ls, (val)
          -> val.charAt(0) >= 'A' && val.charAt(0) <= 'M'); 
      assert charRngStrings.size() == 3; 
      

      List<String> minOccStrings = filterList(ls, (val)
          -> (val.length() - val.replace("l", "").length()) >= 2); 
      assert minOccStrings.size() == 1; 
      assert minOccStrings.get(0).equals("William"); 
      
      List<Integer> ints = Arrays.asList(
          5, 25, -10, 30, 60, -160);
      
      List<Integer> aboveMin = filterList(ints, (val)
          -> val >= 0);    
      
      assert aboveMin.size() == 4; 
      assert aboveMin.get(0) == 5; 
      assert aboveMin.get(1) == 25; 
      assert aboveMin.get(2) == 30; 
      assert aboveMin.get(3) == 60; 
      
      List<LocalDate> dates = Arrays.asList(
          LocalDate.of(2015, 1, 14), 
          LocalDate.of(2018, 3, 14),
          LocalDate.of(2016, 7, 15)
       );
      
      List<LocalDate> afterThresh = filterList(dates, (val) 
          -> val.getYear() >= 2016); 
      
      assert afterThresh.size() == 2; 
      assert afterThresh.get(0).equals(dates.get(1)); 
      assert afterThresh.get(1).equals(dates.get(2)); 
  }
  
  /**
   * performs a similar function to java.util.Collection.removeIf
   * except that removeIf performs filtering in place (mutating the original list)
   * while this implementation creates a new list and leaves the oringinal in tact. 
   */
  public static <T> List<T> filterList(List<T> ls, Predicate<T> criterion) {
    List<T> result = new ArrayList<>(); 
    for(T val : ls) {
      if(criterion.test(val)) {
        result.add(val); 
      }
    }
    
    
    return result; 
  }
  
  /*
  public static List<String> getLongStrings(List<String> ls, int threshLen) {
    List<String> result = new ArrayList<>(); 
    for(String str : ls) {
      if(str.length() > threshLen) {
        result.add(str); 
      }
    }
    
    return result; 
  }*/
}
