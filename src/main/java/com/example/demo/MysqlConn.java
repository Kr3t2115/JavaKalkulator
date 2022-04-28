package com.example.demo;

import java.sql.*;

class MysqlConn{

    private Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obliczanie","root","");

        }catch(Exception e){ System.out.println(e);}

        return null;
    }

    public PreparedStatement preparedStatement(String query) throws SQLException {
        Connection connection = getConnection();
        return connection.prepareStatement(query);
    }

    public void main(String sql){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/obliczanie","root","");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            boolean rs=stmt.execute(sql);

//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
