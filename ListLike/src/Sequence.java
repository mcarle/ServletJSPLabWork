import java.util.Iterator;

public class Sequence implements Iterable{
  private Object[] data = new Object[10]; 
  int count = 0; 
  
  public void add(Object o) {
    if (count == data.length) {
      throw new RuntimeException("Tried to add item to already full Sequence."); 
    }
    
    data[count] = o; 
    count++; 
  }
  
  public Object get(int indx) {
    if (indx >= data.length || indx < 0) {
      throw new RuntimeException("Tried to access invalid index in Sequence."); 
    }
    
    return data[indx]; 
  }
  
  public int size() {
    return count; 
  }
  
  @Override
  public Iterator iterator() {
    return new SequenceIterator(); 
  }
  
  private class SequenceIterator implements Iterator {
    private int curr = 0; 
    
    @Override
    public boolean hasNext() {
      return curr < count; 
    }
    
    @Override
    public Object next() {
      return data[curr++]; 
    }
    
    @Override
    public void remove() {
      throw new UnsupportedOperationException(); 
    }
  }
}
