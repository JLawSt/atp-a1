public class Player extends Person {
    private String position;
    private int number;
    private int time;

    public Player(String name, int age, String position, int number, int time) {
        super(name, age);
        this.position = position;
        this.number = number;
        this.time = time;
    }
}
