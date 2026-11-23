class Solution {
    public int countSubstrings(String s) {
        int len = s.length();

        Boolean[][] isPalindromes = new Boolean[len][len];
        int totalPalindromes=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(s,i,j,isPalindromes)){
                    totalPalindromes++;
                }
            }
        }
        return totalPalindromes;
        
    }

    private boolean isPalindrome(String s,int start,int end,Boolean[][] isPalindromes){
        if(start >= end){
            return true;
        }
        if(isPalindromes[start][end]!=null){
            return isPalindromes[start][end];
        }
        
        if(s.charAt(start)!=s.charAt(end)){
            return isPalindromes[start][end]=false;
        }

        return isPalindromes[start][end]=isPalindrome(s,start+1,end-1,isPalindromes);
    }
}
