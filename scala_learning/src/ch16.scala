

object ch16 extends App{
 
  def msort[T](less: (T, T) => Boolean)
    (xs: List[T]): List[T] = {  
    def merge(xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if(less(x,y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    }
    
    val n = xs.length / 2
    if(n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      //println(ys.length + " : " + zs.length)
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
  val f = (a: Int, b: Int) => a < b
  
  val l = List(1,2,6,9,3,6,2,23,77,99,12,3,3555,90)
  
 println(msort(f)(List(2,1)))
 println(msort(f)(l))
  
}