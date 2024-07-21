object QuickSort {

  def quickSort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = list match {
    case Nil => Nil
    case pivot :: tail =>
      val (smaller, greater) = partition(tail, pivot, Nil, Nil)
      quickSort(smaller) ++ (pivot :: quickSort(greater))
  }

  private def partition[T](list: List[T], pivot: T, smaller: List[T], greater: List[T])
                          (implicit ord: Ordering[T]): (List[T], List[T]) = list match {
    case Nil => (smaller.reverse, greater.reverse)
    case head :: tail =>
      if (ord.lt(head, pivot))
        partition(tail, pivot, head :: smaller, greater)
      else
        partition(tail, pivot, smaller, head :: greater)
  }

  def main(args: Array[String]): Unit = {
    val list = List(5, 3, 8, 4, 2, 7, 1, 6)
    val sortedList = quickSort(list)
    println(sortedList) // Output: List(1, 2, 3, 4, 5, 6, 7, 8)
  }
}
