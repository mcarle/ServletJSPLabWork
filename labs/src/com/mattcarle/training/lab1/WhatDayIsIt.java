package com.mattcarle.training.lab1;
import java.util.Scanner;

public class WhatDayIsIt {
  private static final String EXIT_WORD = "quit"; 

  private static String INIT_PROMPT = 
      "This tool converts month, day, and year to day of week. Type 'quit' to exit."; 
  
  private static final String MONTH_PROMPT =
      "Enter a numeric month value (1-12): "; 
  
  private static final String DAY_PROMPT = 
      "Enter a day of month value (1-31): "; 
  
  private static final String YEAR_PROMPT = 
      "Enter a year value: "; 
    
  public static void main(String[] args) {
    System.out.println(INIT_PROMPT);
    
    Scanner sc = new Scanner(System.in); 
    boolean timeToQuit = false; 
    while(!timeToQuit) {
      // get month value
      System.out.println(MONTH_PROMPT);
      String monthInput = sc.nextLine(); 
      timeToQuit = EXIT_WORD.equalsIgnoreCase(monthInput); 
      if(timeToQuit)
        break; 
      
      int month = getInputVal(monthInput); 
      if (month < 1 || month > 12) {
        System.out.println("Invalid month value provided!");
        continue; 
      }
      
     System.out.println(DAY_PROMPT);
     int dayOfMonth = getInputVal(sc.nextLine());
     if(dayOfMonth < 1 || dayOfMonth > 31) {
       System.out.println("Invalid day of month value provided!");
       continue; 
     }
     
     System.out.println(YEAR_PROMPT);
     int year = getInputVal(sc.nextLine());
     if(year < 1) {
       System.out.println("Invalid year value provided!");
     }
     
     int dayOfWeek = getDayOfWeek(month, dayOfMonth, year); 
     System.out.println("Day of week: " + dayToString(dayOfWeek));
    }
  }
  
  /**
   * Uses Zellers algorithm to get the day of the week for a specified
   * month, day of month, and year. Expects all values to be in appropriate domain
   * 
   */
  private static int getDayOfWeek(int month, int dayOfMonth, int year) {
    if(month == 1 || month == 2) {
      month += 12; 
      year--;   
    }
    
    
    int a = 26 * (month + 1) / 10;
    int b = year / 4; 
    int c = 6 * (int)(year / 100);
    int d = year / 400; 
    
    int dayOfWeek =  (a + b + c + d + dayOfMonth + year) % 7;  
    return dayOfWeek;
    
  }
  
  /**
   *  parses a string for numeric val. exits app if exit word specified.
   */
  private static int getInputVal(String line) {    
    try {
      return Integer.parseInt(line); 
    } catch(NumberFormatException ex) {
      System.out.println("Please enter a valid positive integral value!");
      return -1; 
    }
  }
  
  /**
   * Converts numeric day of week to corresponding string value.
   * Assumes dayOfWeek is in proper input domain. 
   */
  private static String dayToString(int dayOfWeek) {
    switch(dayOfWeek) {
    case 0: 
      return "Saturday"; 
    case 1: 
      return "Sunday"; 
    case 2: 
      return "Monday"; 
    case 3: 
      return "Tuesday"; 
    case 4: 
      return "Wednesday"; 
    case 5: 
      return "Thursday"; 
    case 6: 
      return "Friday"; 
    default: 
      return null; 
    }
  }
}
