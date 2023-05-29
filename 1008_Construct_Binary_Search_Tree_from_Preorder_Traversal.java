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
    public TreeNode bstFromPreorder(int[] preorder) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        for(int num:preorder){
            inorderList.add(num);
        }
        Collections.sort(inorderList);
        int[] inorder = new int[preorder.length];
        for(int i =0;i<inorder.length;i++){
            inorder[i]=inorderList.get(i);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildtree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
            return root;

    }

    public TreeNode buildtree(int[]preorder,int pstart,int pend,int[]inorder,int istart,int iend,HashMap<Integer,Integer>map){
        if(pstart>pend || istart>iend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int inroot = map.get(preorder[pstart]);
        int numsleft = inroot-istart;

root.left=buildtree(preorder,pstart+1,pstart+numsleft,inorder,istart,inroot-1,map);
root.right=buildtree(preorder,pstart+numsleft+1,pend,inorder,inroot+1,iend,map);

        return root;
    }
}
