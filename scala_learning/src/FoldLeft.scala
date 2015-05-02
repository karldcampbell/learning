object FoldLeft extends App {

  println(double(List(1,2,3,4)))
  
  def double(l : List[Int]) : List[Int] = {
    l.foldLeft(List[Int]())({(r : List[Int], i : Int) => 
      println(i)
      println(r)
      i*2 :: r; //add to head, because it's more efficient
    }).reverse //reverse, because the previous line already reversed the list.
  }
}