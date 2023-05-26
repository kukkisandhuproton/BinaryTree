/**
Take a stack and push the root node to it.

Set a while loop till the stack is non-empty.

In every iteration, take the node at the top of the stack( say cur) and pop the stack.

If cur has a right child, push it to the stack.

If cur has a left child, push it to the stack.

Set the right child of cur to node at stack’s top.

Set the left child of cur as NULL.
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current.right!=null){
                stack.push(current.right);
            }
            if(current.left!=null){
                stack.push(current.left);
            }
            if(!stack.isEmpty()){
                current.right=stack.peek();
            }
            current.left=null;
        }
    }
}
