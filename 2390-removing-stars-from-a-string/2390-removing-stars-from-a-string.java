class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c != '*') stack.push(c);
            else stack.pop();
        }

        int n = stack.size();
        char[] result = new char[n];
        for(int i=0;i<n;i++){
            result[n-i-1] = stack.pop();
        }

        return new String(result);
    }
}