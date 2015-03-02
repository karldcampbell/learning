

object ch15 extends App {

  sealed abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
  
  val op = BinOp("+", Number(1.0), Var("x"))
  //val e = Number(2.1)
  
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }
  
  def describe(x: Any): String = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "Hi!"
    case Nil => "the empty list"
    case _ => "something else..."
  }
  
  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", a, b) if a == b => BinOp("*", a, Number(2))
    case _ => e
  }
  
  def simplifyAll(e: Expr): Expr = e match{
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case UnOp(op, e) => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => e
  }
  
 
  val ef = new ExprFormatter
  println(ef.format(Number(2.12)))
  println(ef.format(Number(5.0)))
  println(ef.format(Var("c")))
  println(ef.format(UnOp("+", Number(5.0))))
  println(ef.format( 
      BinOp("/", Number(0.3), UnOp("-", Var("u")))
   ))
   
   println(ef.format(
       BinOp("/",
       BinOp("+",
        BinOp("/", Number(0.3), UnOp("-", Var("u"))),
        BinOp("/", Var("x"), Var("y"))),
        Var("AA"))
   ))
}