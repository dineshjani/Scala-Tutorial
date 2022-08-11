/* Multiple inheritance is not allowed in java because of diamnond problem (ambiguity of same function from both classes)
java allow from multiple interface 
class A imp I2 ,imp I3 becuase I1 has no defintion for method so class A have no ambiguity.class A has to define those method
but in method definition is allowed in traits so ambiguity shoudl arise?
t4 with t2 with t3
class XYZ extent t1 with t2 with t3 (extend with first traits remaining with)  
               t3 super function wull call t2(not his parent)and t2 super log will call t1 log and t log will call his paraent function
    
scala solved diamond problem by calling right to left(immediate poarent)

1. object level maxing
2. diamond problem solutions
3. restricting classes from mixing with traits

trait buffering {
    this: Inputstream => here syntax meaning is that only subclass of Inputstraem can use of bufferring trait
    this: Inputstream  =>here syntax meaning is that only subclass of both Inputstraem and logger  can use of bufferring trait

}
 */
// Trait 1
trait MyTrait1
{
      
    // Abstract method / field
    def greeting
   var value: Int 
      
    // Concrete field
    var Height = 10
    val Width = 30
}
  
//Trait 2
trait MyTrait2
{
      
    // Non-abstract method
    def tutorial
    {
        println("This is a tutorial" + 
               "of Traits in Scala")
    }
}
  
// MyClass inherits multiple traits
class MyClass extends MyTrait1 with MyTrait2
{ 
   //implement abstarct field
       var value = 12
    // Implementation of abstract method

    def greeting()
    {
        println("Welcome to GeeksfoGeeks")
    }

    // override mytarit field val have to keyword override
      Height = 40
    override val Width = 10

     def Display()
    {
        println("Value:%d", value);
        println("\nHeight:%d" ,Height);
        println("\nWidth:%d", Width);
    }

} 
  
object Maintrait
{
      
    // Main method
    def main(args: Array[String]) 
    {
        val obj = new MyClass();
        obj.greeting
        obj.tutorial
        obj.Display
    }
}