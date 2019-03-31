package YomServer.model.dao;

import YomServer.model.entities.User;

import java.sql.*;
import java.util.ArrayList;

public class MySQLUserDao implements UserDao {

    private MySQLUserDao(){};

    private static class MySQLUserDaoSingletonHolder{
        static MySQLUserDao instance = new MySQLUserDao();
    }

    public static MySQLUserDao newInstance(){
        return MySQLUserDaoSingletonHolder.instance;
    }

    private String url = "jdbc:mysql://localhost:3306/yom?serverTimezone=UTC";
    private String userConnect = "root";
    private String password = "suka";
    private String table = "users";

    public User getUser(String name) throws ClassNotFoundException {
        User user = new User();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + " WHERE name = '" + name + "' ;");
            resultSet.first();
            getUserFromResultSet(user, resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private void getUserFromResultSet(User user, ResultSet resultSet) throws SQLException {
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setPhoto(resultSet.getString("img"));
        user.setRecipeTableName(resultSet.getString("recipeTable"));
        user.setFavTableName(resultSet.getString("favTable"));
    }

    public void addUser(User user) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO " + table + " (name, email, password, img, recipeTable, favTable) VALUES ( '" +
                    user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getPhoto() + "', '" +
                    user.getRecipeTableName() + "', '" + user.getFavTableName() + "' );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String name) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM " + table + " WHERE name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() throws ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM '" + table + "' ;");
            while (resultSet.next()) {
                User user = new User();
                getUserFromResultSet(user, resultSet);
                users.add(user);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
