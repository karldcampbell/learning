package elements

import sun.security.util.Length

abstract class Element {
  import Element._
  
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if(height == 0) 0 else contents(0).length()
  
  def above(that: Element) = {
    val thisp = this widen that.width
    val thatp = that widen this.width
    assert(thisp.width == thatp.width)
    elem(thisp.contents ++ thatp.contents)
  }
  
  def beside(that: Element) = {
    val thisp = this heighten that.height
    val thatp = that heighten this.height
    elem(
        for ( (line1, line2) <- thisp.contents zip thatp.contents) 
          yield line1 + line2 
         )
  }
  
  def widen(w: Int): Element = {
    //println("widen, " + this.width + " to " + w)
    if(w <= width) this
    else{
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    } ensuring ( w <= _.width)
  }
  
  def heighten(h: Int): Element = {
   // println("heighten, " + this.height + " to " + h)
    if( h <= height) this
    else{
      val top = elem(' ', width, (h - height)/2)
      
      val bottom = elem(' ', width, (h - height - top.height))
      //println("---" + (h - height)/2)
      //println(top + this.toString() + bottom)
      // println("===" + (h - height - top.height))
      top above this above bottom
    }
  }
  
  override def toString = contents.mkString("\n")

}

object Element{
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  
  def elem(chr: Char, width: Int, height: Int): Element = 
    new UniformElement(chr, width, height)
  
  def elem(line: String): Element = new LineElement(line)
}