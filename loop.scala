import scala.util.control.Breaks._
object loop{
    def main(args: Array[String]){
        var a=0
        breakable{

        while(a<6){
            println("value of a is ",+a)
            if(a==4){
                break
            }
            a=a+1
        }
    }
    }
}