class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for(int i = 0;i<s.length();i++){
            int l1=expandAroundCenter(s,i,i);
            int l2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(l1,l2);

           if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);

        
    }

    private int expandAroundCenter(String s,int start,int end){
        while(start >=0 && end < s.length() && s.charAt(start)== s.charAt(end)){
            start--;
            end++;
        }

        return end-start-1;
    }
}
