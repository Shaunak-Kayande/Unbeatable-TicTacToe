package TicTacToe;

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

    void reset(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }
    }


    void ai(char a, char b, GUI play){
        AI a1 = new AI(a, b);
        position = a1.bestChoice(board);
        board[position[0]][position[1]] = b;
        String aiPlay = Character.toString(b);
        play.player(position[0], position[1], aiPlay);

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
    public char isWinner(){
        int i;
        for(i=0; i<3; i++){

            if(board[i][0] != ' '){
                if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                    return board[i][0];
                }
            }
            if(board[0][i] != ' '){
                if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                    return board[0][i];
                }
            }
        }
        if(board[1][1] != ' '){
            if(board[0][0] == board[1][1] && board[1][1] == board[2][2] ) return board[0][0];
            if(board[0][2] == board[1][1] && board[1][1] == board[2][0] ) return board[0][2];
        }
        if(this.freeSpaces() == 0) return 'D';

        return 'N';
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

        GUI play = new GUI();

    }
}
