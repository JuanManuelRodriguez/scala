import scala.io.Source
import collection.mutable.HashMap

object Test{
  def main(args:Array[String]){
    println("Hola votante")
    val file = Source.fromFile("./csv/AcumuladoVotos.csv")
    println("///////////////////////////////////////////////////////////////////////////////////////////////////////")


    val contarVotos = (x: Int, y: Int) => {
      val winner = x + y
      println(s"compared $x to $y, $winner was larger")
      winner
    }

    val fileAux = file.getLines().toList
                                        .map(line => {
                                          val v = line.split(";")
                                          (v(0), v(1), v(2), v(3), v(4), v(5))
                                        })
    file.close()

    println("///////////////////////////////////////////////////////////////////////////////////////////////////////")
    println("///////////////////////////////////////////////////////////////////////////////////////////////////////")

    fileAux.filter(y =>{
                          val (provincia, distrito, mesa, partido, lista, votos) = y
                          provincia.equals("Buenos Aires")})
    .foreach(println)
  }
}