import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    Sequence s = new Sequence();
    s.add("Hello");
    s.add("there");
    s.add("done");
    Iterator i1 = s.iterator();
    Iterator i2 = s.iterator();
    assert i1.hasNext();
    assert i1.next().equals("Hello");
    assert i1.hasNext();
    assert i1.next().equals("there");
    assert i2.hasNext();
    assert i2.next().equals("Hello");
    assert i1.hasNext();
    assert i1.next().equals("done");
    assert i1.hasNext() == false;
    assert i2.next().equals("there");
    assert i2.next().equals("done");
    assert i2.hasNext() == false;
    
    for (Object o : s) {
      System.out.println(o);
    }
  }
}
