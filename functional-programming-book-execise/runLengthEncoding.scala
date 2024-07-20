object removeKthElement {
    def recur(originalList: List[Int], curNum:Int, count:Int): List[(Int,Int)] = {
        if(originalList==Nil) {
            List((curNum,count))
        }
        else {
       originalList match {
        case head :: tail if(head==curNum) => recur(originalList.tail,curNum,count+1)
        case head :: tail => (curNum,count) :: recur(originalList.tail,head,1)
       }
        }
    }
    def main(args:Array[String]):Unit = {
        val originalList = List(1,1,2,3,3,3,4,4,5)
        val k = 2
        println(recur(originalList.tail,originalList.head,1))
    }
}