package TicTacToe;

public class AI {
    public int[] bestChoice(char board[][]){
        int bestscore = -1;
        int bestchoice[] = new int[2];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(board[i][j] == ' '){
                    board[i][j] = 'X';
                    int s0 = minimax(board, -1);
                    board[i][j] = ' ';
                    if(s0 > bestscore){
                        bestscore = s0;
                        bestchoice = new int[]{i, j};
                    }
                }

            }
        }
        return bestchoice;
    }

    public int minimax(char board[][], int isMax){
        GamePlay gtemp = new GamePlay();
        gtemp.board = board;
        if(gtemp.isWinner() >= 0 ){
            return -1*isMax* gtemp.isWinner();
        }
        if(isMax == -1){
            int bestscore = 1;
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if(board[i][j] == ' '){
                        board[i][j] = 'O';
                        int s0 = minimax(board, 1);
                        board[i][j] = ' ';
                        if(s0 < bestscore){
                            bestscore = s0;
                        }
                    }
                }
            }
            return bestscore;
        }
        else if(isMax == 1){
            int bestscore = -1;
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if(board[i][j] == ' '){
                        board[i][j] = 'X';
                        int s0 = minimax(board, -1);
                        board[i][j] = ' ';
                        if(s0 > bestscore){
                            bestscore = s0;
                        }
                    }
                }
            }
            return bestscore;
        }
        return 0;
    }
}
