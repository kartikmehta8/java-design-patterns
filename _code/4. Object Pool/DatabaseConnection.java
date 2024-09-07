public class DatabaseConnection {
    private boolean inUse;

    public DatabaseConnection() {
        this.inUse = false;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void connect() {
        inUse = true;
        System.out.println("Connecting to the database...");
    }

    public void disconnect() {
        inUse = false;
        System.out.println("Disconnecting from the database...");
    }
}
