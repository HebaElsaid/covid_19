package com.example.android.anti_corona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private  String insert_stmt="INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES (NULL, ?, ?, ?);";
    private final String getAll_stmt="SELECT * FROM `users`";
    private final String check_stmt="Select * from users where name=? and password=?";


    public void insert(User o){
        try {
            DBconnection.connection();
            PreparedStatement ps= DBconnection.connection().prepareStatement(insert_stmt);
            ps.setString(2, o.getName());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getPassword());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("There is exp  \n ex: "+ex.getMessage());
        }
    }
    public String showall() {
        try {
            String result="";
            String SQL = "SELECT * FROM `users`";
            PreparedStatement stmt = database.connection().prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String Tmp="";
                Tmp+=""+rs.getInt(1)+"#";
                Tmp+=""+rs.getString(2)+"#";
                Tmp+=""+rs.getString(3)+"#";
                Tmp+=""+rs.getString(4)+"#\n";
                result+=Tmp;
                Tmp="";
            }

            return result;
        } catch (Exception e) {
            return e.getMessage() + "";
        }
    }
    public User check(String username , String password){
        User o = null;
        try {
            DBconnection.connection();
            PreparedStatement ps= DBconnection.connection().prepareStatement(check_stmt);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                o=new User( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("There is exp  \n ex: "+ex.getMessage());
        }
        return o;
    }
}
