class User{
    //members are private and methods public by default but they have internal getters and setters  method
    // function represent as a function object
    val firstname ="dinesh"
    val lastname ="jani"
    def greet:String=s"hello from $firstname $lastname"
    override def toString() = s"User ($firstname)"

}
object Oops1{
    def main(args: Array[String]){
val a= new User
println(a)
println("ram")
println(a.greet)
println(a.firstname)

    }
}