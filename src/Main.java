import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in); // Static because being used in main which is static method.
    private static final String FULL_NAME = "Full name: "; // Constants.
    private static final String USERNAME = "User name: ";
    private static final String PASSWORD = "Password: ";
    private static final String OLD_PASSWORD = "Old password: ";
    private static final String NEW_PASSWORD = "New password: ";

    public static void main(String[] args) {
        Admin admin = new Admin();
        int optionSelected;
        while (true) {
            admin.doMenu();
            optionSelected = Integer.parseInt(scanner.nextLine());
            if (optionSelected == 8) {
                System.out.println("Thanks for using! Please visit us again!");
                break;
            } else {
                switch (optionSelected) {
                    case 1:
                        admin.listUser();
                        break;
                    case 2:
                        admin.findUser(getInformationFromUser(USERNAME));
                        break;
                    case 3:
                        admin.createUser(getInformationFromUser(FULL_NAME), getInformationFromUser(USERNAME), getInformationFromUser(PASSWORD));
                        break;
                    case 4:
                        admin.logIn(getInformationFromUser(USERNAME), getInformationFromUser(PASSWORD));
                        break;
                    case 5:
                        admin.getPassword(getInformationFromUser(USERNAME));
                        break;
                    case 6:
                        admin.changePassword(getInformationFromUser(USERNAME), getInformationFromUser(OLD_PASSWORD), getInformationFromUser(NEW_PASSWORD));
                        break;
                    case 7:
                        admin.logOut(getInformationFromUser(USERNAME));
                        break;
                    default:
                        System.out.println("This option does not exist! Please try again!");
                }
            }
        }
    }

    private static String getInformationFromUser(String message) {
        System.out.println(message);
        String info = scanner.nextLine();
        return info;
    }
}
