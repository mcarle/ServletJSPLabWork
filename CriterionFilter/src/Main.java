import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> ls = Arrays.asList(
        "Fred", "Jim", "William", "Susannah", "Lucy", "Orinoco", "Toby"
      );
    
      AboveThresholdCriterion threshCriterion = 
          new AboveThresholdCriterion(6); 
      List<String> longStrings = stringFilter(ls, threshCriterion);
      assert longStrings.size() == 3;
      assert longStrings.get(0).equals("William");
      assert longStrings.get(1).equals("Susannah");
      assert longStrings.get(2).equals("Orinoco");
      
      FirstLetterRangeCriterion flrCriterion = 
          new FirstLetterRangeCriterion('A', 'M'); 
      List<String> charRngStrings = stringFilter(ls, flrCriterion); 
      assert charRngStrings.size() == 3; 
      
      MinOccurencesCriterion minOccCriterion = 
          new MinOccurencesCriterion('l', 2);
      List<String> minOccStrings = stringFilter(ls, minOccCriterion); 
      assert minOccStrings.size() == 1; 
      assert minOccStrings.get(0).equals("William"); 
      
  }
  
  public static List<String> stringFilter(List<String> ls, StringCriterion criterion) {
    List<String> result = new ArrayList<>(); 
    for(String val : ls) {
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
