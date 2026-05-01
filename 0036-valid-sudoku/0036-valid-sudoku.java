class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 grids, 9 rows, 9 columns
        int[][] grids = new int[3][3];
        int[] rows = new int[9];
        int[] columns = new int[9];

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] != '.') {
                    // need to check if still valid
                    int num = Integer.parseInt(String.valueOf(board[y][x]));
                    int bitRepresentation = 1 << (num - 1);
                    
                    if ((grids[y/3][x/3] & bitRepresentation) != 0 || (rows[y] & bitRepresentation) != 0 || (columns[x] & bitRepresentation) != 0) {
                        // already got the number in a grid, row or column
                        return false;
                    } else {
                        // need to store
                        grids[y/3][x/3] += bitRepresentation;
                        rows[y] += bitRepresentation;
                        columns[x] += bitRepresentation;
                    }
                }
            }
        }

        return true;
    }
}