class Solution {
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int row;
    private int col;

    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0) return;

        row = board.length;
        col = board[0].length;
        
        for(int i=0;i<row;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][col-1]=='O') dfs(board,i,col-1);
        }
        for(int i=0;i<col;i++){
            if(board[0][i]=='O') dfs(board,0,i);
            if(board[row-1][i]=='O') dfs(board,row-1,i);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]!='Y') board[i][j]='X';
                else board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(
            i<0 ||
            i>=row ||
            j<0 ||
            j>=col ||
            board[i][j]!='O'
        ) return;

        board[i][j]='Y';

        for(int[] dir: dirs){
            dfs(board, i+dir[0], j+dir[1]);
        }
    }
}