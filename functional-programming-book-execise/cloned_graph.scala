/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var neighbors: List[Node] = List()
 * }
 */

object Solution {
    def cloneGraph(graph: Node): Node = {
          def dfs(p: Node, map: Map[Node, Node]): (Node, Map[Node, Node]) = {
      if (p == null) (null, map)
      else if (map.contains(p)) (map(p), map)
      else {
        val n = new Node(p.value)
        val updatedMap = map + (p -> n)
        val (newNeighbors, finalMap) = p.neighbors.foldLeft((List[Node](), updatedMap)) {
          case ((neighbors, currentMap), neighbor) =>
            val (clonedNeighbor, newMap) = dfs(neighbor, currentMap)
            (clonedNeighbor :: neighbors, newMap)
        }
        n.neighbors = newNeighbors.reverse
        (n, finalMap)
      }
    }

          dfs(graph, Map.empty)._1
    }
}