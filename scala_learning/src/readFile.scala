import scala.io.Source

/**
 * @author kdc
 */
object readFile extends App {
  
  def widthOfLength(s: String): Int = s.length().toString().length()
  
  def maxLength(l: List[String]): Int = {
    var m = 0;
    for(line <- l){
      m = m.max(line.length())
    }
    return m
  }
  
  if(args.length > 0){
    val lines = Source.fromFile(args(0)).getLines().toList
    val maxWidth = maxLength(lines).toString().length()
    
    lines.foreach { line => 
      val padding = " " * (maxWidth - widthOfLength(line))
      println(padding + line.length() + " | " + line)
      
    }
    
  }
  else {
    Console.err.println("Please enter a file name...")
  }
  
}