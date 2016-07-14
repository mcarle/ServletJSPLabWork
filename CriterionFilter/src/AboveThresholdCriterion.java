
public class AboveThresholdCriterion implements StringCriterion {

  private int threshold; 
  
  public AboveThresholdCriterion(int threshold) {
    this.threshold = threshold; 
  }
  
  @Override
  public boolean test(String val) {
    return val.length() > threshold; 
  }

}
