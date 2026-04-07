class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rowl;
    static int coll;
    public void solve(char[][] board) {
        rowl=board.length;
        coll=board[0].length;
        boolean[][]visited=new boolean[rowl][coll];
        //check boundaries
        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if((i==0 || j==0 || i==rowl-1 || j==coll-1)&&board[i][j]=='O'){
                    dfs(i,j,visited,board);
                }
            }
        }
        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int r,int c,boolean[][]visited,char[][]board){
        if(r<0||c<0||r>=rowl||c>=coll||board[r][c]!='O')return;
        if(visited[r][c]==true)return;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],visited,board);
        }
    }
}
