/*
Isosceles Triangle class
*/

//two of the side are the same
public class IsoscelesTriangle extends Triangle { //creates isosceles triangle
   public IsoscelesTriangle(double one, double two) { //constructor
      super(one, two, two);
   }
   
   public String toString() { //adds name to to string
      return "Isosceles " + super.toString();
   }
   
}   
      
