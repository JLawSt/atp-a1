import java.util.List;
import java.util.ArrayList;

public class Team {

    private String teamName; // Team name var.
    private List<Person> teamMembers = new ArrayList<>();

    // Constructor.
    // Creates new Team object with defined params when invoked.
    public Team(String teamName) {
        this.teamName = teamName;
    }

    // Team name getter function.
    public String getTeamName() {
        return teamName;
    }

    public void addTeamMember(Person person) {
        teamMembers.add(person);
    }

    public void viewTeam() {
        for (Person person : teamMembers) {
            System.out.println(person);
        }
    }
}
