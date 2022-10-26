package jdbc;

import java.sql.*;

public class CallableStatementTekrar {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010.");
        Statement st = con.createStatement();

        String sql1 = "CREATE FUNCTION toplamaFonksiyonu(x NUMERIC, y NUMERIC)\n" +
                "RETURNS NUMERIC \n" +
                "LANGUAGE plpgsql \n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN x+y;\n" +
                "\n" +
                "END\n" +
                "$$";

        st.execute(sql1);
        CallableStatement cst1 = con.prepareCall("{?=call toplamaFonksiyonu(?,?)}");

        cst1.registerOutParameter(1, Types.NUMERIC);
        cst1.setInt(2, 15);
        cst1.setInt(3, 25);

        cst1.execute();

        System.out.println(cst1.getBigDecimal(1));
    }
}
