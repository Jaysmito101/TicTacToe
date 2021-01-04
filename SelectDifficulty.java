import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDifficulty extends JFrame implements ActionListener {
    private JLabel instructions;
    private JButton easy, medium, hard;
    JPanel buttonPanel;

    public SelectDifficulty(){
        setTitle("Select Difficulty");
        setLayout(new FlowLayout());
        instructions=new JLabel("Select Difficulty:");
        instructions.setFont(new Font("Arial", Font.BOLD, 25));
        add(instructions, BorderLayout.NORTH);
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1,0,0));
        easy=new JButton("Easy");
        easy.setActionCommand("easy");
        easy.setBackground(new Color(230, 230, 230));
        easy.addActionListener(this);
        easy.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(easy);
        medium=new JButton("Medium");
        medium.setActionCommand("medium");
        medium.setBackground(new Color(230, 230, 230));
        medium.addActionListener(this);
        medium.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(medium);
        hard=new JButton("Hard");
        hard.setActionCommand("hard");
        hard.setBackground(new Color(230, 230, 230));
        hard.addActionListener(this);
        hard.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(hard);
        add(buttonPanel, BorderLayout.CENTER);
        setSize(230, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        if (command.equalsIgnoreCase("easy")){
            Selector.setDifficulty(Constants.EASY_PROBABILITY);
            dispose();
        }else if (command.equalsIgnoreCase("medium")){
            Selector.setDifficulty(Constants.MEDIUM_PROBABILITY);
            dispose();
        }else if (command.equalsIgnoreCase("hard")){
            Selector.setDifficulty(Constants.HARD_PROBABILITY);
            dispose();
        }else System.exit(-1);
    }
}
