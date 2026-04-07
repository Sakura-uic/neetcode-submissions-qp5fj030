class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[]rank=new int[n+1];
        int[]parent=new int[n+1];
        int[]ans=new int[2];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            int p_x=find(edges[i][0],parent);
            int p_y=find(edges[i][1],parent);

            if(p_x==p_y){
                ans[0]=edges[i][0];
                ans[1]=edges[i][1];
                continue;
            }
            if(rank[p_x]>rank[p_y]){
                parent[p_y]=p_x;

            }
            else if(rank[p_x]<rank[p_y]){
                parent[p_x]=p_y;
            }
            else{
                parent[p_x]=p_y;
                rank[p_y]++;
            }
        }
        return ans;
    }
    public int find(int x,int[]parent){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x],parent);
    }
}
