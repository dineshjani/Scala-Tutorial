object PatternMatching{
    def main(args: Array[String]){


    }
    def myTest(x:Any){
        //x is passed here
       val msg=x match{
               case i:Int => "It is Integer ="+i
               case s:String => "It is string ="+s
               case d:Double => "It is Double "+d
              


        }
       
        println(msg)
    }
    myTest(5)
}