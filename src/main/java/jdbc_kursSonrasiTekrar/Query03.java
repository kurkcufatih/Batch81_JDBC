package jdbc_kursSonrasiTekrar;

import java.sql.*;
import java.sql.PreparedStatement;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010,");
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Sutun sayisi : " + rsmd.getColumnCount());
        System.out.println("1. Sutun ismi : " + rsmd.getColumnName(1));
        System.out.println("2. Sutun ismi : " + rsmd.getColumnName(2));
        System.out.println("3. Sutun ismi : " + rsmd.getColumnName(3));
        System.out.println("4. Sutun ismi : " + rsmd.getColumnName(4));


        System.out.println("1. sutun data tipi : " + rsmd.getColumnTypeName(1));
        System.out.println("2. sutun data tipi : " + rsmd.getColumnTypeName(2));
        System.out.println("3. sutun data tipi : " + rsmd.getColumnTypeName(3));
        System.out.println("4. sutun data tipi : " + rsmd.getColumnTypeName(4));

        System.out.println("tablo ismi : " + rsmd.getTableName(1));

        st.close();
        con.close();
        rs.close();
    }
}
