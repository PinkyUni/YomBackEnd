package YomServer.model.dao;

import YomServer.model.entities.Recipe;

import java.util.ArrayList;

public interface RecipeDao {

    Recipe getRecipe(int id) throws ClassNotFoundException;
    void addRecipe(Recipe recipe) throws ClassNotFoundException;
    void deleteRecipe(String name) throws ClassNotFoundException;
    ArrayList<Recipe> getRecipes(String userTable) throws ClassNotFoundException;

}
