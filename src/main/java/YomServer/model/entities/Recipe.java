package YomServer.model.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

public class Recipe {

    private String recName;
    private String photo;
    private String portions;
    private String calories;
    private Time time;
    private String ingredients;
    private String cooking;
    private ArrayList<String> ingredientsList;

    public Recipe(){}

    public ArrayList<String> getIngredientsList() {
        return ingredientsList;
    }

    public Recipe(String recName, String photo, String portions, String calories, Time time, String ingredients, String cooking) {
        this.recName = recName;
        this.photo = photo;
        this.portions = portions;
        this.calories = calories;
        this.time = time;
        this.ingredients = ingredients;
        this.cooking = cooking;
    }

    private void parseIngredients(){
        ingredientsList = (ArrayList<String>)Arrays.asList(ingredients.split("\n"));
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPortions() {
        return portions;
    }

    public void setPortions(String portions) {
        this.portions = portions;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }
}
