
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return root;
        }
        TreeNode current = root;
        while(root!=null && root.val!=val){
            root = val<=root.val?root.left:root.right;
        }
    return root;     
    }
}
