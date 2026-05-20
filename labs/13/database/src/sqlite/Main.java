import java.sql.*;

void main() throws ClassNotFoundException, SQLException {
    Connection connection = null;
    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:test.db");
    connection.setAutoCommit(false);

    createTable(connection);
    insertData(connection);
    selectData(connection);

    connection.close();
}

public static void createTable(Connection c){

    try {
        Statement statement = c.createStatement();
        String sqlDropTable = "DROP TABLE IF EXISTS COMPANY";
        String sqlCreateTable = "CREATE TABLE COMPANY"+
                "(ID INT PRIMARY KEY NOT NULL, " +
                "NAME TEXT NOT NULL, AGE INT, ADDRESS CHAR(50), "+
                "SALARY REAL)";

        statement.executeUpdate(sqlDropTable);
        statement.executeUpdate(sqlCreateTable);

        statement.close();
        c.commit();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}

public static void insertData(Connection c) throws SQLException {

    Statement statement = c.createStatement();
    String sql = "INSERT INTO COMPANY (ID, NAME, AGE, ADDRESS, SALARY) VALUES" +
            "(1, 'Paul', 32, 'Brasov', 4000)";

    statement.executeUpdate(sql);
    statement.close();

    PreparedStatement preparedStatement = c.prepareStatement(
            "INSERT INTO COMPANY(ID, NAME, AGE, ADDRESS, SALARY) VALUES" +
                    "(?,?,?,?,?)"
    );

    preparedStatement.setInt(1, 2);
    preparedStatement.setString(2, "John");
    preparedStatement.setInt(3, 29);
    preparedStatement.setString(4, "Bucuresti");
    preparedStatement.setFloat(5, 6000);

    preparedStatement.executeUpdate();

    preparedStatement.setInt(1, 3);
    preparedStatement.setString(2, "Marry");
    preparedStatement.setInt(3, 45);
    preparedStatement.setString(4, "Iasi");
    preparedStatement.setFloat(5, 10000);

    preparedStatement.executeUpdate();
    preparedStatement.close();
    c.commit();
}

public static void selectData(Connection c) throws SQLException {
    Statement statement = c.createStatement();
    String sql = "SELECT * FROM COMPANY WHERE AGE < 35";

    ResultSet resultSet = statement.executeQuery(sql);
    while(resultSet.next()){
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String address = resultSet.getString("address");
        float salary = resultSet.getFloat("salary");

        System.out.println(id + " " + name + " " + age + " " +
                address + " " + salary);
    }

    resultSet.close();
    statement.close();
}
