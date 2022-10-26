package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBWork {
    //Postgreqsl baglantisi methodu

    public Connection connect_to_db(String dbName, String user, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" + dbName, user, password);
            if (con != null) {
                System.out.println("Baglanti saglandi");
            } else {
                System.out.println("Baglanti saglanamadi");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //Yeni tablo olusturma methodu

    public void createTable(Connection con, String tableName) {

        //Statement objesi olustur

        Statement statement;

        try {
            String query = "CREATE TABLE " + tableName + "(empId SERIAL, name varchar(50), email varchar(50), salary INTEGER, PRIMARY KEY (empId))";
            statement = con.createStatement();

            statement.executeUpdate(query);
            System.out.println("table created");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
