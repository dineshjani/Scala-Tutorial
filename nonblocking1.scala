
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object nonblocking1{
    def something(): Future[Unit] = {
       Future {
        println("deployment started")
        Future {
        println("deployment failed and trying to restart")
        }            
       } 
    }
    def main(args: Array[String]){
        something()
    }
}