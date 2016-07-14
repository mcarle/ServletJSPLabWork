
public class FirstLetterRangeCriterion implements StringCriterion {
  private char lowChar; 
  private char highChar; 
  
  public FirstLetterRangeCriterion(char lowChar, char highChar) {
    this.lowChar = lowChar; 
    this.highChar = highChar; 
  }
  
  @Override
  public boolean test(String val) {
    char startChar = val.charAt(0); 
    return startChar >= lowChar 
        && startChar <= highChar; 
  }
  
}
