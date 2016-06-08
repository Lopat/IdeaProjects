import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
            //Либо Class.forName("com.mysql.jdbc.Driver")
            //Главное, чтоб подгрузился драйвер
        }
        catch (SQLException e){
            System.err.println("Драйвер не загружен");
        }

         try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            //statement.execute(); - INSERT
            //statement.executeUpdate(); - UPDATE
            //statement.addBatch(SQL) - для нескольких запросов/ .executeBatch() - запускает Batch/ .clearBatch();


            ResultSet result = statement.executeQuery("SELECT age, name FROM users WHERE age BETWEEN 14 AND 18");

            while (result.next()) {
                System.out.println(result.getInt("age") + "\t" + result.getString("name"));
            }
            if (! connection.isClosed()) {
                connection.close();
            }
        }
        catch (SQLException e) {
            System.err.println("Ошибка подключения/запроса");
        }

    }

}
