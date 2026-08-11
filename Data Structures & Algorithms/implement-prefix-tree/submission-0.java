class PrefixTree {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = null;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
         TrieNode curr= root;
         for(char ch : word.toCharArray()){
            int ind = ch-'a';
            if(curr.children[ind] == null){
                curr.children[ind] = new TrieNode();
            }
            curr=curr.children[ind];
         }
         curr.isEnd = true;
    }

    public boolean search(String word) {
          TrieNode curr = found(word);
          if(curr != null && curr.isEnd){
            return true;
          }
          return false;
    }

    public TrieNode found(String word) {
         TrieNode curr= root;
         for(char ch : word.toCharArray()){
            int ind = ch-'a';
            if(curr.children[ind] == null){
                return null;
            }
            curr=curr.children[ind];
         }
         
         return curr;
    }

    public boolean startsWith(String prefix) {
        TrieNode f = found(prefix);
        return f!=null;

    }
}
