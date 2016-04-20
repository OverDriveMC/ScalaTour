package function

object PatternMatch {
  def fibonacci(in : Any):Int = in match{
    case 0=>0
    case 1=>1
    case n:Int=>{
      if(n<0){
        0
      }else{
        fibonacci(n-1)+fibonacci(n-2)  
      }
    }
    case _=>0
  }
  
  def main(args:Array[String]){
    
    //println(fibonacci(100))
    println(fibonacci(-3))
  }
}