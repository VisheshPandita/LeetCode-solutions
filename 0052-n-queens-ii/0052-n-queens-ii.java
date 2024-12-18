class Solution {
    public int totalNQueens(int n) {
        // Initialize sets to track conflicts
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();
        
        // Start backtracking
        return backtrack(0, n, columns, diagonals, antiDiagonals);
    }

    private int backtrack(int row, int n, Set<Integer> columns, 
                          Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        // Base case: All queens are placed
        if (row == n) {
            return 1;
        }

        int count = 0;

        // Try placing a queen in each column
        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;

            // Check if the position is under attack
            if (columns.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }

            // Place the queen
            columns.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);

            // Recurse for the next row
            count += backtrack(row + 1, n, columns, diagonals, antiDiagonals);

            // Backtrack: Remove the queen
            columns.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
        }

        return count;
    }
}