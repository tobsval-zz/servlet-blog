import java.sql.*;

class DatabaseService {

    DatabaseService() {
        try {
            String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) { e.printStackTrace(); }
    }


    String retrieveEntry(String selectColumn, String conditionalColumn, String conditionalColValue){
        String foundEntry = null;
        try(Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/blog-db")){

            String query = "SELECT " + selectColumn + " FROM USERS WHERE " + conditionalColumn + " = ?";
            PreparedStatement prepStatement = conn.prepareStatement(query);
            ResultSet prepStmtResultSet;

            prepStatement.setString(1, conditionalColValue);
            prepStatement.executeQuery();
            prepStmtResultSet = prepStatement.getResultSet();

            while(prepStmtResultSet.next()){
                foundEntry = prepStmtResultSet.getString(1);
            }

            prepStatement.close();
            prepStmtResultSet.close();

        } catch (SQLException ignored) {}
        return foundEntry;
    }


    ResultSet forwardCustomQuery(PreparedStatement preparedStatement) throws SQLException {
        try(Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/blog-db")) {

            ResultSet prepStmtResultSet = preparedStatement.getResultSet();
            preparedStatement.close();
            prepStmtResultSet.close();

            return prepStmtResultSet;

        }
    }

}
