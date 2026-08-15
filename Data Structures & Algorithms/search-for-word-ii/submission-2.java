class Solution {
    public class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String isWord = null;       
    }

    private TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(root,words);
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        for(int i=0;i < board.length;i++){
            for(int j=0;j<board[0].length;j++){
                findValidWords(board,i,j,visited,root,result);
            }
        }
        return result;
    }

    private void findValidWords(char[][] board, int start, int end, boolean[][] visited,TrieNode root,List<String> result){
        
        if(start <0 || start >= board.length || end <0 || end >=board[0].length){
           return;
        }

        char ch = board[start][end];
        if(visited[start][end] || root.children[ch-'a']==null){
            return;
        }
        TrieNode child = root.children[ch-'a'];
        
        if(child.isWord!=null){
            result.add(child.isWord);
            child.isWord = null;
        }

        visited[start][end] =true;

        findValidWords(board,start+1,end,visited,child, result);
        findValidWords(board,start-1,end,visited,child, result);
        findValidWords(board,start,end+1,visited,child, result);
        findValidWords(board,start,end-1,visited,child,result);

        visited[start][end] = false;
    }

    private void buildTrie(TrieNode root,String[] words){
        for(String word : words){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                int ind = ch-'a';
                if(curr.children[ind] == null ){
                    curr.children[ind] = new TrieNode();
                }
                curr = curr.children[ind];
            }
            curr.isWord= word;
        }
    }
}
