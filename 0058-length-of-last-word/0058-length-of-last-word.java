class Solution {
    public int lengthOfLastWord(String s) {
        int ptr = s.length()-1;
        int ans=0;

        while(s.charAt(ptr) == ' ') ptr--;

        while(ptr>=0 && s.charAt(ptr)!=' ') {
            ans++;
            ptr--;
        }

        return ans;
    }
}