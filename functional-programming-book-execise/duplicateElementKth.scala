object duplicateKthTimesElement {
    def duplicateKthTimesEachElement(originalList: List[Int],k:Int): List[Int] = {
      val newList = for {
      ele <- originalList
      _ <- 1 to k
    } yield ele

    newList
    }
    def main(args:Array[String]):Unit = {
        val originalList = List(5, 1, 4, 3, 2)
        val k = 2
        println(duplicateKthTimesEachElement(originalList,k))
    }
}


// object DuplicateKthTimesElement {
//   def duplicateKthTimesEachElement(originalList: List[Int], k: Int): List[Int] = {
//     def duplicateElement(element: Int, times: Int, acc: List[Int]): List[Int] = {
//       if (times <= 0) acc
//       else duplicateElement(element, times - 1, acc :+ element)
//     }

//     def duplicateList(elements: List[Int], acc: List[Int]): List[Int] = {
//       elements match {
//         case Nil => acc
//         case head :: tail => duplicateList(tail, acc ++ duplicateElement(head, k, Nil))
//       }
//     }

//     duplicateList(originalList, Nil)
//   }

//   def main(args: Array[String]): Unit = {
//     val originalList = List(5, 1, 4, 3, 2)
//     val k = 2
//     println(duplicateKthTimesEachElement(originalList, k)) // Output: List(5, 5, 1, 1, 4, 4, 3, 3, 2, 2)
//   }
// }