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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<String> result = new ArrayList<>();
        helper(root,result,"");
        int sum = 0;
        for(String num:result){
            sum = sum+Integer.valueOf(num);
        }
        return Integer.valueOf(sum);
    }
    public void helper(TreeNode root,ArrayList<String> result,String path){
        if(root == null){
            return;
        }
        path = path+root.val;
        helper(root.left,result,path);
        helper(root.right,result,path);
        if(root.left == null && root.right == null){
            result.add(path);
        }
    }
}
