public enum UserChoice {
    LIST_USERS(1),
    FIND_USERS(2),
    CREATE_USER(3),
    LOGIN(4),
    GET_PASSWORD(5),
    CHANGE_PASSWORD(6),
    LOGOUT(7),
    QUIT(8);

    private int value;

    private UserChoice(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
