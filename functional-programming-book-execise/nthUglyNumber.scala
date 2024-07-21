import scala.collection.immutable.Queue

object UglyNumber {

  def merge(k: Int, q1: Queue[Long], q2: Queue[Long], q3: Queue[Long], n: Int): Long = {
    val min = List(q1.headOption, q2.headOption, q3.headOption).flatten.min

    if (n == k) min
    else {
      val newQ1 = if (q1.headOption.contains(min)) q1.tail else q1
      val newQ2 = if (q2.headOption.contains(min)) q2.tail else q2
      val newQ3 = if (q3.headOption.contains(min)) q3.tail else q3

      merge(k, newQ1.enqueue(min * 2), newQ2.enqueue(min * 3), newQ3.enqueue(min * 5), n + 1)
    }
  }

  def nthUglyNumber(k: Int): Long = {
    if (k == 1) 1
    else {
      val initialQ1 = Queue(2L)
      val initialQ2 = Queue(3L)
      val initialQ3 = Queue(5L)
      merge(k, initialQ1, initialQ2, initialQ3, 2)
    }
  }

  def main(args: Array[String]): Unit = {
    val k = 10
    println(s"The ${k}th ugly number is ${nthUglyNumber(k)}")
  }
}
