
/*Implicit classes make this kind of field and method grafting possible, but there are some restrictions about how you can define and use them:

    An implicit class must be defined within another object, class, or trait. Fortunately, implicit classes defined within objects can be easily imported to the current namespace.
    They must take a single nonimplicit class argument. In the preceding example, the Int parameter was sufficient to convert an Int to a Fishies class in order to access the fishes method.
    The implicit class’s name must not conflict with another object, class, or trait in the current namespace. Thus, a case class could not be used as an implicit class because its automatically generated companion object would break this rule.

    */

    object IntUtils {

       implicit class Fishies(val x: Int) {                             
         def fishes = "Fish" * x                                          
       }
       def main(args: Array[String]){
println(3.fishes)
       }
       
     } 

