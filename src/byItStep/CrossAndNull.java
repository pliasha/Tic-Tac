package byItStep;

import java.util.Scanner;

/**
 * Created by st on 10.01.2018.
 */
public class CrossAndNull {



    public static void main(String[] args) {
        System.out.print("Игра");
        System.out.println("Крестики-Нолики");
        System.out.println("Для ввода Х или О используете боковую клавиатуру");
        char  field [][]= {{' ' ,' ' ,' ' },{' ' ,' ' ,' ' },{' ' ,' ' ,' ' }};
        int result;
        char symbol='X';
        showfield(field);
        do{

            inputXO(field,symbol);
            symbol  =symbol=='X' ? 'O':'X';
            chekRandomIn(field, symbol);
            symbol = symbol == 'X' ? 'O' : 'X';
            showfield(field);
            result=checkRezalt(field);
            checkRezalt(field);

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

    public static void inputXO(char[][] field, char symbol) { //выбираем клетку длясимвола
        Scanner scanner=new Scanner(System.in);
        int n, m, number;
        // (n-1)%3- столбец // 2-(n-1)/3 строка
        System.out.println("Ход "+symbol);
         do {
           number = scanner.nextInt();
           n = 2 - (number - 1) / 3;
           m = (number - 1) % 3;
         } while  (number<1 || number>9 || field[n][m] !=' ');
        field[n][m] = symbol;
        }


    public static void randomInput(char[][] field, char symbol) { //
        int n = 0, m = 0, number = 0;
        // (n-1)%3- столбец // 2-(n-1)/3 строка
        do {
            number = (int) (Math.random() * 10);
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while (number < 1 || number > 9 || field[n][m] != ' ');
        field[n][m] = symbol;
    }

    public static void input(char[][] field, char symbol, int i, int j) {
        field[i][j] = symbol;

    }

    public static void  chekRandomIn(char field[][], char symbol) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == symbol)




                {
                    randomInput(field, symbol);
                   }

            }
        } /*     else;
            if (field[i][0] == 'O' && field[i][1] == 'O' || field[i][0] == 'O' && field[i][2] == 'O' || field[i][1] == 'O' && field[i][2] == 'O') {
                {
                    if (field[i][0] == ' ') {
                        input(field, symbol, i, 0);
                    } else if (field[i][1] == ' ') {
                        input(field, symbol, i, 1);
                    } else if (field[i][2] == ' ') {
                        input(field, symbol, i, 2);
                    }
                    break;
                }
            }
           else ;
            // проверка 2=х Х в столбце
            if (field[0][i] == 'O' && field[1][i] == 'O' || field[0][i] == 'O' && field[2][i] == 'O' || field[1][i] == 'O' && field[2][i] == 'O') {
                if (field[0][i] == ' ') {
                    field[0][i] = symbol;
                    break;
                }
                if (field[1][i] == ' ') {
                    field[1][i] = symbol;
                    break;
                }
                if (field[2][i] == ' ') {
                    field[2][i] = symbol;
                    break;
                }
            } else;
            if (field[i][0] == 'X' && field[i][1] == 'X' || field[i][0] == 'X' && field[i][2] == 'X' || field[i][1] == 'X' && field[i][2] == 'X') {
                {
                    if (field[i][0] == ' ') {
                        input(field, symbol, i, 0);
                    } else if (field[i][1] == ' ') {
                        input(field, symbol, i, 1);
                    } else if (field[i][2] == ' ') {
                        input(field, symbol, i, 2);
                    }
                    break;
                }
            } else ;
            // проверка 2=х Х в столбце
            if (field[0][i] == 'X' && field[1][i] == 'X' || field[0][i] == 'X' && field[2][i] == 'X' || field[1][i] == 'X' && field[2][i] == 'X') {
                if (field[0][i] == ' ') {
                    field[0][i] = symbol;
                    break;
                }
                if (field[1][i] == ' ') {
                    field[1][i] = symbol;
                    break;
                }
                if (field[2][i] == ' ') {
                    field[2][i] = symbol;
                    break;
                }
            }

        }*/

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
