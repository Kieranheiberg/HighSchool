/*
Equilateral Triangle class
*/

//all of of the sides are the same
public class EquilateralTriangle extends Triangle { //creates equilateral triangle
   public EquilateralTriangle(double one) { //constructor
      super(one, one, one);
   }
   
   public String toString() { //adds name to to string
      return "Equilateral " + super.toString();
   }
}
