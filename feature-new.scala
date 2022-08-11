import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import collection.mutable
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object feature1{
def execute(function_name: String): String = {
  println("Running " + function_name)
  // do something
  Thread.sleep(10)
  function_name
}

var functions = Array("function_1", "function_2", "function_3")
val function_states: mutable.Map[String, String] = mutable.Map()       // map declaration

def start() :Option[String]= {
    println("Started")
  functions.foreach(function => {
    // Execute functions in future which will return a string on completion
    var f = Future[String] {
      execute(function)
      
    }
    f.onComplete({
      case Success(return_value) => {
        function_states(function) = "success"
        println(return_value + " completed successfully")
        println(function_states)
      }
      case Failure(e) => {
        function_states(function) = "failed"
        e.printStackTrace()
      }
         })
  })
  val a:String="Ram"
  Some(a)
}
def main(args:Array[String]){
    
 val f=Future[Option[String]] {
 feature1.start()
}
val a=Await.result(f,Duration.Inf)
println(feature.function_states)
}

}