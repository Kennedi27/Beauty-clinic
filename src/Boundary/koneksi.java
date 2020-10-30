package Boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class koneksi {
    public static Connection con;
    public static Statement stm;
    public void config(){
        try {
            String url = "jdbc:mysql://localhost/beautyclinic";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            System.out.println("Koneksi Berhasil");
        }catch(Exception e){
            System.err.println("Koneksi Gagal" +e.getMessage());
        }
    }
}
