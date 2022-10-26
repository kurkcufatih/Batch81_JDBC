package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorkTekrar {

   //Postgresql baglanti kurma

    public Connection connect_to_db(String dbName, String user, String password) throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc::postgresql:/localhost:5432/postgres" + dbName, user, password);
            if (con != null) {
                System.out.println("Baglanti Saglandi");
            } else
                System.out.println("Baglanti Saglanamadi");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //Yeni sql tablosu olusturma

   public void createTable(Connection con, String tableName){
        Statement statement;

        try{
            String query ="CREATE TABLE"+   tableName+"(empId SERIAL, name VARCHAR(50), email VARCHAR(50), salary INTEGER, PRIMARY KEY (empId))";
            statement = con.createStatement();

            statement.executeUpdate(query);
            System.out.println("table created");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
