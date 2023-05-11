public class student extends player {
    task[] tasks;
    //constructor
    public student(String name){
        this.name=name;
        this.alive=true;
        this.tasks=new task[10];
    }
}
