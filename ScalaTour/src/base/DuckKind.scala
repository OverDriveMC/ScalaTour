package base
class Connection {
  def close() = println("close Connection")
}

object DuckKind {
  def withClose(closeAble: { def close(): Unit },
    op: { def close(): Unit } => Unit) {
    try {
      op(closeAble)
    } finally {
      closeAble.close()
    }
  }
  
  def main(args:Array[String]){
    val conn:Connection=new Connection()
    ////第二个conn是参数  可以写成(conn)
    withClose(conn,conn=>
      println("do something with Connection"))
  }
}