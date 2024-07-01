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
        if(root == null){
            return null;
}
        if(p.value<root.value && root.value>q.value){
            return lowestCommonAncestor(root.left,p,q);
}
        else if (p.value>root.value && root.value<q.value){
            return lowestCommonAncestor(root.right,p,q);
}
        return root;
    }
}