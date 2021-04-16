package TicTacToe;

public class AI {
    char aiPlay, humanPlay;
    AI(char a, char b){
        humanPlay = a;
        aiPlay = b;
    }
    public int[] bestChoice(char board[][]){
        int bestscore = -1;
        int bestchoice[] = new int[2];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(board[i][j] == ' '){
                    board[i][j] = aiPlay;
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

        if(gtemp.isWinner() != 'N' ){
            if(gtemp.isWinner() == 'D') return 0;
            else return -1*isMax;
        }

        if(isMax == -1){
            int bestscore = 1;
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if(board[i][j] == ' '){
                        board[i][j] = humanPlay;
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
                        board[i][j] = aiPlay;
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
