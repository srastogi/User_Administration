import java.util.ArrayList;

public class Admin {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<User> loggedInUsers = new ArrayList<User>();
    private boolean foundUser;
    private final String NO_USER_CREATED = "No users created yet!";
    private final String NO_USER_LOGGED_IN = "No user is logged in at this moment!";

    public void findUser(String userName) {
        if (!checkIfListIsEmpty(users, NO_USER_CREATED)) {
            for (User user : users) {
                if (user.getUserName().equals(userName)) {
                    System.out.println(user.toString());
                }
            }
        }
    }

    public void listUser() {
        if (!checkIfListIsEmpty(users, NO_USER_CREATED)) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }

    public void createUser(String fullName, String userName, String Password) {
        User user = new User(userName, fullName, Password);
        users.add(user);
    }

    public void logIn(String userName, String password) {
        if (!checkIfListIsEmpty(users, NO_USER_CREATED)) {
            foundUser = false;
            for (User user : users) {
                if (user.getUserName().equals(userName)) {
                    foundUser = true;
                    if (user.getPassword().equals(password)) {
                        loggedInUsers.add(user);
                        System.out.println("Login Successful!");
                        System.out.println(user.getFullName());
                        break;
                    } else {
                        System.out.println("Wrong password!");
                    }
                }
            }
            checkIfUserExists();
        }
    }

    public void getPassword(String userName) {
        if (!checkIfListIsEmpty(users, NO_USER_CREATED)) {
            foundUser = false;
            for (User user : users) {
                if (user.getUserName().equals(userName)) {
                    foundUser = true;
                    System.out.println(user.getPassword());
                    break;
                }
            }
            checkIfUserExists();
        }
    }

    public void changePassword(String userName, String oldPassword, String newPassword) {
        if (!checkIfListIsEmpty(loggedInUsers, NO_USER_LOGGED_IN)) {
            foundUser = false;
            for (User loggedInUser : loggedInUsers) {
                if (loggedInUser.getUserName().equals(userName)) {
                    foundUser = true;
                    if (loggedInUser.getPassword().equals(oldPassword)) {
                        loggedInUser.setPassword(newPassword);
                        System.out.println("Your password was successfully set to: " + loggedInUser.getPassword());
                    } else {
                        System.out.println("You entered wrong password. Please try again!");
                    }
                }
            }
            checkIfUserIsNotLoggedIn(userName);
            checkIfUserExists();
        }
    }

    public void logOut(String userName) {
        if (!checkIfListIsEmpty(loggedInUsers, NO_USER_LOGGED_IN)) {
            foundUser = false;
            for (User loggedInUser : loggedInUsers) {
                if (loggedInUser.getUserName().equals(userName)) {
                    foundUser = true;
                    loggedInUsers.remove(loggedInUser);
                    System.out.println("Log Out Successful!");
                    break;
                }
            }
            checkIfUserIsNotLoggedIn(userName);
            checkIfUserExists();
        }
    }

    private void checkIfUserIsNotLoggedIn(String userName) {
        if (!foundUser) {
            for (User user : users) {
                if (user.getUserName().equals(userName)) {
                    System.out.println("This user is not logged in!");
                    foundUser = true;
                    break;
                }
            }
        }
    }

    private void checkIfUserExists() {
        if (!foundUser) {
            System.out.println("User name does not exist!");
        }
    }

    private boolean checkIfListIsEmpty(ArrayList<User> arrayList, String message) {
        if (arrayList.isEmpty()) {
            System.out.println(message);
            return true;
        } else {
            return false;
        }
    }
}
