package jdbc_kursSonrasiTekrar;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1-Driver yukle
        Class.forName("org.postgresql.Driver");

        //2-Baglanti Olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010.");

        //3-Statement olustur
        Statement st = con.createStatement();

        //4-ResultSet olustur
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //5-Sonuclari al
        while (veri.next()) {
            //index kullanarak sonuc alma
            System.out.println(veri.getInt(1) + veri.getInt(2) + veri.getInt(3) + veri.getInt(4));

            //sutun ismi kullanarak
            System.out.printf("%-6d %-15.15s %-8s %-8s\n" + veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        }
        con.close();
        st.close();
        veri.close();
    }
}
