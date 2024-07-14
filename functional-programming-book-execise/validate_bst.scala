/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isValidBST(root: TreeNode): Boolean = {
        def checkBst(node: TreeNode, p: Long, q: Long): Boolean = {
      if (node == null) {
        true
      } else {
        val l = checkBst(node.left, p, node.value)
        if (!l) {
          false
        } else {
          val r = checkBst(node.right, node.value, q)
          if (l && r && node.value > p && node.value < q) {
            true
          } else {
            false
          }
        }
      }
    }

        checkBst(root, Long.MinValue, Long.MaxValue)
    }
}