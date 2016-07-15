import java.util.function.Predicate;

public class AboveThresholdCriterion implements Predicate<String> {

  private int threshold; 
  
  public AboveThresholdCriterion(int threshold) {
    this.threshold = threshold; 
  }
  
  @Override
  public boolean test(String val) {
    return val.length() > threshold; 
  }

}
