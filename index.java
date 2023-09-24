import java.util.*;
import java.io.*;

public class TicTakToe {
      static  HashSet<Integer> ur_set=new HashSet<>();
    static  HashSet<Integer> comp_set=new HashSet<>();

    public static void main(String args[]) {
        // Borad layout
        char[][] a_borad = {
                {' ', '|', '|', ' '},
                {'-', '|', '|', '-'},
                {' ', '|', '|', ' '},
                {'-', '|', '|', '-'},
                {' ', '|', '|', ' '},
        };
        print_borad(a_borad);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter values from 1-9:");
            int user_pos = in.nextInt();
            while (ur_set.contains(user_pos) || comp_set.contains(user_pos)) {
                System.out.println();
                System.out.println("Retry, Enter values from 1-9:");
                user_pos = in.nextInt();
            }
            p_holder(a_borad,user_pos,"You");
            String res=check_winner();
            if(res.length()>9){
                System.out.println(res);
                break;
            }

            int cpu_pos=gen_random();

            while (ur_set.contains(cpu_pos) || comp_set.contains(cpu_pos)) {

                cpu_pos =gen_random();

            }
            p_holder(a_borad,cpu_pos,"Comp");
           res=check_winner();
            if(res.length()>9){
                System.out.println(res);
                break;
            }
        }

        static String check_winner(){
            HashSet<Integer> r1=new HashSet<>();
            r1.add(1);r1.add(2);r1.add(3);
            HashSet<Integer> r2=new HashSet<>();
            r2.add(4);r2.add(5);r2.add(6);
            HashSet<Integer> r3=new HashSet<>();
            r3.add(7);r3.add(8);r3.add(9);

            HashSet<Integer> c1=new HashSet<>();
            c1.add(1);c1.add(4);c1.add(7);
            HashSet<Integer> c2=new HashSet<>();
            c2.add(2);c2.add(5);c2.add(8);
            HashSet<Integer> c3=new HashSet<>();
            c3.add(3);c3.add(6);c3.add(9);

            HashSet<Integer> d1=new HashSet<>();
            d1.add(1);d1.add(5);d1.add(9);
            HashSet<Integer> d2=new HashSet<>();
            d1.add(3);d1.add(5);d1.add(7);

            HashSet<Integer> set=new HashSet<HashSet>();
            set.add(r1);set.add(r2);set.add(r3);
            set.add(c1);set.add(c2);set.add(c3);
            set.add(d1);set.add(d2);

            for(HashSet c:set){
                if(ur_set.containsAll(c))
                    return "YOU WON";
                else if(comp_set.containsAll(c))
                    return "YOU LOST";
            }
            if(ur_set.size()+comp_set.size()==9){
                return "DRAW";

                return "";
            }

        }
        static int gen_random(){
            int max=9;
            int min=1;
            int range=max-min+1;
            int res=(int)(Math.random()*range)+min;
            return res;
        }
        public static void main (String args[]){
        }
    }

    static void print_borad(char[][] a_borad) {
        // for rows
        for (int i = 0; i < a_borad.length; i++) {
            // for column
            for (int j = 0; j < a_borad[0].length; j++) {
                System.out.print(a_borad[i][j]);
            }
            System.out.println();
        }

        //ADD THE 0 & x


        static void p_holder ( char[][] a_borad, int pos, String user){
            char syb = 'X';
            if (user.equals("You")) {
                syb = 'X';
                ur_set.add(pos);
            } else if (user.equals("comp")) {
                syb = '0';
                ur_comp.add(pos);
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
