package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JButton button[][] = new JButton[3][3];
    JButton rbutton;
    JRadioButton xbutton, obutton;
    JLabel won;
    public String humanPlay, aiPlay;
    GamePlay game = new GamePlay();

    GUI(){

        setBoard();
        setRbutton();
        setXnO();

        won = new JLabel();
        won.setBounds(80, 390, 150, 50);
        won.setFont(new Font("Comic Sans", Font.BOLD, 20));
        won.setVisible(false);
        this.add(won);

        ImageIcon logo = new ImageIcon("logo.png");
        this.setTitle("Unbeatable Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.setVisible(true);

    }

    void setBoard(){
        int a,b;
        for (int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                a = i*100;
                b = j*100;
                button[i][j] = new JButton();
                button[i][j].setBounds( a+80, b+80, 100, 100);
                button[i][j].addActionListener(this);
                button[i][j].setFont(new Font("Comic Sans", Font.BOLD, 40));
                button[i][j].setBackground(Color.BLACK);
                button[i][j].setForeground(Color.red);
                button[i][j].setEnabled(false);
                this.add(button[i][j]);
            }
        }
    }

    void setRbutton(){
        ImageIcon icon = createImageIcon();

        rbutton = new JButton();
        rbutton.setBounds( 320, 15, 50, 50);
        rbutton.addActionListener(this);
        rbutton.setIcon(icon);
        rbutton.setVerticalAlignment(JButton.CENTER);
        rbutton.setHorizontalAlignment(JButton.HORIZONTAL);
        this.add(rbutton);

    }

    void setXnO(){
        xbutton = new JRadioButton("X");
        xbutton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        xbutton.setBounds(80, 0, 50, 80);

        obutton = new JRadioButton("O");
        obutton.setFont(new Font("Comic Sans", Font.BOLD, 27));
        obutton.setBounds(160, 0, 50, 80);

        JLabel label = new JLabel();
        label.setText("Select:");
        label.setFont(new Font("Comic Sans", Font.BOLD, 20));
        label.setBounds(10, 0, 80, 80);

        ButtonGroup bg = new ButtonGroup();
        bg.add(xbutton);
        bg.add(obutton);

        this.add(xbutton);
        this.add(obutton);
        this.add(label);
        xbutton.addActionListener(this);
        obutton.addActionListener(this);
    }

    ImageIcon createImageIcon(){
        ImageIcon icon = new ImageIcon("reset.png");
        Image img = icon.getImage();
        Image modimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(modimg);
        return icon;
    }

    void disableRemainingButtons(){
        for (int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                button[i][j].setEnabled(false);
            }
        }
    }
    void player(int i, int j, String play){
        button[i][j].setText(play);
        button[i][j].setEnabled(false);

        if(play == humanPlay) {
            game.board[i][j] = humanPlay.charAt(0);
            game.ai(humanPlay.charAt(0), aiPlay.charAt(0), this);
        }
        char winner = game.isWinner();
        if(winner != 'N' ) {
            disableRemainingButtons();

            won.setVisible(true);
            if(winner == aiPlay.charAt(0)) won.setText("PC won!!");
            if(winner == humanPlay.charAt(0)) won.setText("Player won!!");
            if(winner == 'D') won.setText("Game Draw");
        }
    }

    void resetButton(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                game.board[i][j] = ' ';
                button[i][j].setText("");
                button[i][j].setEnabled(true);
            }
        }
        xbutton.setEnabled(true);
        obutton.setEnabled(true);
        won.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == xbutton){
            humanPlay = "X";
            aiPlay = "O";
            xbutton.setEnabled(false);
            obutton.setEnabled(false);
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    button[i][j].setEnabled(true);
                }
            }
        }
        else if(e.getSource() == obutton){
            humanPlay = "O";
            aiPlay = "X";
            xbutton.setEnabled(false);
            obutton.setEnabled(false);
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    button[i][j].setEnabled(true);
                }
            }
        }

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == button[i][j]){
                    player(i, j, humanPlay);
                }
            }
        }

        if (e.getSource() == rbutton){
            resetButton();
        }

    }
}
