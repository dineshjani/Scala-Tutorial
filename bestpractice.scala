object  bestpractice{
    def hello(name: Option[String]) = {
  val n = name.getOrElse("anonymous")
  println(s"Hello, $n")
}
def hello1(name: Option[String]) = {
    name match{
        case Some(s) => s
        case None =>"Not found"
    }
}
    def main(args:Array[String]){
        val a:String="dinesh"
         val name = Map("Nidhi" -> "author", 
                        "Geeta" -> "coder")
        println(a)
        hello(Some(a))
        println(hello1(Some(a)))
        hello(None)
        println(Array(1,2)==Array(1,2))
        println(List(1,2)==List(1,2))
        println(Set(1,2)==Set(1,2))
        println(Vector(1,2)==Vector(1,2))
    }
}



/*
flatmap


*/