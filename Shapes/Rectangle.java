/*
Rectangle class
*/

public class Rectangle extends Everything implements Shape { //creates rectangle
   private double length; //fields
   private double width;
   
   public Rectangle(double l, double w) { //constructor for length and width
      this.length = l;
      this.width = w;
   }
   
   public double getArea() { //finds area
      return this.length * this.width;
   }
   
   public double getPerimeter() { //finds perimeter
      return (this.length + this.width) * 2;
   }
   
   public String toString() { //adds name to to string
      return "Rectangle " + super.toString();
   }

}
