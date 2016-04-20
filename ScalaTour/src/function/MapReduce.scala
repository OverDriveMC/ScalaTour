package function

object MapReduce {
  def main(args: Array[String]): Unit = {
    val file = List("warn 2013 msg", "warn 2012 msg",
        "error 2013 msg", "warn 2013 msg")
    //Applies a binary operator to all elements of this list, 
    //going left to right.
    val num=file.map(wordcount).reduceLeft(_+_)
    println("wordcount:"+num)
  }
  //Counts the number of elements in the 
  //mutable indexed sequence which satisfy a predicate
  def wordcount(str:String):Int=str.split(" ").count("msg"==_)
}