class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rowL;
    static int colL;
    public void islandsAndTreasure(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==0 ){
                q.offer(new int[]{i,j});
            }
            }
        }
        while(!q.isEmpty()){
        int[]curr=q.poll();
        int r=curr[0];
        int c=curr[1];
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<rowL && nc>=0 && nc<colL && grid[nr][nc]==2147483647){
                grid[nr][nc]=grid[r][c]+1;
                q.offer(new int[]{nr,nc});
            }
        }
    }
    }
}
