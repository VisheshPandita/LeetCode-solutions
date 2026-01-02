class Solution {
    public int countVowelPermutation(int n) {
        long MOD = 1_000_000_007;

        long a = 1, e = 1, i = 1, o = 1, u = 1;

        for (int k = 2; k <= n; k++) {

            // a comes from e, i, u
            long a_next = (e + i + u) % MOD;
            
            // e comes from a, i
            long e_next = (a + i) % MOD;
            
            // i comes from e, o
            long i_next = (e + o) % MOD;
            
            // o comes from i
            long o_next = i % MOD;
            
            // u comes from i, o
            long u_next = (i + o) % MOD;

            // Update current counts for the next iteration
            a = a_next;
            e = e_next;
            i = i_next;
            o = o_next;
            u = u_next;
        }

        // The answer is the sum of all ending possibilities
        long total = (a + e + i + o + u) % MOD;
        return (int) total;
    }
}