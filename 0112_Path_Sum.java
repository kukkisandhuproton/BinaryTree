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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        helper(root,result,sum);
         //returns true
        if(result.contains(targetSum)){
            return true;
        }
        return false;
    }
    public void helper(TreeNode root,ArrayList<Integer>result,int sum){
        if(root == null){
            return;
        }
        sum = sum+root.val;
        helper(root.left,result,sum);
        helper(root.right,result,sum);
        if(root.left==null && root.right==null){
            result.add(sum);
        }
    }
}
