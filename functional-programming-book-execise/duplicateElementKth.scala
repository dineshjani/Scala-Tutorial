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