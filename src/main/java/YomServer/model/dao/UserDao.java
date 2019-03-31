package YomServer.model.dao;

import YomServer.model.entities.User;

import java.util.ArrayList;

public interface UserDao {

    User getUser(String name) throws ClassNotFoundException;
    void addUser(User user) throws ClassNotFoundException;
    void deleteUser(String name) throws ClassNotFoundException;
    ArrayList<User> getUsers() throws ClassNotFoundException;

}
