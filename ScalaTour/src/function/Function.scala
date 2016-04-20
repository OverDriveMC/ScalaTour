package function

object Function {
  def containsOdd(list:List[Int]):Boolean={
    for(i<-list){
      if(i%2==1){
        return true
      }
    }
    return false
  }
  def main(args:Array[String]){
    val list=List(1,2,3,4)
    println("list contains Odd ?"+containsOdd(list))
    val flag=list.exists((x:Int)=>x%2==1)
    val flag2=list.exists(_%2==1)
    println(flag+"  "+flag2)
    
    val file = List("warn 2013 msg", "warn 2012 msg",
              "error 2013 msg", "warn 2013 msg")
    //Selects all elements of this list which satisfy a predicate
    println("cat file | grep 'warn' | grep '2013' |wc:"+
        file.filter(_.contains("warn")).filter(_.contains("2013")).size)
  }
}