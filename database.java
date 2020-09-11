package com.example.android.anti_corona;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

    private static  String username="root";
    private static  String password="";
    private static  String dbname="covid";
    private static  String dsn="https://192.168.1.5/phpmyadmin/db_structure.php?server=1&db="+database.dbname;

    public static Connection connection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  handler=null;
        try{
            handler= DriverManager.getConnection(database.dsn,database.username,database.password);
            Log.i("dddddddddd","hhhhhhhhhhh");
        }catch(Exception e){
            Log.i("dddddddddd","aaaaaaaaaaaaaaaaaaaaaa");
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