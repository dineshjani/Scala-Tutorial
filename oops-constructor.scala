class User1(val firstname:String,val lastname:String){
    //members are private and methods public by default but they have internal getters and setters  method
    // function represent as a function object
    /*
    var firstname =fn
    var lastname =ln
    do not need this compiler automatic put value in first and last name 
    */
    println("user defined constructor when no parameter are passed during object creationj")
    def this()={
        
        this("dinesh","jani")
    }
    def greet:String=s"hello from $firstname $lastname"
    override def toString() = s"User ($firstname)"
   
}
class User2(val firstname:String,val lastname:String){
   var age:Int = _           //default assignment if int then  0 if string then  Nulls
    println("user defined constructor when no parameter are passed during object creationj")
    def this(firstname:String,lastname:String,a:Int)={
        this(firstname,lastname)
        println("this called")
        age=a
    }
    def greet:String=s"hello from $firstname $lastname"
    override def toString() = s"User ($firstname)"
   
}
object Oops2{
    def main(args: Array[String]){
        //call user defined constructor
val a= new User1
println(a)
// call automatic compiler constructor
val b =new User1("aish","jani")
println(b)
val c= new User2("Yuvaan","jani")
print(c.firstname)
val d= new User2("Yuvaan","jani",18)
print(d)
    }
}




/*
class User2(val firstname:String,val lastname:String) => getters are created for firstrname and lastname
class User2(firstname:String, lastname:String) =>no  getters and no setters are created for firstrname and lastname
class User2(var firstname:String,var lastname:String) => both getters and setters are created for firstrname and lastname2
class User2(val firstname:String,var lastname:String) => getters and setters are created for lastname and only getter for firstname
case class User2(firstname:String,lastname:String) => getters are created for firstrname and lastname because for case class automaticallly compiler created getters(val)

*/