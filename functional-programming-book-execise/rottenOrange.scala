object Solution {
    def orangesRotting(grid: Array[Array[Int]]): Int = {
          val directions = List((1, 0), (0, 1), (-1, 0), (0, -1))


            val initialQueue = (for {
              x <- grid.indices
              y <- grid(x).indices if grid(x)(y) == 2
            } yield (x, y)).toList

            def recur(queue: List[(Int, Int)], visited: Set[(Int, Int)], time: Int): Int = {
              println(queue)
              if (queue.isEmpty) {
                if (grid.exists(row => row.contains(1))) -1
                else if(time!=0)  time-1
                else  time
              } else {
                val (newQueue, newVisited) = queue.foldLeft((List.empty[(Int, Int)], visited)) {
                  case ((q, v), (x, y)) =>
                    directions.foldLeft((q, v)) {
                      case ((newQ, newV), (dx, dy)) =>
                        val newX = x + dx
                        val newY = y + dy
                        if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid(0).length &&
                          grid(newX)(newY) == 1 && !newV.contains((newX, newY))) {
                          grid(newX)(newY) = 2
                          (newQ :+ (newX, newY), newV + ((newX, newY)))
                        } else {
                          (newQ, newV)
                        }
                    }
                }
                recur(newQueue, newVisited, time + 1)
              }
        }

            recur(initialQueue, initialQueue.toSet, 0)        
    }
}