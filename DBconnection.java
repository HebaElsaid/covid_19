package com.example.android.anti_corona;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static  String username="root";
    private static  String password="";
    private static  String dbname="covid";
    private static  String dsn="jdbc:mysql://10.0.2.2:3306/"+DBconnection.dbname;

    public static Connection connection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  handler=null;
        try{
            handler= DriverManager.getConnection(DBconnection.dsn,DBconnection.username,DBconnection.password);
            Log.i("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh","yyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        }catch(Exception e){
        }
        finally{
            if(handler !=null){
                return handler;
            }else{
                return null;
            }
        }
    }
}
