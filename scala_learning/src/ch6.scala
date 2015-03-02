object ch6 extends App {
  implicit def intToRational(x: Int): Rational = new Rational(x)
  
  val r1 = new Rational(2,9)
  val r2 = new Rational(3,5)
  
  println(r1 + r2)
  println(r1 lessThan r2)
  println(new Rational(223))
  println(45 / r1)
}