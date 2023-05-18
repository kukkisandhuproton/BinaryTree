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
class Solution {
    public boolean isBalanced(TreeNode root) {
        
// check height in the tree and if left heigh and right height differ by return false
        if(root == null){
            return true;
        }
        int answer = checkheight(root);
        if(answer==-1){
            return false;
        }        
        else{
            return true;
        }
    }
    public int checkheight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftheight = checkheight(root.left);
        if(leftheight == -1){
            return -1;
        }
        int rigthheight = checkheight(root.right);
        if(rigthheight==-1){
            return -1;
        }
        if(Math.abs(leftheight-rigthheight)>1){
            return -1;
        } 

        return 1+Math.max(leftheight,rigthheight);
    }
}
