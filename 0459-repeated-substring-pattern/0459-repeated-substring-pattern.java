class Solution {
    public boolean repeatedSubstringPattern(String s) {
       String modified = s + s;
        // Remove the first and last characters of modified
        modified = modified.substring(1, modified.length() - 1);
        // Check if the original string exists in the modified string
        return modified.contains(s);
    }
}