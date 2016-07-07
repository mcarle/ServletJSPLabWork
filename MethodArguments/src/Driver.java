
public class Driver {
  
  private static String[] nums = 
    {"one", "two", "three", "four", "five", "six", 
        "seven", "eight", "nine", "ten"}; 
  
  public static void main(String[] args) {
    addUp(3.2, 2.2); 
    addUp(1, 4); 
    addUp("one", "three"); 
    addUp(2, 3.5); 
  }
  
  /*
  public static int addUp(int a, int b) {
    System.out.println("Executing addUp (ints)");
    return a + b; 
  }
  
  public static double addUp(double a, double b) {
    System.out.println("Executing addUp (doubles)");
    return a + b; 
  }
  
  public static int addUp(String a, String b) {
    System.out.println("Executing addUp (String)");
    return toNumber(a) + toNumber(b); 
  } */
  
  public static int addUp(int... vals) {
    System.out.println("Executing addUp (ints)");

    if(vals == null || vals.length < 1)
      return 0; 
    
    int sum = 0; 
    for(int val : vals)
      sum += val; 
    
    return sum; 
  }
  
  public static double addUp(double... vals) {
    System.out.println("Executing addUp (doubles)");
    
    if(vals == null || vals.length < 1)
      return 0; 
    
    double sum = 0; 
    for(double val : vals)
      sum += val; 
    
    return sum;  
  }
  
  public static int addUp(String... vals) {
    System.out.println("Executing addUp (String)");
    
    if(vals == null || vals.length < 1)
      return 0; 
    
    int sum = 0; 
    for(String val : vals) {
      sum += toNumber(val);
    }
    
    return sum; 
  }
  
  public static int toNumber(String num) {
    for(int i =0; i < nums.length; i++) {
      if(nums[i].equals(num))
        return i + 1; 
    }
    
    return -1; 
  }
}
