import java.util.ArrayList;
import java.util.List;

public class Positions {
    private List<Position> positions;
    public Positions(){
        positions=new ArrayList<Position>();
    }

    public void add(Position position){
        positions.add(position);
    }

    public Position get(int index){
        return positions.get(index);
    }

    public int size(){
        return positions.size();
    }

    @Override
    public String toString(){
     String s="";
     for(Position p:positions){
         s+="X="+p.getX()+" Y="+p.getY()+"\n";
     }
     return s;
    }
}
