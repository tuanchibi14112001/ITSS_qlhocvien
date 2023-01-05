package quanlyhocvien.dao;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import  java.sql.*;

/**
 *
 * @author tuan
 */
public class DBConnect {

     public static Connection  getConnection() throws SQLException {
        try{
        String url = "jdbc:mysql://localhost:3306/quan_ly_hoc_vien";
        String user = "root";
        String passowd = "";
        Connection cons ;
        
        cons =  DriverManager.getConnection(url, user, passowd);
        return cons;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    public static void main(String[] args) throws SQLException {
        Connection coin = getConnection();
        System.out.println(coin.toString());
        coin.close();
    }
}


