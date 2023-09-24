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

          //ADD THE 0 & x


          static void p_holder ( char[][] a_borad, int pos, String user){
            char syb = 'X';
            if (user.equals("You")) {
                syb = 'X';
            } else if (user.equals("comp")) {
                syb = '0';
            }
            switch (pos) {
                case 1:
                    a_borad[0][0] = syb;
                    break;
                case 2:
                    a_borad[0][2] = syb;
                    break;

                case 3:
                    a_borad[0][4] = syb;
                    break;

                case 4:
                    a_borad[2][0] = syb;
                    break;

                case 5:
                    a_borad[2][0] = syb;
                    break;
                case 6:
                    a_borad[2][2] = syb;
                    break;

                case 7:
                    a_borad[2][4] = syb;
                    break;

                case 8:
                    a_borad[4][0] = syb;
                    break;

                case 9:
                    a_borad[4][4] = syb;
                    break;

                default:
                    System.out.println("Invalid Input");
            }
            print_borad(a_borad);
        }


    }
}