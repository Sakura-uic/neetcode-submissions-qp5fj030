class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    int rowL;
    int colL;
    public int maxAreaOfIsland(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][]visited=new boolean[rowL][colL];
        int compo=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!visited[i][j] && grid[i][j]==1);
                int component=dfs(i,j,visited,grid);
                compo=Math.max(compo,component);
            }
        }
        return compo;
    }
    public int dfs(int r,int c,boolean[][]visited,int[][]grid){
        if(r<0||c<0||r>=rowL||c>=colL||grid[r][c]==0){
            return 0;
        }
        if(visited[r][c]==true){
            return 0;
        }
        visited[r][c]=true;
        int area=1;
        for(int i=0;i<4;i++){
            area=area+dfs(r+dr[i],c+dc[i],visited,grid);
        }
        return area;
    }
}
