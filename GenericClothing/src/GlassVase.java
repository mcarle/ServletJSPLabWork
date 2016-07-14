
public class GlassVase implements Sized {
  private int size; 
  public GlassVase(int size) {
    this.size = size; 
  }
  
  @Override
  public int getSize() {
    return size; 
  }

}
