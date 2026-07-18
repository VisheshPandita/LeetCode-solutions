class Solution {
    public int minimumMoves(int[][] grid) {
        List<int[]> surplus = new ArrayList<>();   // stones that need to leave
        List<int[]> deficit = new ArrayList<>();   // holes that need filling

        // ---- Build the two lists ----
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[r][c] > 1) {
                    // cell keeps 1 stone, donates (count - 1)
                    // so add it once per EXTRA stone
                    for (int k = 1; k < grid[r][c]; k++) {
                        surplus.add(new int[]{r, c});
                    }
                } else if (grid[r][c] == 0) {
                    deficit.add(new int[]{r, c});
                }
            }
        }

        // surplus.size() == deficit.size() always (total stones == 9 == cells)
        return backtrack(surplus, deficit, 0, new boolean[surplus.size()]);
    }

    /**
     * Fill hole `i`, then all holes after it, as cheaply as possible.
     * used[j] == true means stone j is already assigned to an earlier hole.
     */
    private int backtrack(List<int[]> surplus, List<int[]> deficit,
                          int i, boolean[] used) {

        // Base case: no holes left to fill -> nothing more to pay
        if (i == deficit.size()) return 0;

        int best = Integer.MAX_VALUE;

        for (int j = 0; j < surplus.size(); j++) {
            if (used[j]) continue;              // stone j is taken, skip it

            used[j] = true;                     // put stone j into hole i

            int cost = dist(surplus.get(j), deficit.get(i))    // this pairing
                     + backtrack(surplus, deficit, i + 1, used); // best for the rest

            best = Math.min(best, cost);

            used[j] = false;                    // UNDO, so next j can try hole i
        }

        return best;
    }

    // Manhattan distance: steps to walk from a to b
    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}