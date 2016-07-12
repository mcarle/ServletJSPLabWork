
public class SpySatellite implements Photographer {
  @Override
  public void prepareScene() {
    System.out.println("zoning in on target for photo");
  }
  
  @Override
  public String takePhotograph() {
    return "photo of target from satellite!"; 
  }
}
