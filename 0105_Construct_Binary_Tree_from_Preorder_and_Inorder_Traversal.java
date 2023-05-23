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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            hashmap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hashmap);
        return root;
    }
    public TreeNode buildTree(int[]preorder,int prestart,int preend,int[]inorder,int instart,int inend,Map<Integer,Integer> hashmap){
        if(prestart>preend || instart>inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = hashmap.get(root.val);
        int numsleft = inroot - instart;

        root.left = buildTree(preorder,prestart+1,prestart+numsleft,inorder,instart,inroot-1,hashmap);
        root.right = buildTree(preorder,prestart+numsleft+1,preend,inorder,inroot+1,inend,hashmap);

        return root;
    }
}
