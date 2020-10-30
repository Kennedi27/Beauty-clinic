/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RIDO
 */
public class KoneksiDatabase {
    private static Connection koneksi;
    public static Connection getKoneksi(){
        
        //Cek apakah koneksi null
        if(koneksi == null){
            
            try {
                String url = "jdbc:mysql://localhost:3306/UNIVERSITAS";
                String user = "rido57";
                String password = "sistemdatabase";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                koneksi = DriverManager.getConnection(url, user, password);
                
            } catch (SQLException t){
                System.out.println("Error Membuat Koneksi");
            }
        }
        
        return koneksi;
    }
    
}
