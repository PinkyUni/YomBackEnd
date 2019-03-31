package YomServer.web;

import YomServer.model.dao.MySQLRecipeDao;
import YomServer.model.dao.MySQLUserDao;
import YomServer.model.entities.Recipe;
import YomServer.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProfilePageServlet extends HttpServlet {

    private MySQLUserDao userDao = MySQLUserDao.newInstance();
    private MySQLRecipeDao recipeDao = MySQLRecipeDao.newInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String cookieName = "uid";
        Cookie cookie = null;
        if(cookies !=null) {
            for(Cookie c: cookies) {
                if(cookieName.equals(c.getName())) {
                    cookie = c;
                    break;
                }
            }
        }
        if (cookie == null)
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        else{
            try {
                User user = userDao.getUser(cookie.getValue());
                setUserParams(req, resp, user);

            } catch (Exception e) {
                req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
        User user = null;
        try {
            user = userDao.getUser(req.getParameter("uid"));
            resp.addCookie(new Cookie("uid", user.getName()));
            setUserParams(req, resp, user);
        } catch (Exception e) {
            req.setAttribute("msg", e.toString());
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }
    }

    private void setUserParams(HttpServletRequest req, HttpServletResponse resp, User user) throws ClassNotFoundException, ServletException, IOException {
        req.setAttribute("photo", user.getPhoto());
        req.setAttribute("name", user.getName());
        ArrayList<Recipe> userRecipes = recipeDao.getRecipes(user.getRecipeTableName());
        ArrayList<Recipe> favRecipes = recipeDao.getRecipes(user.getFavTableName());
        req.setAttribute("userRecipesSize", userRecipes.size());
        req.setAttribute("favRecipesSize", favRecipes.size());
        req.setAttribute("userRecipes", userRecipes);
        req.setAttribute("favRecipes", favRecipes);
        //req.setAttribute("msg", "profile forward error");
        req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
    }
}
