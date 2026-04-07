class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rowL;
    static int colL;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rowL=heights.length;
        colL=heights[0].length;

        boolean[][]pacific=new boolean[rowL][colL];
        boolean[][]atlantic=new boolean[rowL][colL];

         for(int c=0;c<colL;c++){
            dfs(0,c,pacific,heights);
            dfs(rowL-1,c,atlantic,heights);
         }
         for(int r=0;r<rowL;r++){
            dfs(r,0,pacific,heights);
            dfs(r,colL-1,atlantic,heights);
         }
         List<List<Integer>>res=new ArrayList<>();
         for(int r=0;r<rowL;r++){
            for(int c=0;c<colL;c++){
                if(pacific[r][c]&&atlantic[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
         }
         return res;
    }
    public void dfs(int r,int c,boolean[][]ocean,int[][]heights){
        ocean[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<rowL && nc<colL && !ocean[nr][nc] && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,ocean,heights);
            }
        }
    }
}
