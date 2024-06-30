import scala.collection.immutable.Queue

object Solution {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, color: Int): Array[Array[Int]] = {
    val directions = List((0, 1), (1, 0), (0, -1), (-1, 0))
    val originalColor = image(sr)(sc)

    @annotation.tailrec
    def bfs(queue: Queue[(Int, Int)], visited: Set[(Int, Int)], img: Array[Array[Int]]): Array[Array[Int]] = {
      if (queue.isEmpty) {
        img
      } else {
        val ((x, y), restQueue) = queue.dequeue
        if (visited.contains((x, y))) {
          bfs(restQueue, visited, img)
        } else {
          val newImg = img.map(_.clone)
          newImg(x)(y) = color
          val neighbors = directions.collect {
            case (dx, dy) if x + dx >= 0 && x + dx < img.length && y + dy >= 0 && y + dy < img(0).length && 
                             img(x + dx)(y + dy) == originalColor && !visited.contains((x + dx, y + dy)) =>
              (x + dx, y + dy)
          }
          bfs(restQueue.enqueueAll(neighbors), visited + ((x, y)), newImg)
        }
      }
    }

    bfs(Queue((sr, sc)), Set.empty, image.map(_.clone))
  }
}
