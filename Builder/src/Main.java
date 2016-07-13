
public class Main {
  public static void main(String[] args) {
    try {
    Target t = Target.builder()
        .fieldA("a val")
        .fieldB("")
        .fieldC("c val")
        .fieldDAndE("sd", "sdfsd")
        .build(); 
    System.out.println("target built successfully");
    } catch(Exception ex) {
      System.out.println("Tried to create target in invalid state");
    }
  }
}
