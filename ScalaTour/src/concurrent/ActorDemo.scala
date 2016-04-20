package concurrent
import akka.actor.{Actor,ActorSystem, Props}
class EchoServer extends Actor{
  def receive={
    case msg:String => println("echo:"+msg)
  }
}
object ActorDemo {
  def main(args: Array[String]): Unit = {
    val system=ActorSystem()
    val echoServer=system.actorOf(Props[EchoServer])
    echoServer ! "hi"
    system.shutdown
  }
}