class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites){
            int sE = edge[1];
            int eE = edge[0];
            indegree[eE]++;
            adj.get(sE).add(eE);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int idx =0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            result[idx++]=node;

            for(Integer nn : adj.get(node)){
                indegree[nn]--;
                if(indegree[nn] == 0){
                    queue.add(nn);
                }
            }
        }

        if(idx != numCourses){
            return false;
        }

        return true;
        
    }
}
