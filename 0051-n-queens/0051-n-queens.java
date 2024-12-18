class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();

        backtrack(0, n, board, columns, diagonals, antiDiagonals, solutions);
        return solutions;
    }

    private void backtrack(
        int row,
        int n,
        char[][] board, 
        Set<Integer> columns, 
        Set<Integer> diagonals, 
        Set<Integer> antiDiagonals, 
        List<List<String>> solutions
    ) {
        if(row==n) {
            solutions.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;

            // Check if the current column or diagonals are attacked
            if (columns.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }

            // Place the queen
            board[row][col] = 'Q';
            columns.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);

            // Recurse for the next row
            backtrack(row + 1, n, board, columns, diagonals, antiDiagonals, solutions);

            // Backtrack: Remove the queen
            board[row][col] = '.';
            columns.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}