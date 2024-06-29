object ListToMapConverter {
  def listToMap[A, B](list: List[(A, B)]): Map[A, List[B]] = {
    list.groupBy(_._1).view.mapValues(_.map(_._2)).toMap
  }

  def main(args: Array[String]): Unit = {
    val list: List[(Int, String)] = List((1, "a"), (2, "b"), (1, "c"), (2, "d"), (3, "e"))
    val result: Map[Int, List[String]] = listToMap(list)
    println(result)  // Output: Map(1 -> List(a, c), 2 -> List(b, d), 3 -> List(e))
  }
}
