package jdbc_kursSonrasiTekrar;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010.");
        Statement st = con.createStatement();

        //1. Örnek: companies tablosundan en yüksek ikinci
        // number_of_employees değeri olan company
        // ve number_of_employees değerlerini çağırın.

        String sql1 = "select company, number_of_employees from companies order by number_of_employees offset 1";
        ResultSet result1 = st.executeQuery(sql1);
        while (result1.next()) {
            System.out.println(result1.getString("company") + " " + result1.getInt("number_of_employees"));
        }

        //2. YOL SUBQUERY kullanarak
        String sql2 = "select company, number_of_employees from companies where" +
                "\nnumber_of_employees=(select max(number_of_employees) from companies\n" +
                "where number_of_employees<(select max(number_of_employees)\n" +
                "from companies))";
        ResultSet result2 = st.executeQuery(sql2);
        while (result2.next()) {
            System.out.println(result2.getString("company") + " " + result2.getInt("number_of_employees"));
        }

        con.close();
        st.close();
        result1.close();
        result2.close();


    }
}
