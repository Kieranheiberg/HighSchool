/* 
Everything blueprint class
*/

public abstract class Everything implements Shape { 
   public String toString() { //toString for all shapes
      return "    perimeter: " + getPerimeter() + "   area: " + getArea();
   }
   
   public boolean equals (Object o) { //checks for equality between shapes 
      Shape newShape = null; //blank shape to imprint on
      if (o instanceof Shape) {  //checks that o is a shape
         newShape = (Shape) o;   
      }
      else {
         return false;
      }
      //if the area and perimeter of the two shapes are the same
      return (getArea() == newShape.getArea() && getPerimeter() == newShape.getPerimeter());
   }
   
}
