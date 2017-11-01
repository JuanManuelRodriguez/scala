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


    var x = new HashMap[String,String](){}
    //val fileAux2 = file.getLines().toList.foreach(y => x += (y.split(";")(0) -> y.split(";")(5)))
    val fileAux2 = file.getLines().toList
    fileAux2.foreach(y => x += (y.split(";")(0) -> fileAux2.reduceLeft(_ + _.split(";")(5))))

    file.close()


    x.foreach(println)
    println(x("Buenos Aires"))
  }
}