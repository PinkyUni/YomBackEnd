<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/styles/css/login.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/css/for_all.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/css/menu.css">
    <link rel="stylesheet" media="(max-width: 980px)" href="${pageContext.servletContext.contextPath}/styles/css/menu_side.css">
</head>
<tags:header_footer>
    <main>
        <div class="container">
            <form action="profile" method="post">
                <div class="row">
                    <h2 style="text-align:center">Login</h2>
                    <div class="vl">
                        <span class="vl-innertext">or</span>
                    </div>

                    <div class="col">
                        <a href="#" class="fb btn">
                            <i class="fa fa-facebook fa-fw"></i> Login with Facebook
                        </a>
                        <a href="#" class="twitter btn">
                            <i class="fa fa-twitter fa-fw"></i> Login with Twitter
                        </a>
                        <a href="#" class="google btn"><i class="fa fa-google fa-fw">
                        </i> Login with Google+
                        </a>
                    </div>

                    <div class="col">
                        <div class="hide-md-lg">
                            <p>Or</p>
                        </div>

                        <input type="text" name="uid" placeholder="Username" required>
                        <input type="password" name="password" placeholder="Password" required>
                        <input type="submit" value="Login">
                    </div>

                </div>
            </form>
            <div class="bottom-container">
                <div class="row">
                    <div class="col">
                        <a href="register" style="color:white;" class="btn">Sign up</a>
                    </div>
                    <div class="col">
                        <a href="#" style="color:white" class="btn">Forgot password?</a>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <section class="bottom-galery">
        <div></div>
        <div></div>
        <div></div>
        <div></div>
    </section>
</tags:header_footer>
</html>
