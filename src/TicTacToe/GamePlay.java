package TicTacToe;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {
    char board[][] = new char[3][3];
    int position[] = new int[2];

    GamePlay(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }
    }

    void player(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        board[i][j] = 'O';
    }
    void ai(){
        AI a1 = new AI();
        position = a1.bestChoice(board);
        board[position[0]][position[1]] = 'X';

//        Random r = new Random();
//        while(true){
//            int i = r.nextInt(2);
//            int j = r.nextInt(2);
//            if(board[i][j] == ' ') {
//                board[i][j] = 'X';
//                System.out.println(i + j);
//                break;
//            }
//        }
    }
    int freeSpaces(){
        int n = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(board[i][j] == ' ') n++;
            }
        }
        return n;
    }
    public int isWinner(){
        int i;
        for(i=0; i<3; i++){

            if(board[i][0] != ' '){
                if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                    //System.out.println(i + " th row");
                    return 1;
                }
            }
            if(board[0][i] != ' '){
                if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                    //System.out.println(i + " th column");
                    return 1;
                }
            }
        }
        if(board[1][1] != ' '){
            if(board[0][0] == board[1][1] && board[1][1] == board[2][2] ) {
                //System.out.println("diagonal");
                return 1;
            }
            if(board[0][2] == board[1][1] && board[1][1] == board[2][0] ) return 1;

        }
        if(this.freeSpaces() == 0) return 0;
        return -1;
    }
    void printBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(board[i][j]  + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        GamePlay g = new GamePlay();
        int i = 0;
        do{
            i++;
            g.player();
            g.ai();
            g.printBoard();
        }while (g.isWinner() == -1);
        //g.printBoard();

    }
}
