import scala.math.max
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def diameterOfBinaryTree(root: TreeNode): Int = {
       def height(node: TreeNode): Int =
            if (node == null) 0 else 1 + max(height(node.left), height(node.right))
        
        def diameter(node: TreeNode): Int =
            if (node == null) 0 else max(height(node.left) + height(node.right), max(diameter(node.left), diameter(node.right)))
        
        diameter(root)
    }
}