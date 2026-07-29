class Solution {
    public int largestInteger(int n, int s) {
        if((9*n)<s) return -1;

        int ans = 0;
        while(s>0) {
            if(s>=9){
                int temp = 9;
                temp = temp *(int) Math.pow(10, n-1);
                ans += temp;
                n--;
                s -= 9;
            }else {
                int temp = s;
                temp = temp *(int) Math.pow(10, n-1);
                ans += temp;
                s = 0;
            }
        }

        return ans;
    }
}