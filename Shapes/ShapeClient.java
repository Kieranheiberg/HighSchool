/*
Kieran Heiberg
3/6/2020
Shapes lab
*/

import java.util.Scanner;
import java.util.ArrayList;
public class ShapeClient{
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      ArrayList allShapes = new ArrayList<Shape>(); //array list for all the shapes
      //creates and adds all the shapes to allShapes array list
      allShapes.add(new Circle(4));
      allShapes.add(new Circle(6.92));
      allShapes.add(new Square(5));
      allShapes.add(new Square(8.34));
      allShapes.add(new Rectangle(5, 5));
      allShapes.add(new Rectangle(29.8, 8.08));
      allShapes.add(new ScaleneTriangle(5, 9, 13));
      allShapes.add(new ScaleneTriangle(9, 17, 8.1));
      allShapes.add(new IsoscelesTriangle(4, 6));
      allShapes.add(new IsoscelesTriangle(8, 10));
      allShapes.add(new EquilateralTriangle(5));
      allShapes.add(new EquilateralTriangle(7.82));
      allShapes.add(new RightTriangle(5, 9, 8));   
      allShapes.add(new RightTriangle(4, 6, 3));
      System.out.println("Welcome, would you like to create a shape?"); //prompts to create shape
      String yesOrNo = scan.nextLine();
      //initalizes variables
      boolean booleanYesNo = false;          
      String newYesNo = "";
      String shapeType = "";
      if (yesOrNo.toLowerCase().equals("yes")) {
         booleanYesNo = true;
      }     
      
      while (booleanYesNo) { //as long as boolean is true
         //prompts for kind of shape
         System.out.print("What shape would you like to create? (Circle, Square, Rectangle, ScaleneTriangle, IsoscelesTriangle, EquilateralTriangle, RightTriangle)");
         System.out.println();
         shapeType = scan.next();
         createNewShape(scan, shapeType, allShapes); //creates new shape and adds it to array list      
         System.out.println("Shape created");
         System.out.println();
         //prompts to create another shape
         System.out.println("Would you like to create another shape?");
         newYesNo = scan.next();
         //changes yes or no response to a boolean response
         if (newYesNo.toLowerCase().equals("yes")) {
            booleanYesNo = true;
         }
         else {
            booleanYesNo = false;
         }
      }
      //prints out all of the elents of the array list
      for (int i = 0; i < allShapes.size(); i++) {
         System.out.println(allShapes.get(i));
      }
      //prints smallest and largest shape
      System.out.println("\n" + smallestArea(allShapes)); 
      System.out.println(largestArea(allShapes)); 
   }
   
   public static String smallestArea (ArrayList<Shape> allShapes) { //finds smallest shape
      int min = 0;
      //compares each value to lowest then replaces if it is lower
      for (int i = 1; i < allShapes.size(); i++) {
         if (allShapes.get(min).getArea() > allShapes.get(i).getArea()) {
            min = i;
         }
      }
      return "The smallest shape is " + allShapes.get(min);
   }
   
   public static String largestArea (ArrayList<Shape> allShapes) { //finds largest shape
      int max = 0;
      //compares each value to highest then replaces if it is greater
      for (int i = 1; i < allShapes.size(); i++) {
         if (allShapes.get(max).getArea() < allShapes.get(i).getArea()) {
            max = i;
         }
      }
      return "The largest shape is " + allShapes.get(max);
   }
   
   public static void createNewShape (Scanner scan, String shapeType, ArrayList<Shape> allShapes) {        //creates new shape
      if (shapeType.toLowerCase().equals("circle")) {      //if user wants to make circle
         System.out.println("What is the radius of the circle?");      //prompts user for radius
         double circleRadius = scan.nextDouble();
         Circle createdCircle = new Circle(circleRadius);          //creates shape and adds it to array list
         allShapes.add(createdCircle);
         System.out.println(createdCircle); //prints new shape
      }
      
      else if (shapeType.toLowerCase().equals("square")) {    //if user wants to make a square
         System.out.println("What is a side length of the square?");
         double squareLength = scan.nextDouble();              //asks side length of square
         Square newSquare = new Square(squareLength);
         allShapes.add(newSquare);              //creates the square and adds it to the arraylist then prints it
         System.out.println(newSquare);
      }
      else if (shapeType.toLowerCase().equals("rectangle")) {          //user wants to make a rectangle
         System.out.println("What is the width of the rectangle?");
         double rectangleWidth = scan.nextDouble();                        //asks side lengths of rectangle
         System.out.println("What is the length of the rectangle?");
         double rectangleLength = scan.nextDouble();
         Rectangle newRectangle = new Rectangle(rectangleWidth, rectangleLength);
         allShapes.add(newRectangle);              //creates the rectangle and adds it to arraylist
         System.out.println(newRectangle);
      }
      else if (shapeType.toLowerCase().equals("scalenetriangle") || shapeType.toLowerCase().equals("righttriangle")) {
         System.out.println("What is a side length of the triagle?");         //if user wants to make a right triangle or scalene because same logic
         double side1 = scan.nextDouble();
         System.out.println("What is another side length of the triangle?");    //prompts the user for the side lengths of the triangle
         double side2 = scan.nextDouble();
         System.out.println("What is the final side length of the triangle?");
         double side3 = scan.nextDouble();
         if (shapeType.toLowerCase().equals("righttriangle")) { //if shape is a right triangle
            RightTriangle newRight = new RightTriangle(side1, side2, side3);     //creates a new right triangle and adds it to arraylist
            allShapes.add(newRight);      
            System.out.println(newRight);
         }
         else {
            ScaleneTriangle newScalene = new ScaleneTriangle(side1, side2, side3);
            allShapes.add(newScalene);             //creates a new scalene triangle and adds it to arraylist
            System.out.println(newScalene);
         }
      }
      else if (shapeType.toLowerCase().equals("isoscelestriangle")) {     //if user wanted to make a isosceles triangle
         System.out.println("What is the length of the two equal sides of the triangle?");
         double i1 = scan.nextDouble();      
         System.out.println("What is the length of the other side of the triangle?");      //side length of triangle
         double i2 = scan.nextDouble();
         IsoscelesTriangle newIsosceles = new IsoscelesTriangle(i1, i2);
         allShapes.add(newIsosceles);              //creates a new isosceles triangle adds it to arraylist
         System.out.println(newIsosceles);
      }
      else {
         System.out.println("What is the length of one side of the equilateral triangle?");     //if user wants to make an equilteral triangle
         double e1 = scan.nextDouble();
         EquilateralTriangle newEquilateral = new EquilateralTriangle(e1);       //asks side length of equilateral
         allShapes.add(newEquilateral);
         System.out.println(newEquilateral);          //creates a new equilateral and adds it to arraylist                 
      }
   }
   
}
