package YomServer.web;

import YomServer.model.dao.MySQLRecipeDao;
import YomServer.model.dao.MySQLUserDao;
import YomServer.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPageServlet extends HttpServlet {

    private MySQLUserDao userDao = MySQLUserDao.newInstance();
    private MySQLRecipeDao recipeDao = MySQLRecipeDao.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            user = userDao.getUser(req.getParameter("uid"));
            req.setAttribute("msg", user.getName());
            // req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);

//            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            if (user.getName() == null) {
                user = new User();
                user.setName(req.getParameter("uid"));
                user.setPassword(req.getParameter("password"));
                user.setEmail(req.getParameter("email"));
                user.setFavTableName("none");
                user.setRecipeTableName("none");
                user.setPhoto("kek.jpg");
                try {
                    userDao.addUser(user);
                    resp.addCookie(new Cookie("uid", user.getName()));
                    resp.sendRedirect("profile");
                } catch (ClassNotFoundException e1) {
                    req.setAttribute("msg", e1.getMessage());
                    req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
                }
            }
            else
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        } catch (Exception e) {
//            user = new User();
//            user.setName(req.getParameter("uid"));
//            user.setPassword(req.getParameter("password"));
//            user.setEmail(req.getParameter("email"));
//            user.setFavTableName("none");
//            user.setRecipeTableName("none");
//            user.setPhoto("kek.jpg");
//            try {
//                userDao.addUser(user);
//                resp.sendRedirect("profile");
//            } catch (ClassNotFoundException e1) {
//                req.setAttribute("msg", e1.getMessage());
//                req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
//            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);

    }
}
