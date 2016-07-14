import java.awt.Color;

public class Fabric implements Colored {
  private Color color; 
  public Fabric(Color color) {
    this.color = color; 
  }
  
  @Override
  public Color getColor() {
    return color; 
  }

}
