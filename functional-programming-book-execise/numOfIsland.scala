object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
          val directions = List((1, 0), (0, 1), (-1, 0), (0, -1))

            def bfs(queue: List[(Int, Int)], visited: Set[(Int, Int)]): Set[(Int, Int)] = {
              queue match {
                case Nil => visited
                case (x, y) :: tail =>
                  val (newQueue, newVisited) = directions.foldLeft((tail, visited + ((x, y)))) {
                    case ((q, v), (dx, dy)) =>
                      val newX = x + dx
                      val newY = y + dy
                      if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid(0).length &&
                        grid(newX)(newY) == '1' && !v.contains((newX, newY))) {
                        ((newX, newY) :: q, v + ((newX, newY)))
                      } else {
                        (q, v)
                      }
                  }
                  bfs(newQueue, newVisited)
              }
            }

            def findIslands(x: Int, y: Int, visited: Set[(Int, Int)], islandCount: Int): Int = {
              if (x >= grid.length) {
                islandCount
              } else if (y >= grid(0).length) {
                findIslands(x + 1, 0, visited, islandCount)
              } else if (grid(x)(y) == '1' && !visited.contains((x, y))) {
                val newVisited = bfs(List((x, y)), visited)
                findIslands(x, y + 1, newVisited, islandCount + 1)
              } else {
                findIslands(x, y + 1, visited, islandCount)
              }
            }

            findIslands(0, 0, Set.empty, 0)

    }
}