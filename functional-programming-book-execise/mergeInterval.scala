object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
               val intervalList = intervals.map { case Array(start, end) => (start, end) }.toList
                val sortedIntervals = intervalList.sortBy(interval => (interval._1, interval._2))

                val mergedIntervals = sortedIntervals.foldLeft(List.empty[(Int, Int)]) {
                    case (Nil, interval) => List(interval)
                    case (merged :: rest, interval) =>
                        if (merged._2 >= interval._1) {
                            (merged._1, Math.max(merged._2, interval._2)) :: rest
                        } else {
                            interval :: merged :: rest
                        }
                }.reverse 

                mergedIntervals.map { case (start, end) => Array(start, end) }.toArray
    }
}