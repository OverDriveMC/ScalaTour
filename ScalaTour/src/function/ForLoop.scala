package function

object ForLoop {
  def wordcount(str:String):Int=str.split(" ").count("msg"==_)
  def main(args: Array[String]): Unit = {
    val file = List("warn 2013 msg", "warn 2012 msg",
            "error 2013 msg", "warn 2013 msg")
    val counts=
      for(line<-file)
        yield wordcount(line)
    print(counts)
    val num=counts.reduceLeft(_+_)
    println("wordcount:"+num)
  }
}