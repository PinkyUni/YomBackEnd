package YomServer.model.entities;

public class User {

    private String name;
    private String email;
    private String photo;
    private String password;
    private String recipeTableName;
    private String favTableName;

    public User() {}

    public User(String name, String email, String photo, String password, String recipeTableName, String favTableName) {
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.recipeTableName = recipeTableName;
        this.favTableName = favTableName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecipeTableName() {
        return recipeTableName;
    }

    public void setRecipeTableName(String recipeTableName) {
        this.recipeTableName = recipeTableName;
    }

    public String getFavTableName() {
        return favTableName;
    }

    public void setFavTableName(String favTableName) {
        this.favTableName = favTableName;
    }
}
