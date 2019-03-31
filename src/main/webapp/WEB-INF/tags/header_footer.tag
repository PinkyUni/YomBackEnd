<%--
  Created by IntelliJ IDEA.
  User: Anya
  Date: 21.03.2019
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>

<%@tag description="main wrapper tag" pageEncoding="UTF-8"%>

<body>
    <nav>
        <a class="title" href="${pageContext.servletContext.contextPath}/Yom/main.html">Yom</a>
        <ul class="main-menu">
            <a href="${pageContext.servletContext.contextPath}/Yom/recipes.html"><li>Recipes</li></a>
            <a href="${pageContext.servletContext.contextPath}/Yom/ingredients.html"><li>Ingredients</li></a>
            <a href="${pageContext.servletContext.contextPath}/Yom/ideas.html"><li>Ideas</li></a>
            <a href="" title="Your profile"><img class="user-icon" src="${pageContext.servletContext.contextPath}/images/kek.jpg"></a>
        </ul>
        <span class="button-menu" onclick="openNav()">&#9776;</span>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="${pageContext.servletContext.contextPath}/Yom/recipes.html">Recipes</a>
            <a href="${pageContext.servletContext.contextPath}/Yom/ingredients.html">Ingredients</a>
            <a href="${pageContext.servletContext.contextPath}/Yom/ideas.html">Ideas</a>
            <a href="${pageContext.servletContext.contextPath}/Yom/login">Login</a>
        </div>
        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }
            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft= "0";
            }
        </script>
    </nav>
    <jsp:doBody/>
    <footer>
        <div class="footer-element">
            <span><a href="${pageContext.servletContext.contextPath}/Yom/main.html">Yom</a></span>
        </div>
        <div class="footer-element">
            <ul class="footer-menu">
                <li><a href="${pageContext.servletContext.contextPath}/Yom/recipes.html">Recipes</a></li>
                <li><a href=${pageContext.servletContext.contextPath}/Yom/ingredients.html">Ingredients</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/Yom/ideas.html">Ideas</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/Yom/login.html">Login</a></li>
            </ul>
        </div>
        <div class="footer-element">
            <ul class="footer-menu">
                <li>The first site</li>
                <li>Made by Anya</li>
                <li>Project for WT</li>
                <li><a href="https://www.bsuir.by">© BSUIR, 2019</a></li>
            </ul>
        </div>
    </footer>
</body>
