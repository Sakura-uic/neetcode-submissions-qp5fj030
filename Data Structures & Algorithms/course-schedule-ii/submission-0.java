class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int[]indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]e:prerequisites){
            int u=e[0];
            int v=e[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[]res=new int[numCourses];
        int idx=0;
    while(!q.isEmpty()){
        int node = q.poll();
        res[idx]=node;
        idx++;
        for(int neighbour:adj.get(node)){
            indegree[neighbour]--;
            if(indegree[neighbour]==0){
                q.offer(neighbour);
            }
        }
    }
    if(idx!=numCourses){
            return new int[0];
        }
        return res;
    }
}
