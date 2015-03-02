import elements._
import elements.Element.elem

object ch10 extends App {
  private object Spiral {
    val space = elem(" ")
    val corner = elem("+")
    
    def spiral(nEdges: Int, direction: Int): Element = {
      if (nEdges == 1)
       elem("+")
      else{
         val sp = spiral(nEdges - 1, (direction + 3) % 4)
         def verticalBar = elem('|', 1, sp.height)  
         def horizantalBar = elem('-', sp.width, 1)
         if (direction == 0)
           (corner beside horizantalBar) above (sp beside space)
         else if (direction == 1)
           (sp above space) beside (corner above verticalBar)
         else if (direction == 2)
           (space beside sp) above (horizantalBar beside corner)
         else
           (verticalBar above corner) beside (space above sp)    
       }
      
    }
  }
  
// val e1 = new LineElement("Hello")
 //val e2 = new ArrayElement(Array("Hello", "World"))
 
// val e3: Element = new UniformElement('x', 2, 6)

 val e1 = elem('A', 2, 2)
 println(e1)
 
 val e2 = elem('B', 4, 4)
 println(e2)
 
 println(e1 beside e2)
 println(e2 beside e1) 
 
 println(Spiral.spiral(300, 0))
}