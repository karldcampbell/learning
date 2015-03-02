package tests

import junit.framework.TestCase
import junit.framework.Assert._
import elements.Element._

class ElementTestSuite extends TestCase {
  def testUniformElement(){
    val ele = elem('x', 2, 3)
    assertTrue(ele.width == 2)
    assertEquals(2, ele.width)
    
    try{
      elem('x', -2, 3)
      fail()
    }
    catch{
      case e: IllegalArgumentException =>
    }
      
  }
}