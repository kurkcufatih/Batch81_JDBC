package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01Tekrar {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010.");
        Statement st = con.createStatement();

        //1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1 = "create table isciler(worker_id varchar(50), worker_name varchar(50), worker_salary INTEGER)";
        boolean result = st.execute(sql1);
        System.out.println(result);

        //2.Örnek: Table'a worker_address sütunu ekleyerel alter yapın.
        String sql2 = "alter table isciler add worker_address varchar(80)";
        st.execute(sql2);

        String sql3 = "drop table isciler";
        con.close();
        st.close();
    }
}