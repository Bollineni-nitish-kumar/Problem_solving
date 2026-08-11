class Solution {
    public boolean exist(char[][] board, String word) {
        int rl = board.length;
        int cl = board[0].length;
        boolean[][] visited = new boolean[rl][cl];

        for(int i =0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(board[i][j] !=word.charAt(0)){
                    continue;
                }else{
                    if(backTrack(board,word,i,j,0,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    private boolean backTrack(char[][] board,String word, int r,int c, int ind,boolean[][] visited) {
        if(r < 0 || r>=board.length || c <0 || c>=board[0].length || ind >=word.length()){
              return false;
        }
        if(visited[r][c] || (board[r][c] != word.charAt(ind))){
            return false;
        }
        visited[r][c] = true;
        
        if(ind == word.length()-1 && board[r][c] == word.charAt(ind)){
            return true;
        }

        boolean found =  backTrack(board,word,r-1,c,ind+1,visited) ||
                         backTrack(board,word,r+1,c,ind+1,visited) ||
                         backTrack(board,word,r,c+1,ind+1,visited) ||
                         backTrack(board,word,r,c-1,ind+1,visited);

        visited[r][c] = false;

        return found;
                   
    }


}
