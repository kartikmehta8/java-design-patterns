public class PoolPatternExample {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(3);

        DatabaseConnection connection1 = connectionPool.getConnection();
        DatabaseConnection connection2 = connectionPool.getConnection();
        DatabaseConnection connection3 = connectionPool.getConnection();

        try {
            DatabaseConnection connection4 = connectionPool.getConnection();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        connectionPool.releaseConnection(connection1);
        DatabaseConnection reusedConnection = connectionPool.getConnection();
    }
}
