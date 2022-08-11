object option
{
  
    // Main method
    def main(args: Array[String]):Unit=
    {
  
        // Creating a Map
        val name = Map("Nidhi" -> "author", 
                        "Geeta" -> "coder")
  
        // Accessing keys of the map
        val x = name.get("Nidhi")
        val y = name.get("Rahul")
  
        // Displays Some if the key is
        // found else None 
        println(name("Nidhi"))
        println(patrn(x))
        println(patrn(y))
    }
          def patrn(z: Option[String]):String={

         val a= z match 
    {
  
        // for 'Some' class the key for
        // the given value is displayed
        case Some(s) => s
  
        // for 'None' class the below string 
        // is displayed
        case None => "key not found"
    }
    a
    }
}
