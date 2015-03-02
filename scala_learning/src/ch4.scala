import scala.collection.mutable.Map


class ChecksumAccumulator {
  private var sum = 0
  
  def add(i: Int): Unit = { sum += i }
  def add(b: Byte): Unit = {sum += b}

  def checksum(): Int = { ~(sum & 0xFF) + 1 }
}

object ChecksumAccumulator{
  private val cache = Map[String, Int]()
  
  def calculate(s: String): Int = {
    if (cache.contains(s))
      return cache(s)
    else{
      val acc = new ChecksumAccumulator
      s.foreach { c => acc.add(c.toByte) }
      val cs = acc.checksum
      cache += (s -> cs)
      return cs
    }
  }
}

object ch4 extends App {

  args.foreach { arg => println(ChecksumAccumulator.calculate(arg))  }
  

}