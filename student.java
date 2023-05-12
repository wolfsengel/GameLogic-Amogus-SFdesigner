import java.util.ArrayList;

public class student extends player {
    ArrayList<task> tasks = new ArrayList<task>();
    //constructor
    public student(String name){
        this.name=name;
        this.alive=true;
    }
}
