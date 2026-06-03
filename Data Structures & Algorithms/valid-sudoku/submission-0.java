class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> column = new HashSet<>();
        Set<Character> square = new HashSet<>();

        //iterate rows
        for(int r = 0; r < 9; r++){
            row.clear();
            for(int j = 0; j < 9; j++){
                if(board[r][j] == '.'){
                    continue;
                }
                if(row.contains(board[r][j])){
                    return false;
                }
                row.add(board[r][j]);
            }
        }

        //iterate columns
        for(int c = 0; c < 9; c++){
            column.clear();
            for(int j = 0; j < 9; j++){
                if(board[j][c] == '.'){
                    continue;
                }
                if(column.contains(board[j][c])){
                    return false;
                }
                column.add(board[j][c]);
            }
        }

        //iterate squares
        for(int sq = 0; sq < 9; sq++){
            square.clear();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int rows = (sq / 3) * 3 + i;
                    int cols = (sq % 3) * 3 + j;
                    if(board[rows][cols] == '.'){
                        continue;
                    }
                    if(square.contains(board[rows][cols])){
                        return false;
                    }
                    square.add(board[rows][cols]);
                }
            }
        }

        return true;
    }
}
