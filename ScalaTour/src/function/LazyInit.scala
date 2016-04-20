package function
import java.net.URLDecoder
import java.nio.charset.Charset
class ScalaCurrentVersion(val url:String){
  lazy val source={
    println("fetching from url...")
    val iter=scala.io.Source.fromURL(url).getLines()
    val charset = Charset.forName("utf8")
    scala.io.Source.fromURL(url)(scala.io.Codec("UTF-8")).getLines().toList
   // scala.io.Source.fromURL(url,"UTF-8").getLines().toList
  }
  lazy val majorVersion=source.find(_.contains("version.major"))
  lazy val minorVersion=source.find(_.contains("version.minor"))
}

object LazyInit {
  def main(args: Array[String]): Unit = {
    val version = new ScalaCurrentVersion(
      "https://github.com/scala/scala/blob/2.12.x/build.number")
    println("get scala version from "+version.url)
    version.majorVersion.foreach(println _)
    version.minorVersion.foreach(println _)
  }
}