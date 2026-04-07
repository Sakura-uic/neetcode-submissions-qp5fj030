class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rowL;
    static int colL;
    public int numIslands(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        int islands=0;
        boolean[][]visited=new boolean[rowL][colL];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i,j,visited,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int r,int c,boolean[][]visited,char[][]grid){
        if(r<0||r>=rowL||c<0||c>=colL||grid[r][c]=='0')return;
        if(visited[r][c]==true)return;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],visited,grid);
        }
    }
}
