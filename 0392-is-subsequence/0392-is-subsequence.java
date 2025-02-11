class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length()==0 && s.length()==0) return true;
        if(s==null || s.length()==0) return true;
        if(t.length()==0) return false;
        int ptr=0;
        for(char c: t.toCharArray()){
            if(c == s.charAt(ptr)){
                ptr++;
            }
        }

        return ptr == s.length();
    }
}