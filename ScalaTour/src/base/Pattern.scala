package base

object Pattern {
  ////[]定义泛型
  def withClose[A<: {def close():Unit},B](closeAble :A)
        (f:A=>B):B=
          try{
            f(closeAble)
          }finally{
            closeAble.close()
          }
  def main(args:Array[String]){
    val conn:Connection=new Connection()
    val msg=withClose(conn){
      conn=>{
        println("do something with Connection")
        "123456"
      }
    }
    println(msg+100)
    
    val msg2=withClose(conn){
      conn=>{
        println("do something with Connection")
        123456
      }
    }
    println(msg2+100)
  }
}