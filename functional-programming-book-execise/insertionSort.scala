object sortList {
    def addToSortedList(sortedList:List[Int], ele:Int, curList:List[Int]):List[Int]  = {
        if(sortedList==Nil){
            (ele :: curList).reverse
        }
        else {
            if(sortedList.head>ele){
              curList.reverse ++ List(ele) ++ sortedList }
            else {
              addToSortedList(sortedList.tail, ele, sortedList.head :: curList)
            }
        }
    }
    def sort(originalList: List[Int],sortedList:List[Int]): List[Int] = {
      if(originalList==Nil){
        sortedList
      }
      else {
        sort(originalList.tail,addToSortedList(sortedList,originalList.head, List.empty))
      }
    }
    def main(args:Array[String]):Unit = {
        val originalList = List(5, 1, 4, 3, 2)
        println(sort(originalList, List.empty))
    }
}
