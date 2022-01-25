package Model;

public class Action {
    public String name;
    public int s;
    public int f;
    
    public Action(String name, int startTime, int finishTime){
        this.name = name;
        this.s = startTime;
        this.f = finishTime;
    }
}
