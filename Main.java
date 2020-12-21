/*
* Copyright (c) 2020
*
* The Main.java program lets the user change truck and bike's 
* information, and take them for a ride.
* 
* @author  Wajd Mariam
* @version 1.0
* @since   2020/12/20
*/

// Imports Java Classes:
import java.util.Scanner;


class Main {
  public static void main(String[] args) {
      
    // Declaring variables used:
    String input1 = "";
    String input2 = "";
    String input3 = "";
    String dataCombination = "";
    
    // Try Catch Statement for catching input error:
    try {
      
      // Declaring Scanner:
      final Scanner dataInput = new Scanner(System.in);
      final Scanner dataCombo = new Scanner(System.in);
      
      // Input 
      System.out.println("");
      System.out.println("This program calculates area, perimeter, and type of a given triangle!");
      System.out.println("Please enter triangle data in cm and degrees: ");
      System.out.println("Don't forget to type the ° sign for angles at the end!"); 
      System.out.println("");
      System.out.println("NOTE: data MUST be in one of the following formats!");
      System.out.println("Side a, Side b, Side c");
      System.out.println("Side a, Side b, Angle C");
      System.out.println("Side a, Angle B, Angle C");
      System.out.println("");
      System.out.println("Enter value #1: ");
      input1 = dataInput.nextLine();
      System.out.println("Enter value #2: ");
      input2 = dataInput.nextLine();
      System.out.println("Enter value #3: ");
      input3 = dataInput.nextLine();
      
      // Process / Output
      
      // Initializing triangleData Class and passing parameters:
      TriangleClass triangleData = new TriangleClass(input1, input2, input3);
      // Asking user what was the numbers he inputted:
      System.out.println("");
      System.out.println("What were the inputs you entered?");
      System.out.println("Were they: ");
      System.out.println("Side a, Side b, Side c");
      System.out.println("Side a, Side b, Angle C");
      System.out.println("Side a, Angle B, Angle C");
      System.out.println("");
      dataCombination = dataCombo.nextLine();
      
      if (dataCombination.equals("Side a, Side b, Side c")) {
        // Methods to convert strings to doubles and assigning them to variables:
        triangleData.userInput1Converter();
        triangleData.userInput2Converter();
        triangleData.userInput3Converter();
        // Methods to determine the three angles of the SSS triangle:
        triangleData.angle1Calculator();
        triangleData.angle2Calculator();
        triangleData.angle3Calculator();
        // Method to check if triangle is valid or not:
        System.out.println("");
        System.out.println(triangleData.checkTriangleValidation());
        // Method to determine the type of the triangle by side:
        System.out.println(triangleData.triangleTypeSide() + " by side.");
        // Method to determine the type of the triangle by angle:
        System.out.println(triangleData.triangleTypeAngle() + " by angle.");
        // Method to calculate semi periemeter:
        System.out.println("Perimeter = " 
                           + 2 * (triangleData.semiPerimeterCalculation()) + "m");
        // Method to calculate area:
        System.out.println("Triangle Area = " 
                           + triangleData.triangleAreaCalculation() + "m²");
        // Method to calculate height of triangle:
        System.out.println("Height of triangle = " 
                           + triangleData.triangleHeightCalculation() + "m");
        
        
        
      } else if (dataCombination.equals("Side a, Side b, Angle C")) {
        // Methods to convert strings to doubles and assigning them to variables:
        triangleData.userInput1Converter();
        triangleData.userInput2Converter();
        triangleData.userInput3Converter();
        // Method to calculate the only missing side (sideC): 
        triangleData.getSide3();
        // Methods to determine the two angles (angleA, and angleB):
        triangleData.angle1Calculator();
        triangleData.angle2Calculator();
        // Method to check if triangle is valid or not:
        System.out.println(triangleData.checkTriangleValidation());
        // Method to determine the type of the triangle by side:
        System.out.println(triangleData.triangleTypeSide() + " by side.");
        // Method to determine the type of the triangle by angle:
        System.out.println(triangleData.triangleTypeAngle() + " by angle.");
        // Method to calculate semi periemeter:
        System.out.println("Perimeter = " 
                           + 2 * (triangleData.semiPerimeterCalculation()) + "m");
        // Method to calculate area:
        System.out.println("Triangle Area = " 
                           + triangleData.triangleAreaCalculation() + "m²");
        // Method to calculate height of triangle:
        System.out.println("Height of triangle = " 
                           + triangleData.triangleHeightCalculation() + "m");
        
        
        
      } else if (dataCombination.equals("Side a, Angle B, Angle C")) {
        // Methods to convert strings to doubles and assigning them to variables:
        triangleData.userInput1Converter();
        triangleData.userInput2Converter();
        triangleData.userInput3Converter();
        // Metho to calculate the only missing angle (angleA):
        triangleData.angle1Calculator();
        // Methods to calculate the 2 missing sides (sideB, and sideC): 
        triangleData.getSide3();
        triangleData.getSide2();
        // Method to check if triangle is valid or not:
        System.out.println(triangleData.checkTriangleValidation());  
        // Method to determine the type of the triangle by side:
        System.out.println(triangleData.triangleTypeSide() + " by side.");
        // Method to determine the type of the triangle by angle:
        System.out.println(triangleData.triangleTypeAngle() + " by angle.");
        // Method to calculate semi periemeter:
        System.out.println("Perimeter= " 
                           + 2 * (triangleData.semiPerimeterCalculation()) + "m");
        // Method to calculate area:
        System.out.println("Triangle Area = " 
                           + triangleData.triangleAreaCalculation() + "m²");
        // Method to calculate height of triangle:
        System.out.println("Height of triangle = " 
                           + triangleData.triangleHeightCalculation() + "m");
      } else {
        System.out.println("Invalid Input!");
      }
      
      
    // Catches and tells the user what error occurred:
    } catch (NullPointerException e) {
      System.out.println("");
      System.out.print("ERROR. Invalid Triangle");
    } catch (Exception e) {
      System.out.println("Invalid Input");
    }
  }
}