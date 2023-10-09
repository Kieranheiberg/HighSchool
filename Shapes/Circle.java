/*
Circle class
*/

public class Circle extends Everything implements Shape { //creates circle
   private double radius;
   
   public Circle(double r) { //constructor for radius
      this.radius = r;
   }
   
   public double getArea() { //finds area
      return Math.PI * Math.pow(this.radius, 2);
   }
   
   public double getPerimeter() { //finds perimeter
      return 2 * Math.PI * this.radius;
   }
   
   public String toString() { //adds name to to string
      return "Circle " + super.toString();
   }


}
