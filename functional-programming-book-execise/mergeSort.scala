object MergeSort {
  def mergeSort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = {
    def merge(left: List[T], right: List[T]): List[T] = (left, right) match {
      case (Nil, _) => right
      case (_, Nil) => left
      case (x :: xs, y :: ys) =>
        if (ord.lt(x, y)) x :: merge(xs, right)
        else y :: merge(left, ys)
    }

    val n = list.length
    if (n <= 1) list
    else {
      val (left, right) = list.splitAt(n / 2)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  def main(args: Array[String]): Unit = {
    val list = List(5, 3, 8, 4, 2, 7, 1, 6)
    val sortedList = mergeSort(list)
    println(sortedList) // Output: List(1, 2, 3, 4, 5, 6, 7, 8)
  }
}
