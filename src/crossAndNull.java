import java.util.Scanner;

public class crossAndNull {

       public static void main(String[] args) {
        System.out.print("Игра");
        System.out.println("Крестики-Нолики");

           System.out.println("Играет компьютер");
        char  field [][]= {{' ' ,' ' ,' ' },{' ' ,' ' ,' ' },{' ' ,' ' ,' ' }};
        int result;
        char symbol='X';

        showfield(field);
        do{
            randomInput(field,symbol);

            symbol  =symbol=='X' ? 'O':'X';

            showfield(field);
            checkRezalt(field);
            result=checkRezalt(field);
        } while (result==0);

        switch (checkRezalt(field)){
            case 1:System.out.println("win X");
                break;
            case 2:System.out.println("win O");
                break;
            case 3: System.out.println("Ничья");
                break;
        }
    }

    public static void showfield(char field[][]) {                          // рисует поле
        System.out.println(field[0][0]+"|"+field[0][1]+"|"+field[0][2]);
        System.out.println("-----");
        System.out.println(field[1][0]+"|"+field[1][1]+"|"+field[1][2]);
        System.out.println("-----");
        System.out.println(field[2][0]+"|"+field[2][1]+"|"+field[2][2]);
    }



   public static void randomInput(char[][] field, char symbol) { //выбираем клетку длясимвола
        int n = 0, m=0, number = 0;
        // (n-1)%3- столбец // 2-(n-1)/3 строка
        do {
            number =(int)(Math.random()*10);
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while  (number<1 || number>9 || field[n][m] !=' ');
        field[n][m] = symbol;
    }


    public static int checkRezalt (char field[][] ) {
        /*
        0 - продолжаем
        2 - вин О
        1- вин Х
         */
        for (int i = 0; i < field.length; i++){

            if (field[i][0] ==field[i][1] && field[i][1] ==field[i][2] ){

                if (field[i][0]=='X'){
                    return 1;
                }
                if (field[i][0]=='O'){
                    return 2;
                }
            }
            if (field[0][i] ==field[1][i] && field[1][i] ==field[2][i] ){

                if (field[0][i]=='X'){
                    return 1;
                }
                if (field[0][i]=='O'){
                    return 2;
                }
            }
            if (field[0][0] ==field[1][1] && field[1][1] ==field[2][2] ){

                if (field[0][0]=='X'){
                    return 1;
                }
                if (field[0][0]=='O'){
                    return 2;
                }
            }

            if (field[0][2] ==field[1][1] && field[1][1] ==field[2][0] ){

                if (field[0][2]=='X'){
                    return 1;
                }
                if (field[0][2]=='O'){
                    return 2;
                }
            }

        }

        for (int i=0; i<field.length; i++){
            for (int j=0; j<field[i].length; j++){
                if (field[i][j]==' ')
                    return 0;
            }
        }

        return 3;
    }
}
