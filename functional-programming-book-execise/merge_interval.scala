object Solution {
    def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
       val intervalsList = intervals.toList
    
    // Define a helper function to process intervals recursively
        def insertInterval(intervals: List[Array[Int]], newInterval: Array[Int], result: List[Array[Int]]): List[Array[Int]] = intervals match {
          case Nil => result :+ newInterval
          case travel :: tail =>
            if (travel(1) < newInterval(0)) {
              // Current interval is completely before new interval
              insertInterval(tail, newInterval, result :+ travel)
            } else if (travel(0) > newInterval(1)) {
              // Current interval is completely after new interval
              insertInterval(tail, travel, result :+ newInterval)
            } else {
              // Overlapping intervals, merge them
              val mergedInterval = Array(
                Math.min(travel(0), newInterval(0)),
                Math.max(travel(1), newInterval(1))
              )
              insertInterval(tail, mergedInterval, result)
            }
        }

    // Call the helper function with the initial data
        val resultList = insertInterval(intervalsList, newInterval, List.empty)

    // Convert the result list back to an array
        resultList.toArray 
    }
}