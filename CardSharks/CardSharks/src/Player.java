import java.util.Date;

public class Player {

    private String firstName;
    private String lastName;
    private int score;

    public Player (String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String toString() {
        return firstName +  " " + lastName + "\t\t\t$" + score + "\t\t\t" + new Date();
    }
}
