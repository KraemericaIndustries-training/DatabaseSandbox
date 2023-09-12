import java.sql.*;
import static transactSQL.DatabaseConnection.*;

public class App {
    public static void main(String[] args) throws SQLException {
        transactSQL.DatabaseConnection.getProperties();
        ResultSet resultSet = select("select * from Words_tbl");

        while(resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

    }

    public static ResultSet select(String selectQuery) {
        ResultSet resultSet = null;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}