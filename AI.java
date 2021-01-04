import java.awt.*;

public class AI {

    private char currentPlayer;
    private int difficulty;
    private char board[][];
    private Positions temp;

    public Positions getTemp() {
        return temp;
    }

    public void addTemp(Position temp) {
        this.temp.add(temp);
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public AI(char firstPlayer){
        this.currentPlayer=firstPlayer;
        board=new char[3][3];
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                board[i][j]='-';
    }

    public void putUserMove(int i, int j){
        if (currentPlayer=='U'){
            board[i][j]='U';
            currentPlayer='C';
        }
    }

    @Override
    public String toString(){
        String s="";
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
                s+=board[i][j]+" ";
            s+="\n";
        }
        return s;
    }

    public Position getCompterMove(){
        if (currentPlayer=='C'){
            Positions emptyPositions=new Positions();
            Positions goodPositions=new Positions();
            for (int i=0;i<3;i++)
                for (int j=0;j<3;j++)
                    if (board[i][j]=='-')
                        emptyPositions.add(new Position(i, j));
            for(int i=0;i<emptyPositions.size();i++){
                if (checkResultProbablity(board, emptyPositions.get(i))<=difficulty)
                    goodPositions.add(emptyPositions.get(i));
            }
            currentPlayer='U';
            if(goodPositions.size()!=0) {
                int randomPosition=(int)(Math.random()*goodPositions.size());
                board[goodPositions.get(randomPosition).getX()][goodPositions.get(randomPosition).getY()] = 'C';
                return goodPositions.get(randomPosition);
            }else{
                if (temp!=null){
                    int randomPosition=(int)(Math.random()*temp.size());
                    board[temp.get(randomPosition).getX()][temp.get(randomPosition).getY()] = 'C';
                    Position p=temp.get(randomPosition);
                    temp=null;
                    return p;
                }
            }
        }
        return null;
    }

    public int checkResultProbablity(char board[][], Position position){
        int i=position.getX();
        int j=position.getY();
        int winningProbability=0;
        char tempBoard[][]=new char[3][3];
        char tB[][] = new char[3][3];
        Positions emptyPositions=new Positions();
        for (int k=0;k<3;k++)
            for (int l=0;l<3;l++) {
                tempBoard[k][l] = board[k][l];
                if (tempBoard[k][l]=='-')
                    emptyPositions.add(new Position(k, l));
            }
        tempBoard[i][j]='C';
        if(check(tempBoard, 'C'))return -1;
        for (int k=0;k<emptyPositions.size();k++) {
            for (int m = 0; m < 3; m++)
                for (int l = 0; l < 3; l++)
                    tB[m][l] = tempBoard[m][l];
            tB[emptyPositions.get(k).getX()][emptyPositions.get(k).getY()]='U';
            if (check(tB, 'U')){
                winningProbability++;
                temp= new Positions();
                addTemp(new Position(emptyPositions.get(k).getX(), emptyPositions.get(k).getY()));
            }
        }
        return winningProbability;
    }

    public boolean check(char cells[][], char c){
        if(cells[0][0]==cells[1][1] && cells[1][1]==cells[2][2] && cells[0][0]==c)
            return true;
        else if(cells[0][2]==cells[1][1] && cells[1][1]==cells[2][0] && cells[2][0]==c)
            return true;

        else if(cells[0][0]==cells[0][1] && cells[0][1]==cells[0][2] && cells[0][2]==c)
            return true;
        else if(cells[1][0]==cells[1][1] && cells[1][1]==cells[1][2] && cells[1][2]==c)
            return true;
        else if(cells[2][0]==cells[2][1] && cells[2][1]==cells[2][2] && cells[2][2]==c)
            return true;
        else if(cells[0][0]==cells[1][0] && cells[1][0]==cells[2][0] && cells[2][0]==c)
            return true;
        else if(cells[0][1]==cells[1][1] && cells[1][1]==cells[2][1] && cells[2][1]==c)
            return true;
        else if(cells[0][2]==cells[1][2] && cells[1][2]==cells[2][2] && cells[2][2]==c)
            return true;
        return false;
    }
}
