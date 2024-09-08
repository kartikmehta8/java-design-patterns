public class StaticFactoryExample {
    public static void main(String[] args) {

        User admin = UserFactory.createUser("admin");
        admin.displayRole();

        User regular = UserFactory.createUser("regular");
        regular.displayRole();

        // Uncomment to see error handling for unknown roles.
        // User unknown = UserFactory.createUser("guest");
    }
}
