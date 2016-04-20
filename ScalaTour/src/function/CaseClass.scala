package function
abstract class Expr

case class FibonacciExpr(n:Int) extends Expr{
  require(n>=0)
}

case class SumExpr(a:Expr,b:Expr) extends Expr



object CaseClass {
  def value(in:Expr):Int = in match{
    case FibonacciExpr(0)=>0
    case FibonacciExpr(1)=>1
    case FibonacciExpr(n)=>
      value(SumExpr(FibonacciExpr(n-1),FibonacciExpr(n-2)))
    case SumExpr(a,b)=>value(a)+value(b)
    case _ =>0
  }  
  
  def main(args:Array[String]){
    println(value(FibonacciExpr(4)))
    println(value(FibonacciExpr(-5)))
  }
}