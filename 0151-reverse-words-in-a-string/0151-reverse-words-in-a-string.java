class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while(i>=0) {
            while(i>=0 && s.charAt(i)==' ') {
                i--;
            }

            if(i<0) {
                break;
            }

            int right = i;

            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }

            if (sb.length() > 0) {
                sb.append(' ');
            }

            sb.append(s, i + 1, right + 1);
        }

        return sb.toString();
    }
}