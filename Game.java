import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class Game extends JFrame implements ActionListener {
    private JButton newGame, reset, exit;
    public static int winner;
    private static JLabel playerOneScoreShow;
    private static JLabel playerTwoScoreShow;
    private JLabel playerOneName;
    private JLabel playerTwoName;
    private JLabel scoreHead;
    private JLabel controlHead;
    private JMenuBar menuBar;
    private JMenu about;
    private JMenuItem aboutDeveloper, visitWebsite, ratings;
    static String playerOne, playerTwo;
    static int playerOneScore;
    static int playerTwoScore;
    public static int mode;
    private int difficulty;
    public Game(String playerOne, String playerTwo, int getMode, int difficulty){
        this.playerOne=playerOne;
        this.playerTwo=playerTwo;
        this.difficulty=difficulty;
        mode=getMode;
        playerOneScore=0;
        playerTwoScore=0;
        setLayout(new GridLayout(3,1,3,3 ));
        setTitle("TicTacToe -Jaysmito Mukherjee");
        menuBar=new JMenuBar();
        about=new JMenu("About");
        menuBar.add(about);
        aboutDeveloper=new JMenuItem("About Developer");
        aboutDeveloper.addActionListener(this);
        about.add(aboutDeveloper);
        visitWebsite=new JMenuItem("Visit Developer's Website");
        visitWebsite.addActionListener(this);
        about.add(visitWebsite);
        ratings=new JMenuItem("Give Ratings");
        ratings.addActionListener(this);
        about.add(ratings);
        setJMenuBar(menuBar);
        Container namePane=new Container();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        namePane.setLayout(new GridLayout(2,1,3,3));
        playerOne=playerOne.equals("")?"Player One":playerOne;
        playerTwo=playerTwo.equals("")?"Player Two":playerTwo;
        playerOneName=new JLabel("Player One: "+playerOne);
        namePane.add(playerOneName);
        playerTwoName=new JLabel("Player Two: "+playerTwo);
        namePane.add(playerTwoName);
        add(namePane);
        playerOneName.setFont(new Font("Arial Black",Font.ITALIC,13));
        playerTwoName.setFont(new Font("Arial Black",Font.ITALIC,13));
        Container scorePane=new Container();
        scorePane.setLayout(new GridLayout(3,1,3,3));
        scoreHead=new JLabel("Scores");
        scoreHead.setFont(new Font("Brodway", Font.BOLD,20));
        scorePane.add(scoreHead);
        playerOneScoreShow=new JLabel("Player One: "+(playerOneScore==0?"0":playerOneScore));
        scorePane.add(playerOneScoreShow);
        playerTwoScoreShow=new JLabel("Player Two: "+(playerTwoScore==0?"0":playerTwoScore));
        scorePane.add(playerTwoScoreShow);
        add(scorePane);
        Container controlPane=new Container();
        controlPane.setLayout(new GridLayout(4,1,3,3));
        controlHead=new JLabel("Controls");
        controlHead.setFont(new Font("Brodway", Font.BOLD,20));
        controlPane.add(controlHead);
        newGame=new JButton("New Game");
        newGame.setSize(80,60);
        newGame.addActionListener(this);
        controlPane.add(newGame);
        reset=new JButton("Reset");
        reset.setSize(80,60);
        reset.addActionListener(this);
        controlPane.add(reset);
        exit=new JButton("Exit");
        reset.setSize(80,60);
        exit.addActionListener(this);
        controlPane.add(exit);
        add(controlPane);
        setSize(300,390);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-150, Toolkit.getDefaultToolkit().getScreenSize().height/2-195);
    }
    public static void setWinner(int win){
        winner=win;
        if (winner==1)playerOneScore=playerOneScore+1;
        else if (winner==2)playerTwoScore=playerTwoScore+1;
        playerOneScoreShow.setText("Player One: "+playerOneScore);
        playerTwoScoreShow.setText("Player Two: "+playerTwoScore);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        if (command.equals("Exit")){Toolkit.getDefaultToolkit().beep();System.exit(0);}
        else if (command.equals("New Game")){
            winner=0;
            int firstPlayer=(int)(Math.random()*2)+1;
            JOptionPane.showMessageDialog(this,(firstPlayer==1?playerOne:playerTwo)+" plays first!");
            if (mode==Constants.HUMAN) {
                TicTacToe mainFrame = new TicTacToe(firstPlayer);
                mainFrame.setVisible(true);
                mainFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 225, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 225);
            }
            else if (mode==Constants.AI){
                TicTacToeAI mainFrame = new TicTacToeAI(firstPlayer, difficulty);
                mainFrame.setVisible(true);
                mainFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 225, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 225);
            }else System.exit(-1);
        }else if (command.equals("Reset")){
            dispose();
            Run.reset();
        }else if(command.equals("About Developer")){
            JOptionPane.showMessageDialog(this,"This Game is developed by\nJaysmito Mukherjee.\nYou can know more\nabout me through\nmy website:-\njaysmitomukherjee.xp3.biz");
        }else if(command.equals("Visit Developer's Website")){
            if(JOptionPane.showConfirmDialog(this, "Open Website?")==0){
                try {
                    Desktop.getDesktop().browse(new URI("http://jaysmitomukherjee.xp3.biz"));
                }catch (Exception ex){}
            }
        }else if(command.equals("Give Ratings")){
            if(JOptionPane.showConfirmDialog(this, "Open Website?")==0){
                try {
                    Desktop.getDesktop().browse(new URI("http://jaysmitomukherjee.xp3.biz/rateTicTacToe.html"));
                }catch (Exception ex){}
            }
        }
    }
}
