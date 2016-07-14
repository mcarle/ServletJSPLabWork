
public class BadMonthException extends Exception {
  public BadMonthException(Exception ex) {
    super("Invalid month!", ex); 
  }
}
