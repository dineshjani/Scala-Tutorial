object Callby{
    
    def something():Int= {
        println("in something fun")
        5
    }
    def callby(x:Int):Int={
    println("call by function called")
    println(x)
    return x
    }
    val f=(x:Int)=>x+1

    def main(args: Array[String]){
        println("in main")
        callby(something())
        println(f(5))
        println(f.apply(5))
        callby(f(5))
    }
}
