object fact {

        def calFact(n: Int): Int = {
            def tailRecur(n:Int, acc:Int): Int = {
                if(n<=1){
                    acc
                }
                else{
                    tailRecur(n-1, n*acc)
                }
            }


            tailRecur(n, 1)
        }

    def main(args: Array[String]): Unit = {
        val a = calFact(5)
        println(s"value of fact is $a")
    }

}