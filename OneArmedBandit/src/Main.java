import java.util.concurrent.ThreadLocalRandom; 

public class Main {

    public static void main(String[] args) {
      spinWheels(3); 
    }
    
    public static void spinWheels(int numWheels) {
      WheelState[] wheels = new WheelState[numWheels]; 
      for(int i = 0; i < numWheels; i++) {
        // generate random # for wheel pos
        int wheelPos = ThreadLocalRandom.current().nextInt(WheelState.values().length); 
        wheels[i] = WheelState.values()[wheelPos]; 
      }
      
      StringBuilder sb = new StringBuilder("Sping: "); 
      for(WheelState spin : wheels) {
        sb.append(spin);
        sb.append(" | "); 
      }
      
      System.out.println(sb.toString());
    }
}
