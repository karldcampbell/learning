

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  
  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g
  
  override def toString = { numerator + "/" + denominator}
  
  def this(n: Int) = { this(n,1) }
  
  override def compare(that: Rational) = {
    (this.numerator * that.denominator) - (that.numerator * this.denominator)
  }
  
  def + (that: Rational): Rational = {
    new Rational(this.numerator * that.denominator + that.numerator * this.denominator,
        this.denominator * that.denominator)
  }
  
  def + (i: Int): Rational = {
    new Rational(this.numerator + i * this.denominator, this.denominator)
  }
  
  def - (that: Rational): Rational = {
    new Rational(this.numerator * that.denominator - that.numerator * this.denominator,
        this.denominator * that.denominator)
  }
  
  def - (i: Int): Rational = {
     new Rational(this.numerator - i * this.denominator, this.denominator)
  }
  
  def * (that: Rational): Rational = {
    new Rational( this.numerator * that.numerator, this.denominator * that.denominator)
  }
  
  def * (i: Int): Rational = {
    new Rational(this.numerator * i, this.denominator)
  }
  
  def / (that: Rational) = {
    new Rational(this.numerator * that.denominator, this.denominator * that.numerator)
  }
  
  def / (i: Int) = {
    new Rational(this.numerator, this.denominator * i)
  }
  
  def lessThan(that: Rational): Boolean = {
    this.numerator * that.denominator < that.numerator * this.denominator
  }
  
  def max(that: Rational): Rational = { if(this.lessThan(that)) that else this }
  
  private def gcd(a: Int, b: Int): Int = { if(b ==0 ) a else gcd(b, a % b)  }
}