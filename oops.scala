class Geeks1{
    var Name: String = "Ankita"
    def run():Unit={
        println("base class run")
    }
}
 
// Derived class
// Using extends keyword
class Geeks2 extends Geeks1
{
    var Article_no: Int = 130
     
    // Method
    def details()
    {
    println("Author name: " +Name);
    println("Total numbers of articles: " +Article_no);
    println(OOPS.a)
    }
    override def run(){
        
        println("derived class run")
    }

}          
 
object OOPS
{
    var a=2 
    // Driver code
    def main(args: Array[String])
    {
         
        // Creating object of derived class
        val ob = new Geeks2();
        val ob1=new Geeks1()
        println(ob.Name)
        ob.details();
        ob.run()
        ob1.run() }
}