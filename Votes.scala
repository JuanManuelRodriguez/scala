import scala.io.Source

object Test{
  def main(args:Array[String]){
    println("Hola votante")
    val file = Source.fromFile("./csv/AcumuladoVotos.csv")
    val fileAux = file.getLines.foreach(_.split(';').foreach(println))
    
    file.close()
  }
}