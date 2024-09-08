public class UserFactory {

    public static User createUser(String role) {
        if ("admin".equalsIgnoreCase(role)) {
            return new AdminUser();
        } else if ("regular".equalsIgnoreCase(role)) {
            return new RegularUser();
        } else {
            throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
