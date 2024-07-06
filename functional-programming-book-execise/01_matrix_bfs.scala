object Solution {
    def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
        val numRows = mat.length
        val numCols = mat(0).length
        val res = Array.fill(numRows, numCols)(Int.MaxValue)
        val adj = List((-1, 0), (1, 0), (0, -1), (0, 1))

        // Initialize result matrix and queue
        val initialQueue = (for {
          row <- 0 until numRows
          col <- 0 until numCols if mat(row)(col) == 0
        } yield {
          res(row)(col) = 0
          (row, col)
        }).toList

        @annotation.tailrec
        def bfs(queue: List[(Int, Int)], result: Array[Array[Int]]): Array[Array[Int]] = {
          queue match {
            case Nil => result
            case (r, c) :: tail =>
              val updatedQueue = adj.foldLeft(tail) { case (acc, (dr, dc)) =>
                val newR = r + dr
                val newC = c + dc
                if (newR >= 0 && newR < numRows && newC >= 0 && newC < numCols && result(newR)(newC) > result(r)(c) + 1) {
                  result(newR)(newC) = result(r)(c) + 1
                  acc :+ (newR, newC)
                } else {
                  acc
                }
              }
              bfs(updatedQueue, result)
          }
        }

        bfs(initialQueue, res)
    }
}