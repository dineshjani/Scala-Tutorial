object IsPrime {
    def isPrime(num:Int,curNum:Int):Boolean = {
        if(curNum>Math.sqrt(num)) true
        else{
            num%curNum!=0 && isPrime(num,curNum+1)
        }
    }

    def main(args: Array[String]):Unit = {
        println(isPrime(17,2))
    }
}