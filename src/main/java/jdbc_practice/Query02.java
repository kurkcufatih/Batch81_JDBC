package jdbc_practice;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010.");

        Statement st = con.createStatement();

        ResultSet data = st.executeQuery("select * from ogrenciler where cinsiyet='E'");

//SORU : Ogrenciler tablosundaki erkek ogrencileri listeleyiniz

        while (data.next()) {
            System.out.println(data.getInt(1) + " " + data.getString(2)+ " " + data.getString(3) + " " + data.getString(4));
        }
        con.close();
        st.close();
        data.close();


    }
}
