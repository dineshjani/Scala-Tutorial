object Solution {
    def invertTree(root: TreeNode): TreeNode = {
         
         if(root==null){
            return null;
        }
         val l = invertTree(root.left);
           val r = invertTree(root.right);
          root.left = r
          root.right = l
          root 
    }
}