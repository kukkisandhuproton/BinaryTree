/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //left<root<right
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode current = root;// roots value
        while(true){
            //means it is on the right side
            if(val>=current.val){
                if(current.right!=null){
                    current = current.right;
                }
                else{
                    current.right = new TreeNode(val);
                    break;
                }
            }
            // means it is on the left side
            else{
                if(current.left!=null){
                    current=current.left;
                }
                else{
                    current.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
