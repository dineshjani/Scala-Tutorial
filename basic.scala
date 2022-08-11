object Type{
    def main(args:Array[String]){
        var l1=List(1,2,3,4)
        println(l1)
      //  l1=List(1,2,3,4,4.5) nwill give error beause of type int and after that double value assigned
        println(l1)
        var l2=List(1,2,3,4.5)
        println(l2)
        l2=List(1,2,3,4)  // double can take int value but int cannot take double value
        var l3=List(1,2,3,"ram")
        l3=List(1,2,3.5)      // not give error beacuse its take any type
        var l4=for(a <- 1 to 10) yield a * a
        println("check ")
        println(l4)
        var l9=l4.toSeq
        println(l9)
        var l10=l4.toList
        println(l10)
        var l5=for(b <- l4) yield b * b
        println(l5)
        var l6= for (a <- 0 to 4 ; e=a%2 ; if e==0) yield a * a
        println(l6)       
        for (a <- 0 to 4 ; e=a%2 ; if e==0) yield a * a
        l6.foreach(println(_))

        // function literal without func name   (usecase of HOF for passing function as a object in parameter)
        val myproduct = (a:Int,b:Int) =>   a*b

        val myproduct1: (Int,Int) =>Int=  _* _

        def add(a:Int,b:Int):Int={
          a+b
        }
        val ans=myproduct(2,3)
        val funobj=myproduct
        val ansp = funobj(2,3)
        val funobj1:(Int,Int) => Int = add   //another way to make function object
        val ansq=funobj1(2,3)
        println(ansq)
        println(ansp)
        println(ans)
 // take function as a parameter
        def stringops(a:String,b:String=>String):String={
 if(a!=null)  b(a)
 else a
 
        }
        def b(str:String):String={
          str.toUpperCase()
        }
        //passing function as a parameter
        println(stringops("dinesh",b))
        //passing function as a literal
println(stringops("dinesh",(b:String)=>b.toUpperCase))
println(stringops("dinesh", _.toUpperCase))
println(myproduct1(2,3))

def simpleops(a:Int,b:Int,f:(Int,Int)=>Int)={
  f(a,b)
}
println(simpleops(1,2,_+_))
var l7=l10.map((a:Int)=>a*a)
println(l7)





    }
}

