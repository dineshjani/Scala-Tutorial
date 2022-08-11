class  Abc {
//companiion class
var count:Int=_

def count1():Unit={
 count=count+1
}
}
object Abc{
    var x:Int=_
    //companion object
def main(args: Array[String]){
val a1=new Abc
a1.count1();
val a2=new Abc
a2.count1()
val a3=new Abc
a3.count1()
println(a3.count)


}
}