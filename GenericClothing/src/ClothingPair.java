
public class ClothingPair<T extends Sized & Colored> {
  private T itm1; 
  private T itm2; 
  
  public ClothingPair(T itm1, T itm2) {
    this.itm1 = itm1; 
    this.itm2 = itm2; 
  }
  
  public boolean isMatch() {
    return itm1.getSize() == itm2.getSize()
        && itm1.getColor() == itm2.getColor(); 
  }
}
