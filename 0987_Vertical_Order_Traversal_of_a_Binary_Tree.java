 class Tuple{
     TreeNode node;
     int row;//vertical
     int column;//level 
     public Tuple(TreeNode node,int row,int column){
         this.node = node;
         this.row = row;
         this.column = column;
     }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
     TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map = new TreeMap<>();
     Queue<Tuple> queue = new LinkedList<Tuple>();
     queue.add(new Tuple(root,0,0));
     while(!queue.isEmpty()){
         Tuple tuple = queue.poll();
         TreeNode node = tuple.node;
         int x = tuple.row;
         int y = tuple.column;

         if(!map.containsKey(x)){
             map.put(x,new TreeMap<>());
         }
         if(!map.get(x).containsKey(y)){
             map.get(x).put(y,new PriorityQueue<>());
         }
         map.get(x).get(y).offer(node.val);
         if(node.left!=null){
             queue.offer(new Tuple(node.left,x-1,y+1));
         }
         if(node.right!=null){
             queue.offer(new Tuple(node.right,x+1,y+1));
         }
     }
     List<List<Integer>>list = new ArrayList<>();
    for(TreeMap<Integer,PriorityQueue<Integer>>ys:map.values()){
        list.add(new ArrayList<>());
        for(PriorityQueue<Integer>nodes:ys.values()){
            while(!nodes.isEmpty()){
                System.out.println(nodes.peek());
                list.get(list.size()-1).add(nodes.poll());
            }
        }
    }
        return list;
    }
}
