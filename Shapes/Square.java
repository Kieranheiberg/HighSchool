/*
Square class
*/

public class Square extends Rectangle {  //extends rectangle
   public Square(double s) { //sends squre side length twice
      super(s, s);
   }
   
   public String toString() { //does not inherit to string because would read square rectangle
      return "Square     perimeter: " + getPerimeter() + "   area: " + getArea();
   }
}
