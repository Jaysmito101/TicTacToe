import java.awt.*;

public class Run {
    private static Selector mainFrame;

    public static void main(String args[]){
        mainFrame=new Selector();
        mainFrame.setVisible(true);
        mainFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-250,Toolkit.getDefaultToolkit().getScreenSize().height/2-150);
    }

    public static void reset(){
        mainFrame.dispose();
        mainFrame=null;
        mainFrame=new Selector();
        mainFrame.setVisible(true);
        mainFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-250,Toolkit.getDefaultToolkit().getScreenSize().height/2-150);
    }
}
