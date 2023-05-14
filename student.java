import java.util.ArrayList;

public class student extends player {
    public String[] tasks=new String[4];
    //constructor
    public student(String name){
        this.name=name;
        this.alive=true;
        tasks=task.getcuatrotareas();
    }
}
