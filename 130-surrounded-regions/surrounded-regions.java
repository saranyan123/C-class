class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        // 1. Mark 'O's on the boundary and their connected regions as 'S' (Safe)
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);       // Left boundary
            dfs(board, i, n - 1);   // Right boundary
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);       // Top boundary
            dfs(board, m - 1, j);   // Bottom boundary
        }

        // 2. Process the board: 
        // Remaining 'O's are surrounded -> 'X'
        // 'S's are safe -> 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        
        board[r][c] = 'S'; // Temporary marker for safe 'O'
        
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
