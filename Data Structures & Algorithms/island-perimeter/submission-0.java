class Solution {
    static int[]dr={-1,1,0,0,};
    static int[]dc={0,0,-1,1};
    static int rowL;
    static int colL;
    public int islandPerimeter(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][]visited=new boolean[rowL][colL];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    return dfs(i,j,visited,grid);
                }
            }
        }
        return -1;
    }
    public int dfs(int r,int c,boolean[][]visited,int[][]grid){
        if(r<0||c<0||r>=rowL||c>=colL||grid[r][c]==0)return 1;//boundary condition it will add to the perimeter later
        if(visited[r][c]==true)return 0;//already processed node
        visited[r][c]=true;
        int peri=0;
        for(int k=0;k<4;k++){
            peri=peri+dfs(r+dr[k],c+dc[k],visited,grid);
        }
        return peri;
    }
}