import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<User> userList = new ArrayList<>();

        DBWorker worker = new DBWorker();
        String query = "SELECT * FROM users";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name") + resultSet.getInt("age"));
                user.setPassword(resultSet.getString("email"));
                userList.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        for (User u : userList) {
            System.out.println(u);
        }

        worker.fin();
    }
}
