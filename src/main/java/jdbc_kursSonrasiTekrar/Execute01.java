package jdbc_kursSonrasiTekrar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Adim : Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adim : Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010.");

        //3.Adim : Statement olustur
        Statement st = con.createStatement();

        //4.Adim : Query calistir

        //1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1 = "create table workers(worker_id varchar(50), worker_name varchar(50), worker_salary int";
        boolean result = st.execute(sql1);
        System.out.println(result); //False return verir cunku data cagrilmadi


        //2.Örnek: Alter table by adding worker_address column into the workers table
        //2.Örnek: Table'a worker_address sütunu ekleyerel alter yapın.
        String sql2 = "alter table workers add worker_address varchar(80)";
        st.execute(sql2);

        //3.Example: Drop workers table
        String sql3 = "drop table workers";

        //5.Adim : Baglanti ve Statement'i kapat
        con.close();
        st.close();


    }
}
