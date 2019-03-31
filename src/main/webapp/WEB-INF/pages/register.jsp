<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/styles/css/register.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/css/for_all.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/css/menu.css">
    <link rel="stylesheet" media="(max-width: 980px)" href="${pageContext.servletContext.contextPath}/styles/css/menu_side.css">
</head>
<body>
<tags:header_footer>
<main>
    <div class="container">
        <form method="post">
            <h2>Register</h2>
            <input type="text" name="uid" placeholder="Username" required>
            <input type="password" name="password" id="password1" placeholder="Password" required>
            <input type="password" name="confirm_password" id="password2" placeholder="Confirm password" required>
            <input type="email" name="email" placeholder="E-mail" required>
            <div>
                <input id="checkbox" type="checkbox" name="checkbox">
                <label for="checkbox">Subscribe to our newsletter</label>
            </div>
            <input type="submit" value="Register">
        </form>
    </div>
    <script type="text/javascript">
        window.onload = function () {
            document.getElementById("password1").onkeyup = validatePassword;
            document.getElementById("password2").onkeyup = validatePassword;
        }

        function validatePassword() {
            var pass2 = document.getElementById("password2").value;
            var pass1 = document.getElementById("password1").value;
            if ((pass1 == pass2) && (pass1.length != 0) && (pass2.length != 0)) {
                document.getElementById("password2").style.backgroundImage = "url(img/check-circle-regular.svg)";
                document.getElementById("password2").style.border = "";
                document.getElementById("password1").style.backgroundImage = "url(img/check-circle-regular.svg)";
                document.getElementById("password1").style.border = "";
            } else {
                document.getElementById("password2").style.backgroundImage = "";
                document.getElementById("password2").style.border = "1px solid red";
                document.getElementById("password1").style.backgroundImage = "";
                document.getElementById("password1").style.border = "1px solid red";
            }
        }
    </script>
</main>
<section class="bottom-galery">
    <div></div>
    <div></div>
    <div></div>
    <div></div>
</section>
</tags:header_footer>
</body>
</html>