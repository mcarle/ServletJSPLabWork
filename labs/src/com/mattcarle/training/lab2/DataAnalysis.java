package com.mattcarle.training.lab2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataAnalysis {
  private static final String NUM_ITEMS_PROMPT = 
      "Enter the number of data values that will be entered: "; 
  
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    
    double[] data; 
    try {
      // get # of items
      System.out.println(NUM_ITEMS_PROMPT);
      int numVals = sc.nextInt(); 
      
      // init array and prompt user for values
       data = new double[numVals]; 
      for(int i=0; i < data.length; i++) {
        System.out.println("Enter value: ");
        data[i] = sc.nextDouble(); 
      }
    } catch (InputMismatchException ex) {
      System.out.println("Error occured in parsing input. Please make sure to enter numeric values ONLY!");
      return; 
    }
    
    // perform analysis on data set and print results
    double sum = 0; 
    double min = Double.MAX_VALUE; 
    double max = Double.MIN_VALUE; 
    
    for(double val : data) {
      sum += val;
      if (val < min)
        min = val; 
      
      if (val > max)
        max = val; 
    }
    
    double mean = sum / data.length;    
    System.out.println("Mean: " + mean);
    System.out.println("Min: " + min);
    System.out.println("Max: " + max);
  }
}
