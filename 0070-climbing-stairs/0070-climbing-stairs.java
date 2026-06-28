class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;

        int prevStep = 2;
        int prevPrevStep = 1;
        int current = 0;

        for(int i=3; i<=n; i++) {
            current = prevStep + prevPrevStep;
            prevPrevStep = prevStep;
            prevStep = current;
        }

        return current;
    }
}