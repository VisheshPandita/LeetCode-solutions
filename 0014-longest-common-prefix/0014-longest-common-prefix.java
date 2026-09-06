class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n < 1) return "";

        String common = strs[0];
        StringBuilder commonAns = new StringBuilder();

        for(int i=1; i<n; i++) {
            int ptr = 0;
            while(ptr<common.length() && ptr<strs[i].length()) {
                if(common.charAt(ptr) == strs[i].charAt(ptr)) {
                    commonAns.append(common.charAt(ptr));
                }else {
                    break;
                }
                ptr++;
            }
            common = commonAns.toString();
            commonAns.setLength(0);
        }

        return common;
    }
}