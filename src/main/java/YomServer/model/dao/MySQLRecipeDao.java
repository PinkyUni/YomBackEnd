package YomServer.model.dao;

import YomServer.model.entities.Recipe;

import java.sql.*;
import java.util.ArrayList;

public class MySQLRecipeDao implements RecipeDao {

    private MySQLRecipeDao(){};

    private static class MySQLRecipeDaoSingletonHolder{
        static MySQLRecipeDao instance = new MySQLRecipeDao();
    }

    public static MySQLRecipeDao newInstance(){
        return MySQLRecipeDao.MySQLRecipeDaoSingletonHolder.instance;
    }

    private String url = "jdbc:mysql://localhost:3306/Yom";
    private String userConnect = "root";
    private String password = "suka";
    private String table = "recipes";

    @Override
    public Recipe getRecipe(int id) throws ClassNotFoundException {
        Recipe recipe = new Recipe();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + " WHERE id = " + id + " ;");
            getRecipeFromResultSet(resultSet, recipe);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    public void addRecipe(Recipe recipe) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO " + table + " (name, img, portions, calories, time, ingredients, cooking) VALUES ( " +
                    recipe.getRecName() + ", " + recipe.getPhoto() + "," + recipe.getPortions() + ", " + recipe.getCalories() + ", " +
                    recipe.getTime() + ", " + recipe.getIngredients() + "," + recipe.getCooking() + " );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecipe(String name) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM " + table + " WHERE name = " + name + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Recipe> getRecipes(String userTable) throws ClassNotFoundException {
        if (userTable == null)
            userTable = table;
        else
            if (userTable.equals("none"))
                return new ArrayList<>();
        ArrayList<Recipe> recipes = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userConnect, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + userTable + " ;");
            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                getRecipeFromResultSet(resultSet, recipe);
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    void getRecipeFromResultSet(ResultSet resultSet, Recipe recipe) throws SQLException {
        recipe.setRecName(resultSet.getString("name"));
        recipe.setPhoto(resultSet.getString("img"));
        recipe.setPortions(resultSet.getString("portions"));
        recipe.setCalories(resultSet.getString("calories"));
        recipe.setTime(resultSet.getTime("time"));
        recipe.setIngredients(resultSet.getString("ingredients"));
        recipe.setCooking(resultSet.getString("cooking"));
    }
}
