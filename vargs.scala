object Vargs
{
    def sum(a:Int,b:Int,args: Int*) : Int={
     var sum:Int=0
     sum=sum+a+b
     for(arg <- args){
        sum=sum+arg;
     }
return sum;
    }
    def main(args: Array[String])
    {
        println(sum(4,45,5,6,7,7))
        println("variable ")
    }
}