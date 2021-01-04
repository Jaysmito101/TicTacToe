import javax.swing.*;

public class Cells extends JButton {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    private int j;

    public Cells(ImageIcon icon, int i, int j){
        setIcon(icon);
        this.i=i;
        this.j=j;
    }
}
