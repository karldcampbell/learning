//import java.math.BigInteger

object learning1 extends App {
   val big = new java.math.BigInteger("1234");
   
   //println(big.toString())

  val oneTwo = List(1, 2)
  val oneOneTwo = 1 :: oneTwo
  val threeFour = List(3,4)
  
  val oneTwoThreeFour = oneTwo ::: threeFour
  
  val pair = ( 99, "Ballons")
  
  
  println( oneTwo + " " + threeFour + " , " + oneTwoThreeFour)
}