import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/SimpleDB";
        String user = "postgres";
        String pass = "alizhan1234";

        // Ресурсы в скобках try закроются автоматически
        try (Connection con = DriverManager.getConnection(connectionUrl, user, pass);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            System.out.println("Подключение успешно! Запрашиваю данные...");
            boolean hasData = false;
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getString("surname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}