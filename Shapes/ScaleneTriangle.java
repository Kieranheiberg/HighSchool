/*
Scalene Triangle class
*/

//none of the sides are the same
public class ScaleneTriangle extends Triangle { //creates scalene triangle
   public ScaleneTriangle(double one, double two, double three) { //constructor
      super(one, two, three);
   }
   
   public String toString() { //adds name to to string
      return "Scalene " + super.toString();
   }

   
}
