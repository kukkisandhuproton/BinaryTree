//preorder Root Left right
class Solution {
    public int countNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return 0;
        }
        helper(root,result);
        return result.size();
    }
    public void helper(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }
}
