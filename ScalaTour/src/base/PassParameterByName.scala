package base

object PassParameterByName {
  val logEnable=false
  def log(msg:String)=
    if(logEnable) println(msg)
  
    def log2(msg: =>String)=
      if(logEnable) println(msg)
  def main(args:Array[String]){
    val MSG="programming is running"
    log2(MSG+1/0)
  }
}