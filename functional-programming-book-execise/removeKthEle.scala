object removeKthElement {
    def recur(originalList: List[Int],backUp: List[Int], curIndex:Int, k:Int): List[Int] = {
        if(curIndex==k) {
            backUp.reverse ++ originalList.tail
        }
        else {
        recur(originalList.tail, originalList.head :: backUp, curIndex+1,k)
        }
    }
    def main(args:Array[String]):Unit = {
        val originalList = List(5, 1, 4, 3, 2)
        val k = 2
        println(recur(originalList,List.empty,0,k))
    }
}