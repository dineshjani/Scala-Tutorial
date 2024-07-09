/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
 def levelOrder(root: TreeNode): List[List[Int]] = {
    def recur(prevList: List[TreeNode], curList: List[TreeNode], result: List[List[Int]]): List[List[Int]] = {
      prevList match {
        case Nil if curList.isEmpty => result
        case Nil => recur(curList, List.empty, result :+ curList.map(_.value))
        case head :: tail =>
          val newCurList = curList ++ List(head.left, head.right).filter(_ != null)
          recur(tail, newCurList, result)
      }
    }

    if (root == null) List.empty
    else recur(List(root), List.empty, List(List(root.value)))
  }
}