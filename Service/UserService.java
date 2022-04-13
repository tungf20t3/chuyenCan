/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.User;
import Dao.UserDao;

public class UserService {
    private UserDao userDao;
    
    public UserService() {
        userDao = new UserDao();
    }
    
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
    
    public void addUser(User user) {
        userDao.addUser(user);
    }
    
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
    
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    
    public  User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
