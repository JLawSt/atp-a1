import java.util.Scanner;

// Positions.
enum Position {
    Center,
    Goalie,
    Right_Wing,
    Left_Wing,
    Defense,
    Forward
}

public class Main {
    public static void main(String[] args) {
        // Init scanner to handle user input.
        Scanner scanner = new Scanner(System.in);

        // Request and set team name.
        System.out.println("Enter a name for your team: ");
        String teamName = scanner.nextLine(); // Get name input.
        Team team = new Team(teamName); // Init new team class using users team name.
        System.out.println("You set your team name as: " + team.getTeamName()); // Team name notif.

        // Request and determine users next act.
        displayMainMenu(); // Main menu options.
        while (!handleMainMenuSelection(scanner, team)) { // Determine users selection.
            // Exit program if function call returns true.
            System.out.println("Returning to main menu...");
            displayMainMenu();
        }

        System.exit(0);
    }

    // Function for displaying the main menu options to the user.
    public static void displayMainMenu() {
        System.out.println("Select one of the following options:\n" +
                "Enter '1' for Add Player.\n" +
                "Enter '2' for Add Coach.\n" +
                "Enter '3' for View Team.\n" +
                "Enter '4' for Remove Member.\n" +
                "Enter '5' for Exit.");
    }

    // Function for determining which of the main menu options the user wants to engage.
    public static boolean handleMainMenuSelection(Scanner scanner, Team team) {
        boolean validChoice = false; // Flag to determine when to stop running the switch.

        while (!validChoice) {
            int userMainMenuChoice = Integer.parseInt(scanner.nextLine()); // Get choice.

            switch (userMainMenuChoice) {
                case 1: // Add player.
                    System.out.println("Enter player name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter player age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter player position: ");
                    String position = scanner.nextLine();

                    System.out.println("Enter player number: ");
                    int number = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter player ice time: ");
                    int time = Integer.parseInt(scanner.nextLine());

                    Player player = new Player(name, age, position, number, time);
                    team.addTeamMember(player);
                    validChoice = true;// Break loop.
                    break;
                case 2: // Add coach.
                    System.out.println("Enter coach name: ");
                    String coachName = scanner.nextLine();

                    System.out.println("Enter coach age: ");
                    int coachAge = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter coach role: ");
                    String role = scanner.nextLine();

                    team.addTeamMember(new Coach(coachName, coachAge, role));
                    validChoice = true; // Break loop.
                    break;
                case 3: // View team.
                    team.viewTeam();
                    validChoice = true; // Break loop.
                    break;
                case 4: // Remove member.
                    validChoice = true; // Break loop.
                    break;
                case 5: // Exit program.
                    validChoice = true; // Break loop.
                    return true; // Switch condition for exiting program at higher level.
                default: // User will be re-prompted to enter input and switch will rerun.
                    System.out.println("Invalid choice.");
            }
        }

        return false; // If not case 5, will not exit program at higher level.
    }
}