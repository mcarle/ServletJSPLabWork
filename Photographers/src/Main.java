
public class Main {

    public static void main(String[] args) {
      Photographer[] p = new Photographer[] {
         new Parent(), 
         new SpySatellite(), 
         new TrafficCamera()
      }; 
      
      for(Photographer currP : p) {
        currP.prepareScene(); 
        System.out.println("took photo: " + currP.takePhotograph()); 
      }
    }
}
