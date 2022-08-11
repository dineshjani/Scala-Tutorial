object  Map1{
    def main(args: Array[String]){
    val lookupsize=Map("s" -> 5,"j" -> "java")
    println(lookupsize("s"))
    //we will not get error even if not present in the map
    println(lookupsize.get("t"))
    val lookupsize1=Map("s" -> (5,10),"j" -> "java")
val t=lookupsize("s")
println(t)
var r=lookupsize1.map(_._2)
println(r)    
println(lookupsize1.keys)
println(lookupsize1.values)

 var name = (15, "chandan", true)
 println(name._1) // print 1st element

 val lookup=Map("a" -> "apple","b" -> "boy","c" -> "cat")
 val e=lookup.map(a=>a._2.size)
 println(e)

 val f=lookup.map(a=>(a._1-> a._2.size))
 println(f)
var g=f+("d" -> "dog")
println(g)
var k=Map("f" -> "fish")
var h=g++k
println(h)

var list1=List((1,2),(2,3),(4,5),(1,6))
var w=list1.filter(e=>{
    e match{
        case(1,_)=>true
        case _ =>false
    }
})
println(w)
var list2=list1.sortBy(_._1)
var list3=list1.sortBy(-_._1)

print(list3)
println(list2)
    }
}