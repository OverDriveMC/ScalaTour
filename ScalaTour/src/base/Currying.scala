package base
class MyConnection{
  def close()=println("close Connection")
}
object Currying {
  def withClose(closeAble:{def close():Unit})
        (op:{def close():Unit}=>Unit){
    try{
      op(closeAble)
    }finally{
      closeAble.close()
    }
  }
  def main(args:Array[String]){
    val conn:MyConnection=new MyConnection()
    withClose(conn)(conn=>println("do something with connection"))
  }
}