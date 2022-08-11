//each object have sepearted feature like mulktiplier class have doubler triplet objects  ek hi class ma 2 baar value pass kiya ek sidha class iinitliaze with new dusra without new to apply call ho gya
class Multiplier(val x:Int){
    // apply call when we pass parameter to class without new 
    def apply(y:Int)=x*y
}

object Multiplier{
    def apply(x:Int)=new Multiplier(x)

    def main(args: Array[String]){
        val doubler=Multiplier(2)
        println(doubler(2))
        val triplet=Multiplier(3)
        println(triplet(3))
    }
}

//factory design => companion class + companion object + apply method