import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static final String FULL_NAME = "Full name: ";
    private static final String USERNAME = "User name: ";
    private static final String PASSWORD = "Password: ";
    private static final String OLD_PASSWORD = "Old password: ";
    private static final String NEW_PASSWORD = "New password: ";
    private static final String THANK_YOU_MESSAGE = "Thanks for using! Please visit us again!";
    private static final String DEFAULT_MESSAGE = "This option does not exist! Please try again!";

    public static void main(String[] args) {
        Admin admin = new Admin();
        Menu menu = new Menu();
        int userChoice;
        while (true) {
            menu.build();
            userChoice = Integer.parseInt(scanner.nextLine());
            if (UserChoice.QUIT.value() == userChoice) {
                printThankYouMessage();
                break;
            } else {
                handleUserRequest(admin, userChoice);
            }
        }
    }

    private static void printThankYouMessage() {
        System.out.println(THANK_YOU_MESSAGE);
    }

    private static void handleUserRequest(Admin admin, int userChoice) {
        switch (UserChoice.valueOf(choiceMap().get(userChoice))) {
            case LIST_USERS:
                admin.listUser();
                break;
            case FIND_USERS:
                admin.findUser(getInformationFromUser(USERNAME));
                break;
            case CREATE_USER:
                admin.createUser(getInformationFromUser(FULL_NAME), getInformationFromUser(USERNAME), getInformationFromUser(PASSWORD));
                break;
            case LOGIN:
                admin.logIn(getInformationFromUser(USERNAME), getInformationFromUser(PASSWORD));
                break;
            case GET_PASSWORD:
                admin.getPassword(getInformationFromUser(USERNAME));
                break;
            case CHANGE_PASSWORD:
                admin.changePassword(getInformationFromUser(USERNAME), getInformationFromUser(OLD_PASSWORD), getInformationFromUser(NEW_PASSWORD));
                break;
            case LOGOUT:
                admin.logOut(getInformationFromUser(USERNAME));
                break;
            default:
                System.out.println(DEFAULT_MESSAGE);
        }
    }

    private static String getInformationFromUser(String message) {
        System.out.println(message);
        String info = scanner.nextLine();
        return info;
    }

    public static Map<Integer, String> choiceMap() {
        Map<Integer, String> choiceMap = new HashMap<Integer, String>();
        choiceMap.put(1, "LIST_USERS");
        choiceMap.put(2, "FIND_USERS");
        choiceMap.put(3, "CREATE_USER");
        choiceMap.put(4, "LOGIN");
        choiceMap.put(5, "GET_PASSWORD");
        choiceMap.put(6, "CHANGE_PASSWORD");
        choiceMap.put(7, "LOGOUT");
        return choiceMap;
    }
}
