class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> mapnodes = new HashMap<>();
        TreeNode target = mapnodes(mapnodes,root,start);
        return distance(mapnodes,target);

    }
    public int distance(HashMap<TreeNode,TreeNode>map,TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode,Integer> visited = new HashMap<>();
        queue.offer(root);
        visited.put(root,1);
        int maximum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int flag = 0;
            for(int i =0;i<size;i++){
                TreeNode current = queue.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    flag = 1;
                    queue.offer(current.left);
                    visited.put(current.left,1);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    flag = 1;
                    queue.offer(current.right);
                    visited.put(current.right,1);
                }
                if(map.get(current)!=null && visited.get(map.get(current))==null){
                    flag = 1;
                    queue.offer(map.get(current));
                    visited.put(map.get(current),1);
                }
            }
            if(flag == 1){
                maximum++;
            }
        }
    return maximum;
    }
    public TreeNode mapnodes(HashMap<TreeNode,TreeNode>map,TreeNode root,int start){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode result = new TreeNode(-1);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.val == start){
                result = current;
            }
            if(current.left!=null){
                queue.offer(current.left);
                map.put(current.left,current);
            }
            if(current.right!=null){
                queue.offer(current.right);
                map.put(current.right,current);
            }
        }
        return result;
    }
}
