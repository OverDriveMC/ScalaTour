package function

object OptionDemo {
  def getProperty(name:String):Option[String]={
    val value=System.getProperty(name)
    if(value!=null)
      Some(value)
    else
      None
  }
  def main(args: Array[String]): Unit = {
    val osName=getProperty("os.name")
    osName match{
      case Some(value)=>{
        println(Some(value))
        println(value)
      }
      case _=>println("none")
    }
    println(osName.getOrElse("none"))
    osName.foreach(print _)
  }
}