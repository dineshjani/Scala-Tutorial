/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isBalanced(root: TreeNode): Boolean = {
    if(root==null){
            return true
}
    val l = height(root.left)
    val r = height(root.right)
    if (Math.abs(l-r)>=2 || !isBalanced(root.left) || !isBalanced(root.right)){
            return false
}
        return true;
    }
        def height(root: TreeNode):Int ={
        if(root==null){
            return 0
}
        val l = height(root.left)
         val r = height(root.right)
        return  Math.max(l,r)+1
    }
}