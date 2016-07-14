
/**
 * tests whether the provided string has >= n occurences of the specified char. 
 *
 */
public class MinOccurencesCriterion implements StringCriterion {
  private char c; 
  private int minOccurences; 
  
  public MinOccurencesCriterion(char c, int minOccurences) {
    this.c = c; 
    this.minOccurences = minOccurences; 
  }

  @Override
  public boolean test(String val) {
    int numOccurences = 0; 
    for(char currChar : val.toCharArray()) {
      if (currChar == c) {
        numOccurences++; 
      }
    }
    
    return numOccurences >= minOccurences; 
  }
  
  

}
