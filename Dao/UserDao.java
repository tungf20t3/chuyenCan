/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.User;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class UserDao {
    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM USER";
        
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);             
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhoneNumber(rs.getString("phoneNumber"));   
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAbout(rs.getString("about"));
                user.setFavourties(rs.getString("favorite"));
                user.setRole(rs.getString("role"));
                
                users.add(user);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return users;  
    }
    
    public User getUserById(int id) {
        
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM USER WHERE ID = ?";
        
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql); 
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhoneNumber(rs.getString("phoneNumber"));   
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAbout(rs.getString("about"));
                user.setFavourties(rs.getString("favorite"));
                user.setRole(rs.getString("role"));
                
                return user;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;  
    }
    
    public void addUser(User user) {
        Connection connection  = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO user(name, phoneNumber, userName, password, about, favorite, role) VALUE(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhoneNumber());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getFavourties());
            preparedStatement.setString(7, user.getRole());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
         
    public void updateUser(User user) {
        Connection connection  = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE user SET name = ?,phoneNumber = ?,UserName = ?,Password = ?,About = ?,favorite = ?,Role = ? WHERE Id = ?";       
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhoneNumber());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getFavourties());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setInt(8, user.getId());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
    
    public void deleteUser(int id) {
        Connection connection  = JDBCConnection.getJDBCConnection();
        
        String sql = "delete from User where id = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }   
    
}
