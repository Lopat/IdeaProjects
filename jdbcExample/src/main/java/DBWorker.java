import java.sql.*;

public class DBWorker {

    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    private Connection connection;

    public DBWorker() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            System.err.println("Соединение не получено");
        }
        catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Соединение установлено");
    }

    public void fin(){
        try {
            if(!connection.isClosed())
            connection.close();

            System.out.println("Соединение закрыто");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
