class index{
    public static void main(String args[]){
        // Board layout
        char [][] a_board={
                {' ','|','|',' '},
                {'-','|','|','-'},
                {' ','|','|',' '},
                {'-','|','|','-'},
                {' ','|','|',' '},
        };
        print_board(a_board);
    }
    static void print_board(char[][]a_borad){
        // for rows
        for(int i=0; i<a_board.length;i++){
            // for column
            for(int j=0;j<a_board[0].length;j++){
                System.out.print(a_borad[i][j]);
            }
            System.out.println();
        }

    }
}