class WordDictionary {
    private class TrieNode{
        TrieNode[] children = new TrieNode[128];
        boolean isEnd = false;
    }

    private TrieNode root = null;
    public WordDictionary() {
         root = new TrieNode();
    }

    public void addWord(String word) {
         TrieNode curr = root;
         for(char ch : word.toCharArray()){
            int ind = ch;
            if(curr.children[ind] == null){
                curr.children[ind] = new TrieNode();
            }
            curr = curr.children[ind];
         }
         curr.isEnd = true;
    }

    public boolean search(String word) {
        return searchNode(word,0,root);
    }

    public boolean searchNode(String word,int ind,TrieNode node){
        if(node == null){
            return false;
        }

        if(ind == word.length()){
            return node.isEnd;
        }

        char ch = word.charAt(ind);

        if(ch == '.'){
            for(TrieNode child : node.children){
                if(child!=null && searchNode(word,ind+1,child)){
                    return true;
                }
            }
            return false;
        }else{
            return searchNode(word,ind+1,node.children[ch]);
        }
    }
}
