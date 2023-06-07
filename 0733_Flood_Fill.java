class Pair{
    int f;
    int s;
    public Pair(int f, int s){
        this.f=f;
        this.s=s;
    }
}
class Solution {
    int[]dx = new int[]{-1,0,1,0};
    int[]dy = new int[]{0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc]==color){
            return image;
        }
        boolean[][] visited = new boolean[m][n];
        int[][] result = bfs(image,sr,sc,color,visited);
        return result;
    }
    public int[][] bfs(int[][]image,int sr,int sc, int color, boolean[][]visited){
       int row = image.length;
       int column = image[0].length;
        Queue<Pair> queue = new LinkedList<>();
        visited[sr][sc]=true;
        queue.offer(new Pair(sr,sc));
        int targetImageColor = image[sr][sc];
        image[sr][sc]=color;
        while(!queue.isEmpty()){

            int r = queue.peek().f;
            int c = queue.peek().s;
            queue.remove();

            for(int i =0;i<4;i++){
                int nextr = r+dx[i];
                int nextc = c+dy[i];

                    if(nextr>=0 && nextr<row && nextc>=0 && nextc<column && !visited[nextr][nextc] && image[nextr][nextc]==targetImageColor){
                        visited[nextr][nextc]=true;
                        image[nextr][nextc]=color;
                        queue.add(new Pair(nextr,nextc));
                    }
            }
        }
        return image;
    }
}
