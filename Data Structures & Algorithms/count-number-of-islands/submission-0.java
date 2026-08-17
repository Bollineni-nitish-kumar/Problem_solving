class Solution {
    public int numIslands(char[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        boolean[][] visited = new boolean[rl][cl];
        int count = 0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    traverseIsland(grid,i,j,visited);
                    count=count+1;
                }
            }
        }

        return count;
        
    }

    private void traverseIsland(char[][] grid, int row, int col,boolean[][] visited){
        if(row < 0 || row >= grid.length || col <0 || col >= grid[0].length){
            return;
        }

        if(visited[row][col] == true || grid[row][col] == '0'){
            return;
        }

        visited[row][col] = true;
        traverseIsland(grid,row+1,col,visited);
        traverseIsland(grid,row-1,col,visited);
        traverseIsland(grid,row,col+1,visited);
        traverseIsland(grid,row,col-1,visited);

        return;


    }
}
