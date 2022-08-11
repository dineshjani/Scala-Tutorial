
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import collection.mutable

object nonblocking{
    
    def something():Future[Int]= {
        println("in something fun")
        Thread.sleep(1000)
        var f = Future[Int]{

            5
        }
        f
        
    }
    def main(args: Array[String]){
        println("in main")
        something()   //here result is not computed but not block next line and if we want then use await
       println("its blcoking code")   // forn execute this line we can use feature so that next line can be exccuted
    }
}