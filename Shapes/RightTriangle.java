/*
Right Triangle class
*/

//has a right anglen and all sides different
public class RightTriangle extends Triangle {//creates right triangle
   public RightTriangle(double one, double two, double three) { //constructor
      super(one, two, three);
   }
   
   public String toString() { //adds name to to string
      return "Right " + super.toString();
   }
   
}
