object rotate {
    def rotateElement(originalList: List[Int],k:Int): List[Int] = {
      if(k==0){
        originalList
      }
      else {
        rotateElement(originalList.tail :+ originalList.head, k-1)
      }
    }
    def main(args:Array[String]):Unit = {
        val originalList = List(5, 1, 4, 3, 2)
        val k = 2
        println(rotateElement(originalList,k))
    }
}
