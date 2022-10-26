package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //DBWork objesini olustur
        DBWork db = new DBWork();

        //Connection methodunu cagir
     Connection con= db.connect_to_db("postgres", "postgres", "Fth-2010.");

        //Yeni table olusturma methodu
        db.createTable(con,"Employees");
    }
}
