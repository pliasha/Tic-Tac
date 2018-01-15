package byItStep;

import java.util.Scanner;

/**
 * Created by st on 10.01.2018.
 */
public class CrossAndNull {

    public static final int WIN_1 = 1;
    public static final int WIN_2 = 2;
    public static final int DRAW= 3;
    public static final int CONTINUE= 0;
    
    public static final char PLAYER_1='X';
    public static final char PLAYER_2='O';
    public static final char EMPTY=' ';
    
    public static void main(String[] args) {
        System.out.print("Игра");
        System.out.println("Крестики-Нолики");
        System.out.println("Для ввода Х или О используете боковую клавиатуру");
        char  field [][]= {{EMPTY ,EMPTY ,EMPTY },{EMPTY ,EMPTY ,EMPTY },{EMPTY ,EMPTY ,EMPTY }};
        int result;
        char symbol=PLAYER_1;
        showfield(field);
        do{

            inputXO(field,symbol);
            symbol  =symbol==PLAYER_1 ? PLAYER_2:PLAYER_1;
            chekRandomIn(field, symbol);
            symbol = symbol == PLAYER_1 ? PLAYER_2 : PLAYER_1;
            showfield(field);
            result=checkRezalt(field);
            checkRezalt(field);

        } while (result==CONTINUE);

        switch (checkRezalt(field)){
            case WIN_1:System.out.println("win "+ PLAYER_1);
                break;
            case WIN_2:System.out.println("win "+PLAYER_2);
                break;
            case DRAW: System.out.println("Ничья");
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
         } while  (number<1 || number>9 || field[n][m] !=EMPTY);
        field[n][m] = symbol;
        }


    public static void randomInput(char[][] field, char symbol) { //
        int n = 0, m = 0, number = 0;
        // (n-1)%3- столбец // 2-(n-1)/3 строка
        do {
            number = (int) (Math.random() * 10);
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while (number < 1 || number > 9 || field[n][m] != EMPTY);
        field[n][m] = symbol;
    }

    public static void input(char[][] field, char symbol, int i, int j) {
        field[i][j] = symbol;

    }

    public static void  chekRandomIn(char field[][], char symbol) {
int lin=0, col=0, ii=0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == symbol) {
                    ii++;
                }
            }
        }
        if(ii==0){
            randomInput(field,symbol);}
        else

        for (int i = 0; i < field.length; i++) {
            if (field[1][1] == PLAYER_1 && field [2][0]==PLAYER_1 ) {

                if (field[0][2] == EMPTY) {
                    field[0][2] = symbol;
                    break;
                } else
                if (field[2][1] == EMPTY) {
                    field[2][1] = symbol;
                    break;
                }

                if (field[0][1] == EMPTY) {
                    field[0][1] = symbol;
                    break;
                }
                if (field[0][2] == EMPTY) {
                    field[0][2] = symbol;
                    break;
                }
            } else


            if (field[i][0] == PLAYER_1 && field[i][1] == PLAYER_1 || field[i][0] == PLAYER_1 && field[i][2] == PLAYER_1 || field[i][1] == PLAYER_1 && field[i][2] == PLAYER_1) {

                if (field[i][0] == EMPTY) {
                    field[i][0] = symbol;
                    break;
                }
                if (field[i][1] == EMPTY) {
                    field[i][1] = symbol;
                    break;
                }
                if (field[i][2] == EMPTY) {
                    field[i][2] = symbol;
                    break;
                }
            } else


            if (field[0][i] == PLAYER_1 && field[1][i] == PLAYER_1 || field[0][i] == PLAYER_1 && field[2][i] == PLAYER_1 || field[1][i] == PLAYER_1 && field[2][i] == PLAYER_1) {

                if (field[0][i] == EMPTY) {
                    field[0][i] = symbol;
                    break;
                }
                if (field[1][i] == EMPTY) {
                    field[1][i] = symbol;
                    break;
                }
                if (field[2][i] == EMPTY) {
                    field[2][i] = symbol;
                    break;
                }
            }
        }


        /*     else;
            if (field[i][0] == PLAYER_2 && field[i][1] == PLAYER_2 || field[i][0] == PLAYER_2 && field[i][2] == PLAYER_2 || field[i][1] == PLAYER_2 && field[i][2] == PLAYER_2) {
                {
                    if (field[i][0] == EMPTY) {
                        input(field, symbol, i, 0);
                    } else if (field[i][1] == EMPTY) {
                        input(field, symbol, i, 1);
                    } else if (field[i][2] == EMPTY) {
                        input(field, symbol, i, 2);
                    }
                    break;
                }
            }
           else ;
            // проверка 2=х Х в столбце
            if (field[0][i] == PLAYER_2 && field[1][i] == PLAYER_2 || field[0][i] == PLAYER_2 && field[2][i] == PLAYER_2 || field[1][i] == PLAYER_2 && field[2][i] == PLAYER_2) {
                if (field[0][i] == EMPTY) {
                    field[0][i] = symbol;
                    break;
                }
                if (field[1][i] == EMPTY) {
                    field[1][i] = symbol;
                    break;
                }
                if (field[2][i] == EMPTY) {
                    field[2][i] = symbol;
                    break;
                }
            } else;
            if (field[i][0] == PLAYER_1 && field[i][1] == PLAYER_1 || field[i][0] == PLAYER_1 && field[i][2] == PLAYER_1 || field[i][1] == PLAYER_1 && field[i][2] == PLAYER_1) {
                {
                    if (field[i][0] == EMPTY) {
                        input(field, symbol, i, 0);
                    } else if (field[i][1] == EMPTY) {
                        input(field, symbol, i, 1);
                    } else if (field[i][2] == EMPTY) {
                        input(field, symbol, i, 2);
                    }
                    break;
                }
            } else ;
            // проверка 2=х Х в столбце
            if (field[0][i] == PLAYER_1 && field[1][i] == PLAYER_1 || field[0][i] == PLAYER_1 && field[2][i] == PLAYER_1 || field[1][i] == PLAYER_1 && field[2][i] == PLAYER_1) {
                if (field[0][i] == EMPTY) {
                    field[0][i] = symbol;
                    break;
                }
                if (field[1][i] == EMPTY) {
                    field[1][i] = symbol;
                    break;
                }
                if (field[2][i] == EMPTY) {
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

                if (field[i][0]==PLAYER_1){
                   return WIN_1;
                }
                    if (field[i][0]==PLAYER_2){
                        return WIN_2;
                    }
                }
            if (field[0][i] ==field[1][i] && field[1][i] ==field[2][i] ){

                if (field[0][i]==PLAYER_1){
                    return WIN_1;
                }
                if (field[0][i]==PLAYER_2){
                    return WIN_2;
                }
            }
            if (field[0][0] ==field[1][1] && field[1][1] ==field[2][2] ){

                if (field[0][0]==PLAYER_1){
                    return WIN_1;
                }
                if (field[0][0]==PLAYER_2){
                    return WIN_2;
                }
            }

            if (field[0][2] ==field[1][1] && field[1][1] ==field[2][0] ){

                if (field[0][2]==PLAYER_1){
                    return WIN_1;
                }
                if (field[0][2]==PLAYER_2){
                    return WIN_2;
                }
            }

        }

        for (int i=0; i<field.length; i++){
            for (int j=0; j<field[i].length; j++){
                if (field[i][j]==EMPTY)
                  return CONTINUE;
                }
            }

return DRAW;
    }





}
