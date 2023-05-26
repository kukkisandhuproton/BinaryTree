/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static final String SEP =",";
    public static final String NULL ="null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==(null)){
            return NULL;
        }
        Queue<TreeNode>queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp==null){
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(temp.val).append(SEP);
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL)){
            return null;
        }
        String[] nodevalue = data.split(SEP);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodevalue[0]));
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(!nodevalue[index].equals(NULL)){
                temp.left=new TreeNode(Integer.parseInt(nodevalue[index]));
                queue.offer(temp.left);
            }
            index++;
            if(!nodevalue[index].equals(NULL)){
                temp.right=new TreeNode(Integer.parseInt(nodevalue[index]));
                queue.offer(temp.right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
