import java.awt.Color;

public class Main {
  public static void main(String[] args) {
    ClothingPair[] pairs = new ClothingPair[] {
        new ClothingPair<Sock>(new Sock(5, Color.black)
            , new Sock(10, Color.black)), 
        new ClothingPair<Glove>(new Glove(10, Color.gray), 
            new Glove(10, Color.gray))
    };
    
    assert !pairs[0].isMatch(); 
    assert pairs[1].isMatch(); 
  }
}
