class Solution {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public int orangesRotting(int[][] grid) {

        int rowL = grid.length;
        int colL = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: scan grid
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){

                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int time = 0;

        // Step 2: BFS
        while(!q.isEmpty()){

            int size = q.size();
            boolean rotted = false;

            for(int s=0; s<size; s++){

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int k=0;k<4;k++){

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if(nr>=0 && nr<rowL && nc>=0 && nc<colL
                       && grid[nr][nc] == 1){

                        grid[nr][nc] = 2;
                        fresh--;
                        rotted = true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }

            if(rotted) time++;
        }

        return fresh == 0 ? time : -1;
    }
}
