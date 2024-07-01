/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
  root match {
            case null => null
            case _ if root.value == p.value || root.value == q.value => root
            case _ => (lowestCommonAncestor(root.left,p,q), lowestCommonAncestor(root.right,p,q)) match {
                       case (null, rightTree) => rightTree 
                       case (leftTree, null) => leftTree
                       case _ => root
                    }
        }
    }
}