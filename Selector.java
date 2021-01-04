import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Selector extends JFrame implements ActionListener {

    private JLabel instructions;
    private JButton user, computer;
    private JPanel buttonPanel;
    private static int difficultyMain;

    public static int getDifficulty() {
        return difficultyMain;
    }

    public static void setDifficulty(int difficulty) {
        difficultyMain = difficulty;
        String name=JOptionPane.showInputDialog(new JFrame(), "Enter Player Name : ");
        Game gameFrame=new Game(name, "AI[ "+(Constants.getProbability(difficulty))+" ]", Constants.AI, difficulty);
        gameFrame.setVisible(true);
    }

    public Selector(){
        setLayout(new BorderLayout());
        instructions=new JLabel("Play Verses : ");
        instructions.setFont(new Font("Arial", Font.BOLD, 25));
        add(instructions, BorderLayout.NORTH);
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 0, 0));
        user=new JButton("Human");
        user.setActionCommand("user");
        user.setBackground(new Color(230, 230, 230));
        user.addActionListener(this);
        user.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(user);
        computer=new JButton("Artificial Intelligence");
        computer.setActionCommand("ai");
        computer.setBackground(new Color(230, 230, 230));
        computer.addActionListener(this);
        computer.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(computer);
        add(buttonPanel, BorderLayout.CENTER);
        setSize(500,300);
        setTitle("TicTacToe ~Jaysmito Mukherjee");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        if (command.equals("ai")){
            SelectDifficulty mainFrame=new SelectDifficulty();
            mainFrame.setVisible(true);
            mainFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-115,Toolkit.getDefaultToolkit().getScreenSize().height/2-200);
            dispose();
        }
        else if (command.equalsIgnoreCase("user")){
            dispose();
            String P1name=JOptionPane.showInputDialog(this, "Enter Player One : ");
            String P2name=JOptionPane.showInputDialog(this, "Enter Player Two : ");
            Game gameFrame=new Game(P1name, P2name, Constants.HUMAN, 0);
            gameFrame.setVisible(true);
        }
        else System.exit(-1);
    }
}