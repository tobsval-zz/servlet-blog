package services;

import java.sql.*;


public class DatabaseService {

    public DatabaseService() {
        try {
            String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String retrieveEntry(String selectColumn, String table, String conditionalColumn, String conditionalColValue) {
        String foundEntry = null;
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/blog-db")) {

            String query = "SELECT " + selectColumn + " FROM " + table + " WHERE " + conditionalColumn + " = ?";
            PreparedStatement prepStatement = conn.prepareStatement(query);
            ResultSet prepStmtResultSet;

            prepStatement.setString(1, conditionalColValue);
            prepStatement.executeQuery();
            prepStmtResultSet = prepStatement.getResultSet();

            while (prepStmtResultSet.next()) {
                foundEntry = prepStmtResultSet.getString(1);
            }

            prepStatement.close();
            prepStmtResultSet.close();

        } catch (SQLException ignored) {
        }
        return foundEntry;
    }

    public boolean userExists(String username) {
        //Returns true if user exists, false if not
        return retrieveEntry("username", "USERS",
                "username", username) != null;
    }
}

