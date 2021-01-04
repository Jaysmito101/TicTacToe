import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeAI extends JFrame implements ActionListener {
    public String playerOne, playerTwo;
    Cells cells[][];
    private int difficulty;
    private AI logic;
    private int currentPlayer;
    public TicTacToeAI(int firstPlayer, int difficulty) {
        this.difficulty=difficulty;
        logic=new AI(firstPlayer==1?'U':'C');
        setUndecorated(true);
        currentPlayer = firstPlayer;
        playerOne = (int) (Math.random() * 2) + 1 == 1 ? "CROSS" : "CIRCLE";
        playerTwo = playerOne.equals("CROSS") ? "CIRCLE" : "CROSS";
        JOptionPane.showMessageDialog(this, Game.playerOne + " is " + playerOne + "\n" + Game.playerTwo + " is " + playerTwo);
        playerOne = playerOne.equals("CROSS") ? "cross.jpg" : "circle.jpg";
        playerTwo = playerTwo.equals("CROSS") ? "cross.jpg" : "circle.jpg";
        setTitle("TicTacToe -Jaysmito Mukherjee");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container mainPane = getContentPane();
        mainPane.setLayout(new GridLayout(3, 3, 0, 0));
        mainPane.setBackground(new Color(0, 0, 0));
        cells = new Cells[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cells(new ImageIcon("blank.jpg"), i, j);
                cells[i][j].addActionListener(this);
                cells[i][j].setToolTipText("");
                mainPane.add(cells[i][j]);
            }
        }
        setSize(450, 450);
        setResizable(false);
        if (firstPlayer==2) simulateComputerMove();
    }

    public void simulateComputerMove(){
        Position p=logic.getCompterMove();
        cells[p.getX()][p.getY()].setIcon(new ImageIcon(currentPlayer == 1 ? playerOne : playerTwo));
        cells[p.getX()][p.getY()].setToolTipText((currentPlayer==1?playerOne:playerTwo).indexOf("cross")>-1?"CROSS":"CIRCLE");
        check();
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(((Cells)e.getSource()).getIcon().toString().equals("blank.jpg")) {
            ((Cells) e.getSource()).setIcon(new ImageIcon(currentPlayer == 1 ? playerOne : playerTwo));
            ((Cells) e.getSource()).setToolTipText((currentPlayer==1?playerOne:playerTwo).indexOf("cross")>-1?"CROSS":"CIRCLE");
            logic.putUserMove(((Cells) e.getSource()).getI(), ((Cells) e.getSource()).getJ());
            check();
            if (!isDisplayable()) return;
            currentPlayer = currentPlayer == 1 ? 2 : 1;
            simulateComputerMove();
        }
    }
    public void check(){

        if(cells[0][0].getToolTipText().equals(cells[1][1].getToolTipText()) && cells[1][1].getToolTipText().equals(cells[2][2].getToolTipText()) && !cells[0][0].getToolTipText().equals("")){
            cells[0][0].setIcon(new ImageIcon(cells[0][0].getToolTipText().toLowerCase()+"RightDiagonal.jpg"));
            cells[1][1].setIcon(new ImageIcon(cells[1][1].getToolTipText().toLowerCase()+"RightDiagonal.jpg"));
            cells[2][2].setIcon(new ImageIcon(cells[2][2].getToolTipText().toLowerCase()+"RightDiagonal.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }
        else if(cells[0][2].getToolTipText().equals(cells[1][1].getToolTipText()) && cells[1][1].getToolTipText().equals(cells[2][0].getToolTipText()) && !cells[2][0].getToolTipText().equals("")){
            cells[0][2].setIcon(new ImageIcon(cells[0][2].getToolTipText().toLowerCase()+"LeftDiagonal.jpg"));
            cells[1][1].setIcon(new ImageIcon(cells[0][2].getToolTipText().toLowerCase()+"LeftDiagonal.jpg"));
            cells[2][0].setIcon(new ImageIcon(cells[0][2].getToolTipText().toLowerCase()+"LeftDiagonal.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }
        else if(cells[0][0].getToolTipText().equals(cells[0][1].getToolTipText()) && cells[0][1].getToolTipText().equals(cells[0][2].getToolTipText()) && !cells[0][2].getToolTipText().equals("")){
            cells[0][0].setIcon(new ImageIcon(cells[0][0].getToolTipText().toLowerCase()+"Side.jpg"));
            cells[0][1].setIcon(new ImageIcon(cells[0][0].getToolTipText().toLowerCase()+"Side.jpg"));
            cells[0][2].setIcon(new ImageIcon(cells[0][0].getToolTipText().toLowerCase()+"Side.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }else if(cells[1][0].getToolTipText().equals(cells[1][1].getToolTipText()) && cells[1][1].getToolTipText().equals(cells[1][2].getToolTipText()) && !cells[1][2].getToolTipText().equals("")){
            cells[1][0].setIcon(new ImageIcon(cells[1][1].getToolTipText().toLowerCase()+"Side.jpg"));
            cells[1][1].setIcon(new ImageIcon(cells[1][1].getToolTipText().toLowerCase()+"Side.jpg"));
            cells[1][2].setIcon(new ImageIcon(cells[1][1].getToolTipText().toLowerCase()+"Side.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }
        else if(cells[2][0].getToolTipText().equals(cells[2][1].getToolTipText()) && cells[2][1].getToolTipText().equals(cells[2][2].getToolTipText()) && !cells[2][2].getToolTipText().equals("")){
            cells[2][0].setIcon(new ImageIcon(cells[2][0].getToolTipText().toLowerCase()+"Side.jpg"));
            cells[2][1].setIcon(new ImageIcon(cells[2][0].getToolTipText().toLowerCase()+"Side.jpg"));
            cells[2][2].setIcon(new ImageIcon(cells[2][0].getToolTipText().toLowerCase()+"Side.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }
        else if(cells[0][0].getToolTipText().equals(cells[1][0].getToolTipText()) && cells[1][0].getToolTipText().equals(cells[2][0].getToolTipText()) && !cells[2][0].getToolTipText().equals("")){
            cells[0][0].setIcon(new ImageIcon(cells[0][0].getToolTipText().toLowerCase()+"Down.jpg"));
            cells[1][0].setIcon(new ImageIcon(cells[0][0].getToolTipText().toLowerCase()+"Down.jpg"));
            cells[2][0].setIcon(new ImageIcon(cells[0][0].getToolTipText().toLowerCase()+"Down.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }
        else if(cells[0][1].getToolTipText().equals(cells[1][1].getToolTipText()) && cells[1][1].getToolTipText().equals(cells[2][1].getToolTipText()) && !cells[2][1].getToolTipText().equals("")){
            cells[0][1].setIcon(new ImageIcon(cells[0][1].getToolTipText().toLowerCase()+"Down.jpg"));
            cells[1][1].setIcon(new ImageIcon(cells[0][1].getToolTipText().toLowerCase()+"Down.jpg"));
            cells[2][1].setIcon(new ImageIcon(cells[0][1].getToolTipText().toLowerCase()+"Down.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }
        else if(cells[0][2].getToolTipText().equals(cells[1][2].getToolTipText()) && cells[1][2].getToolTipText().equals(cells[2][2].getToolTipText()) && !cells[2][2].getToolTipText().equals("")){
            cells[0][2].setIcon(new ImageIcon(cells[0][2].getToolTipText().toLowerCase()+"Down.jpg"));
            cells[1][2].setIcon(new ImageIcon(cells[0][2].getToolTipText().toLowerCase()+"Down.jpg"));
            cells[2][2].setIcon(new ImageIcon(cells[0][2].getToolTipText().toLowerCase()+"Down.jpg"));
            JOptionPane.showMessageDialog(this,((currentPlayer==1?Game.playerOne:Game.playerTwo)+" WIN's the game!!"));
            Game.setWinner(currentPlayer);
            dispose();
            return;
        }

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(cells[i][j].getToolTipText().equals(""))return;
            }
        }
        JOptionPane.showMessageDialog(this,"There is a TIE!!!!!!!!!");
        dispose();
    }
}