object Solution {
    def canFinish(v: Int, pre: Array[Array[Int]]): Boolean = {
    val adjInit = Vector.fill(v)(Vector.empty[Int])
    val indegreeInit = Vector.fill(v)(0)

    val (adj, indegree) = pre.foldLeft((adjInit, indegreeInit)) { 
      case ((adj, indegree), Array(from, to)) =>
        (adj.updated(from, adj(from) :+ to), indegree.updated(to, indegree(to) + 1))
      case (acc, _) => acc 
    }

    val initialQueue = (0 until v).filter(indegree(_) == 0).toList

    @annotation.tailrec
    def bfs(queue: List[Int], count: Int, indegree: Vector[Int]): Int = queue match {
      case Nil => count
      case head :: tail =>
        val (newQueue, newIndegree) = adj(head).foldLeft((tail, indegree)) {
          case ((q, ind), neighbor) =>
            val updatedIndegree = ind.updated(neighbor, ind(neighbor) - 1)
            if (updatedIndegree(neighbor) == 0) (q :+ neighbor, updatedIndegree) else (q, updatedIndegree)
        }
        bfs(newQueue, count + 1, newIndegree)
    }

    bfs(initialQueue, 0, indegree) == v
    }
}