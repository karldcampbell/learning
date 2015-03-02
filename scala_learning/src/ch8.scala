import scala.io.Source

object ch8 extends App {

  def processFile(filename: String, width: Int) {
    def processLine(filename: String, width: Int, line: String){
    if(line.length() > width)
       println(filename + ": " + line.trim);
  }
    
    val source = Source.fromFile(filename)
    source.getLines().foreach ( l => if(l.length() > width) println(filename + ": " + l.trim))
    /*for(line <- source.getLines()){
     
     
      //processLine(filename, width, line)
    }*/
  }
  
  
  
  //case class testArgs(filename: String, width: Int)
  
  processFile("/home/kdc/mnt/forumHome/Public/sync/podcasts/commute.m3u", 80)
}