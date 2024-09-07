import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final List<DatabaseConnection> availableConnections;
    private final int maxPoolSize;

    public ConnectionPool(int maxPoolSize) {
        this.availableConnections = new ArrayList<>();
        this.maxPoolSize = maxPoolSize;
    }

    public synchronized DatabaseConnection getConnection() {
        for (DatabaseConnection connection : availableConnections) {
            if (!connection.isInUse()) {
                connection.connect();
                return connection;
            }
        }

        if (availableConnections.size() < maxPoolSize) {
            DatabaseConnection newConnection = new DatabaseConnection();
            newConnection.connect();
            availableConnections.add(newConnection);
            return newConnection;
        }

        throw new RuntimeException("No available connections in the pool.");
    }

    public synchronized void releaseConnection(DatabaseConnection connection) {
        connection.disconnect();
    }
}
