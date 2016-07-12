import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reading {
  private String dayOfWeek; 
  private int hourOfDay; 
  private int temperature; 
  private int windSpeed; 
  
  public Reading(String reading) {
    String[] elements = reading.split(", ");  
    dayOfWeek = elements[0]; 
    hourOfDay = Integer.parseInt(elements[1]); 
    temperature = Integer.parseInt(elements[2]); 
    windSpeed = Integer.parseInt(elements[3]); 
  }
  
  public static void main(String[] args) throws Throwable {    
    BufferedReader br = Files.newBufferedReader(
        Paths.get("readings.csvx"));
    Reading[] readings = new Reading[12];
    String line;
    for (int i = 0; i < readings.length; i++) {
        readings[i] = new Reading(br.readLine());
    }
    
    for(Reading r : readings) {
      System.out.println(r.getDayOfWeek() + r.getTime()
          + " was " + r.rateTemperature());
    }
  }
  
  public String rateTemperature() {
    if (temperature < 55)
      return "cold"; 
    else if (temperature < 65)
      return "mild"; 
    else if (temperature < 80)
      return "warm"; 
    else
      return "hot"; 
  }
  
  public String getTime() {

    switch(hourOfDay) {
    case 9: 
      return " morning"; 
    case 15: 
      return " afternoon"; 
    case 21: 
      return " evening"; 
    default: 
      return null; 
    }
  }
  
  public String getDayOfWeek() {
    return dayOfWeek; 
  }
}
