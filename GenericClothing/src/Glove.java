import java.awt.Color;

public class Glove implements Sized, Colored {
  private int size; 
  private Color color; 
  
  public Glove(int size, Color color) {
    this.size = size; 
    this.color = color; 
  }
  @Override
  public Color getColor() {
    return color; 
  }

  @Override
  public int getSize() {
    return size; 
  }
  
  @Override
  public String toString() {
    return "Glove: " + color.toString() + " - " + size; 
  }

}
