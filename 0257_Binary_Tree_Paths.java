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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root,result,"");
        return result;        
    }
    public void helper(TreeNode root,List<String>result,String path){
        if(root == null){
            return;
        }
        path = path+root.val;
        helper(root.left,result,path+"->");
        helper(root.right,result,path+"->");
        if(root.right==null && root.left==null){
            result.add(path);
        }
    }
}
