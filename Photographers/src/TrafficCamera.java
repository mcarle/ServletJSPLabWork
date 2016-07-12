
public class TrafficCamera implements Photographer {
  @Override
  public void prepareScene() {
    System.out.println("taking photo of driver about to run through red light.");
  }
  
  @Override
  public String takePhotograph() {
    return "photo of driver running traffic light for evidence."; 
  }
}
