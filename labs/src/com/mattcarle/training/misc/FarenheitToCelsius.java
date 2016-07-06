package com.mattcarle.training.misc;
import java.util.Scanner;

/**
 * Prompts the user for a farenheit temp value and converts and prints the corresponding
 * celsius value. 
 */
public class FarenheitToCelsius {
  private static final String FARENHEIT_PROMPT_MSG = 
      "Enter a farenheit temperature value to convert to celsius: "; 
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(FARENHEIT_PROMPT_MSG);
    double f = -1; 
    try {
      f = Double.valueOf(sc.nextLine()); 
    } catch(Exception ex) {
      System.out.println("Enter a valid integral value for farenheit to celsius conversion!");
      ex.printStackTrace(); 
    }
    
    double c = 5 * (f - 32) / 9; 
    System.out.println("celsius val: " + c);
  }
}
