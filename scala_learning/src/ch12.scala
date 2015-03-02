import traits._

  class frog extends Animal with HasLegs with Philosophical{
    override def toString = "green"
    override def philosophize() { println("It ain't easy being "+ toString + "!")}
  }



object ch12 extends App {

  
val r1 = new Rectangle(new Point(0,0), new Point(9,9))

println(r1.width + " x " + r1.height)

val ra1 = new Rational(1,1)
val ra2 = ra1 * 2

println(ra1 == ra2)

val q = new BasicIntQueue with Incramenting with Doubling
q.put(10)
q.put(14)
q.put(1009)

val dq = new BasicIntQueue with Doubling with Incramenting
dq.put(10)
dq.put(14)
dq.put(1009)

println(q.get())
println(q.get())

println(dq.get())
println(dq.get())
}