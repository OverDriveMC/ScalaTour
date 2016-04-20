package function

object TailRecursion {
  def wordcount(str : String):Int=
      str.split(" ").count("msg"==_)
      
  def myFoldLeft[A](list:List[A])(init:A)(f:(A,A)=>A):A={
    list match{
      case List()=>init
      case head::tail=>myFoldLeft(tail)(f(init,head))(f)
    }
  }
    
      
  def foldLeft(list :List[Int])(init:Int)(f:(Int,Int)=>Int):Int={
    list match{
      case List()=>init
      case head::tail=>{
        println("head:"+head)
        println("tail:"+tail)
        foldLeft(tail)(f(init,head))(f)
      }
    }
  }
  def main(args: Array[String]): Unit = {
    val file = List("warn 2013 msg", "warn 2012 msg",
              "error 2013 msg", "warn 2013 msg")
    val num=foldLeft(file.map(wordcount))(0)(_+_)
    val num2=myFoldLeft(file.map(wordcount))(0)(_+_)
    println("wordcount:"+num)
    println("wordcount:"+num2)
  }
  

}