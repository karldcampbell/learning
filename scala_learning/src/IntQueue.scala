import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

trait Doubling extends IntQueue{
  abstract override def put(x: Int) { super.put(2 * x)}
}

trait Incramenting extends IntQueue{
  abstract override def put(x: Int) { super.put( 1+x)}
}

trait Filtering extends IntQueue{
  abstract override def put(x: Int) { if( x > 0) super.put(x)}
}

class BasicIntQueue extends IntQueue{
  private val buffer = new ArrayBuffer[Int]
  
  def get() = buffer.remove(0)
  def put(x: Int) { buffer += x}
}

class DoublingQueue extends BasicIntQueue with Doubling

