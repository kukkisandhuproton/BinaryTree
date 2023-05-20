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
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int[]result = new int[1];
        result[0] = Integer.MIN_VALUE;
        helper(root,result);
        return result[0];
    }
    public int helper(TreeNode root,int[]sum){
        if(root == null){
            return 0;
        }
        int leftH = Math.max(0,helper(root.left,sum));
        int rightH = Math.max(0,helper(root.right,sum));

        sum[0] = Math.max(sum[0],leftH+rightH+root.val);

        return root.val+Math.max(leftH,rightH);
    }
}
