/*
Triangle blueprint class
*/

public abstract class Triangle extends Everything implements Shape { //blueprint for all triangles
   private double side1; //fields
   private double side2;
   private double side3;
   private double semiPerimeter;
   
   public Triangle (double one, double two, double three) { //constructor to ccreate triangle
      if ((one + two) > three & (two + three) > one & (one + three) > two) { //makes sure side lengths of traingle are valid
         this.side1 = one;
         this.side2 = two;
         this.side3 = three;
         semiPerimeter = (this.side1 + this.side2 + this.side3) / 2; //creates semiperimeter of traingle for later use
      }
      else { //if sides not valid throws error message
         throw new IllegalArgumentException("Invalid triangle created");
      }
   }
   
   public double getArea() { //finds area
      return Math.sqrt(semiPerimeter * (semiPerimeter - this.side1) * (semiPerimeter - this.side2) * (semiPerimeter - this.side3));
   }
   
   public double getPerimeter() { //finds perimeter
      return semiPerimeter * 2;
   }
   
   public String toString() { //adds triangle name to to string
      return "Triangle " + super.toString();
   }
      
}
