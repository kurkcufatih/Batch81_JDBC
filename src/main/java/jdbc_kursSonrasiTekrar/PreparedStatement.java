package jdbc_kursSonrasiTekrar;

import java.sql.*;

public class PreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fth-2010.");
        Statement st=con.createStatement();
        //1. Örnek: Prepared statement kullanarak
        // company adı IBM olan
        // number_of_employees değerini
        // 9999 olarak güncelleyin.

        //1. Adım:  Prepared statement query'sini oluştur.
        String sql1 = "Update companies set number_of_employees = ? where company = ?";

        //2. Adım: PreparedStatement objesini oluştur.
        java.sql.PreparedStatement pst1 = con.prepareStatement(sql1);

        //3. Adım: set...() methodları ile soru işaretleri için değer gir.
        pst1.setInt(1, 9999);
        pst1.setString(2,"IBM");

        //4. Adım: Execute query
        int updateRowSayisi= pst1.executeUpdate();
        System.out.println(updateRowSayisi+" satir guncellendi");

        String sql2="Select * from companies";
        ResultSet result2=st.executeQuery(sql2);

        while(result2.next()){
            System.out.println(result2.getInt(1)+"--"+result2.getString(2)+"--"+ result2.getInt(3));
        }

        //Google için değişiklik
        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");

        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi2 + " satır güncellendi.");

        String sql3 = "SELECT * FROM companies";
        ResultSet result3 = st.executeQuery(sql3);

        while (result3.next()) {

            System.out.println(result3.getInt(1) + "--" + result3.getString(2) + "--" + result3.getInt(3));
        }

        //2. Örnek: "SELECT * FROM <table name>" query'sini
        // prepared statement ile kullanın.

        read_data(con,"companies");



    }
    //Bir tablonun istenilen datasını prepared statement ile çağırmak için kullanılan method.

    private static void read_data(Connection con, String tableName) {

        try{
            String query=String.format("Select * from %s",tableName);
            //Format() methodu dinamik String oluşturmak için kullanılır.

            Statement statement= con.createStatement();
            ResultSet rs=statement.executeQuery(query);
            //Datayı çağırıp ResultSet konteynırına koyuyoruz.

            while (rs.next()){
                System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
