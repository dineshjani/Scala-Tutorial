import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import collection.mutable

object feature{
def execute(function_name: String): String = {
  println("Running " + function_name)
  // do something
  Thread.sleep(2000)

  function_name
}

var functions = Array("function_1", "function_2", "function_3")
val function_states: mutable.Map[String, String] = mutable.Map()

def start() = {
    println("Started")
  functions.foreach(function => {
    // Execute functions in future which will return a string on completion
    var f = Future[String] {
      execute(function)
    }

    f.onComplete({
      case Success(return_value) => {
        println(return_value + " completed successfully")
        function_states(function) = "success"
        
      }
      case Failure(e) => {
        function_states(function) = "failed"
        e.printStackTrace()
      }
    })
  })
}
def main(args:Array[String]){
feature.start()
}

}