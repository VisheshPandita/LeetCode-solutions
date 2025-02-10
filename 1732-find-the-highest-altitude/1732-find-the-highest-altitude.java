class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int current=0;
        for(int altitude: gain){
            current+=altitude;
            ans = Math.max(ans, current);
        }

        return ans;
    }
}