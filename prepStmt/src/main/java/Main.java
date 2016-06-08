import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("Драйвер не загружен");
        }

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydbtest", "root", "root")) {

//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    "INSERT INTO users3 VALUES (?, ?, ?)");
//
//            preparedStatement.setInt(1, 1); //id
//            preparedStatement.setString(2, "Olegg"); //name
//            preparedStatement.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.execute();

            delete(connection, 7);
        }
        catch (SQLException e) {
            System.err.println("Соединение не установлено");
        }
    }

    public static void delete(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM users WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
