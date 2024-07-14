object Solution {
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        val prefixProductList = nums.toList.foldLeft((List.empty[Int], 1)) {
    case ((Nil, agg), ele) => (List(ele * agg), ele * agg)
    case ((list, agg), ele) => ((ele * agg) :: list, ele * agg)
  }._1
        println(prefixProductList)

          val (newList, agg) = nums.toList.tail.reverse.zip(prefixProductList.tail).foldLeft((List.empty[Int], 1)) {
            case ((list, agg), (ele1, ele2)) => ((ele2 * agg) :: list, ele1 * agg)
          }

          (agg :: newList).toArray
        
    }
}