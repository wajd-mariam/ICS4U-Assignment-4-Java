/*
* Copyright (c) 2020
*
* The TriangleClass.java is a superclass in the Main.java Program that does
* all the methods and calculations and returns values to the Main.java file.
* 
* @author  Wajd Mariam
* @version 1.0
* @since   2020/12/20
*/

// Importing Java Classes:
import java.lang.Math; 

public class TriangleClass {
  
  // Creating Fields
  private String userInput1 = "";
  private String userInput2 = "";
  private String userInput3 = "";
  private String finalString = "";
  private double sideA = 0;
  private double sideB = 0;
  private double sideC = 0;
  private double angleA = 0;
  private double angleB = 0;
  private double angleC = 0;
  private double semiPerimeter = 0;
  private double triangleArea = 0;
  private double triangleHeight = 0;
  
  /**
   * Class Constructor.
   */  
  public TriangleClass(String inputA, String inputB, String inputC) {
    this.userInput1 = inputA;
    this.userInput2 = inputB;
    this.userInput3 = inputC;
  }
  
  /**
   * Method to determine wheter the inpputed string is a side length or an 
   * angle size, and assigns them to a variable for later use.
   */
  public void userInput1Converter() {
    // Declaring variables used:
    finalString = "";
    // Determining wheter the string has ° sign:
    if (userInput1.contains("°")) {
      // Pulling out integers from the string:
      for (int index = 0; index < userInput1.length(); index++) {
        boolean characterSelected = Character.isDigit(userInput1.charAt(index));
        if (characterSelected == true) {
          finalString = finalString + userInput1.charAt(index);
        }
      }
      // Converting "userInput1" string to a double:
      this.angleA = Double.parseDouble(finalString);
    // If the string DOES NOT contain a ° sign, then it's a side length:
    } else {
      this.sideA = Double.parseDouble(userInput1);
    }
  }
    
  /**
   * Method to determine wheter the inpputed string is a side length or an 
   * angle size, and assigns them to a variable for later use.
   */    
  public void userInput2Converter() {
    // Declaring variables used:
    finalString = "";
    // Determining wheter the string has ° sign:
    if (userInput2.contains("°")) {
      // Pulling out integers from the string:
      for (int index = 0; index < userInput2.length(); index++) {
        boolean characterSelected = Character.isDigit(userInput2.charAt(index));
        if (characterSelected == true) {
          finalString = finalString + userInput2.charAt(index);
        }
      }
      // Converting "userInput2" string to a double:
      this.angleB = Double.parseDouble(finalString);
    // If the string DOES NOT contain a ° sign, then it's a side length:
    } else {
      this.sideB = Double.parseDouble(userInput2);
    }
  }
  
  /**
   * Method to determine wheter the inpputed string is a side length or an 
   * angle size, and assigns them to a variable for later use.
   */  
  public void userInput3Converter() {
    // Declaring variables used:
    finalString = "";
    // Determining wheter the string has ° sign:
    if (userInput3.contains("°")) {
      // Pulling out integers from the string:
      for (int index = 0; index < userInput3.length(); index++) {
        boolean characterSelected = Character.isDigit(userInput3.charAt(index));
        if (characterSelected == true) {
          finalString = finalString + userInput3.charAt(index);
        }
      }
      // Converting "userInput3" string to a double:
      this.angleC = Double.parseDouble(finalString);
    // If the string DOES NOT contain a ° sign, then it's a side length:
    } else {
      this.sideC = Double.parseDouble(userInput3);
    }
  }
  
  /**
  * Method to determine angleA of the triangle.
  */  
  public void angle1Calculator() {
    this.angleA = Math.toDegrees(Math.acos((Math.pow(this.sideB, 2) 
                                 + Math.pow(this.sideC, 2) 
                                 - Math.pow(this.sideA, 2)) 
                                 / (2 * this.sideB * this.sideC)));
  }
  
  /**
  * Method to determine angleB of the triangle.
  */  
  public void angle2Calculator() {
    this.angleB = Math.toDegrees(Math.acos((Math.pow(this.sideC, 2) 
                                 + Math.pow(this.sideA, 2) 
                                 - Math.pow(this.sideB, 2)) 
                                 / (2 * this.sideC * this.sideA)));
  }

  /**
  * Method to determine angleC of the triangle.
  */  
  public void angle3Calculator() {
    this.angleC = Math.toDegrees(Math.acos((Math.pow(this.sideA, 2) 
                                + Math.pow(this.sideB, 2) 
                                - Math.pow(this.sideC, 2)) 
                                / (2 * this.sideA * this.sideB)));
  }
  
  
  /**
   * Method to calculate sideC of the triangle,
   * when sideA, sideB, and angleC are given.
   */ 
  public void getSide3() {
    // Checking if triangle is a right angle triangle if Angle C = 90° :
    // If it's true, then pythagorean theorem is used to calculate hypotenuse (sideC)
    if (this.angleC == 90) {
      this.sideC = Math.sqrt(Math.pow(this.sideA, 2) + (Math.pow(this.sideB, 2)));
    } else {
      // Use Law of Coisne to solve:
      this.sideC = Math.sqrt((this.sideA * this.sideA) 
                              + (this.sideB * this.sideB)
                              - (2 * this.sideA * this.sideB)
                              * Math.cos(Math.toRadians(this.angleC)));
    }
  }
  
  /**
   * Method to calculate angleA from the SAA triangle.
   */ 
  public void getAngle1() {
    this.angleA = 180 - (this.angleB + this.angleC);
  }
  
  /**
   * Method to calculate sideB of the triangle,
   * when sideA, angleB, and angleC are given.
   */
  public void getSide2() {
    // Checking if triangle is a right angle triangle if Angle B or C = 90° :
    // If one of them true, then pythagorean theorem is used to calculate hypotenuse (sideB)
    if ((this.angleB == 90) || (this.angleC == 90)) {
      this.sideB = Math.sqrt(Math.pow(this.sideA, 2) + (Math.pow(this.sideC, 2)));
      // Calculating sideB using Sine Law:
    } else {  
      this.sideB = ((this.sideA *  Math.sin(Math.toRadians(this.angleB)))
                      / (Math.sin(Math.toRadians(this.angleA))));
    }
  }
  
  /**
   * Method to determine wheter the triangle is valid or not.
   */
  protected String checkTriangleValidation() {
    String triangleValidity = "";
    // Checking if triangle is valid using it's side length:
    if ((this.sideA + this.sideB) < this.sideC
         || (this.sideB + this.sideC) < this.sideA
         || (this.sideA + this.sideC) < this.sideB) {
      throw null;
    } else if ((this.angleA + this.angleB) >= 180
                || (this.angleB + this.angleC) >= 180
                || (this.angleA + this.angleC) >= 180) {
      throw null;
    } else { 
      return "Triangle is valid!";
    }
  }

  /**
   * Method to determine triangle type by side.
   */
  public String triangleTypeSide() {
    String triangleType = ""; 
    if (this.sideA == this.sideB 
        && this.sideB == this.sideC
        && this.sideA == this.sideC) {
      triangleType = "It's an Equilaterial Triangle";
    } else if (this.sideA == this.sideB 
               || this.sideB == this.sideC
               || this.sideA == this.sideC) {
      triangleType = "It's an Isosceles Triangle";
    } else if (this.sideA != this.sideB 
               && this.sideB != this.sideC
               && this.sideA != this.sideC) {
      triangleType = "It's Scalene Triangle";
    }
    return triangleType;
  }

  /**
   * Method to determine triangle type by angle.
   */
  public String triangleTypeAngle() {
    String triangleType = ""; 
    if (this.angleA < 90 
        && this.angleB < 90 
        && this.angleC < 90) {
      triangleType = "It's an Acute Triangle";
    } else if (this.angleA == 90
               || this.angleB == 90
               || this.angleC == 90) {
      triangleType = "It's a Right Angle Triangle";
    } else if (this.angleA > 90
               || this.angleB > 90
               || this.angleC > 90) {
      triangleType = "It's an Obtuse Triangle";
    }
    return triangleType;
  }

  /**
   * Method to calculate semiperimeter.
   */
  public double semiPerimeterCalculation() {
    semiPerimeter = ((this.sideA + this.sideB + this.sideC) / 2);
    return (Math.round(semiPerimeter * 100.0) / 100.0);
  }
  
  /**
   * Method to calculate area.
   */
  public double triangleAreaCalculation() {
    triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - this.sideA)
                             * (semiPerimeter - this.sideB)
                             * (semiPerimeter - this.sideC));
    return (Math.round(triangleArea * 100.0) / 100.0);
  }
  
  /**
   * Method to calculate height.
   */
  public double triangleHeightCalculation() {
    triangleHeight = ((2 * triangleArea) / sideA);
    return (Math.round(triangleHeight * 100.0) / 100.0);
  }
}
