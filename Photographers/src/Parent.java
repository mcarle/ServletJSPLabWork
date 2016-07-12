
public class Parent implements Photographer {
  @Override
  public void prepareScene() {
    System.out.println("hey kids, stand over there and smile!");
    
  }
  
  @Override
  public String takePhotograph() {
    return "picture of the kids!"; 
  }
}
