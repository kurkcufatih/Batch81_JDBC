package jdbc_practice;

import static jdbc_practice.DatabaseUtilty.*;

public class Query06 {
    public static void main(String[] args) {

        createConnection(); //create connection methodu olusturduk databaseutility classindan. direk cagirarak connection kurmus olduk

        String query = "Select * from ogrenciler";

        System.out.println("Sutun isimleri = " + getColumnNames(query));

        System.out.println("okul no: " + getColumnData(query, "okul_no"));
        System.out.println("ogrenci ismi: " + getColumnData(query, "ogrenci_ismi"));
        System.out.println("sinif: " + getColumnData(query, "sinif"));
        System.out.println("cinsiyet: " + getColumnData(query, "cinsiyet"));

    }
}
