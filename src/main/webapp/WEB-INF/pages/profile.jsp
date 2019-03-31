<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="userRecipes" type="java.util.ArrayList" scope="request"/>
<jsp:useBean id="favRecipes" type="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/styles/css/profile.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/css/for_all.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/css/menu.css">
    <link rel="stylesheet" media="(max-width: 1200px)" href="${pageContext.servletContext.contextPath}/styles/css/menu_side.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.0/css/all.css" integrity="sha384-Mmxa0mLqhmOeaE8vgOSbKacftZcsNYDjQzuCOm6D02luYSzBG8vpaOykv9lFQ51Y" crossorigin="anonymous">
</head>
<tags:header_footer>
<main>
    <section class="main">
        <section class="user-info">
            <div class="user-photo">
                <img src="${pageContext.servletContext.contextPath}/images${param.photo}" class="photo" alt="Your Photo">
            </div>
            <div class="user-name">
                <span class="name">${param.name}</span>
            </div>
        </section>
        <section class="info">
            <div class="settings">
                <i class="fas fa-cog"></i>
            </div>
            <div class="recipes-info">
                <div class="recipes-count">
                    <div class="user-recipes">
                        <span>${param.userRecipesSize}</span>
                        <span class="name">Your recipes</span>
                    </div>
                    <div class="fav-recipes">
                        <span>${param.favRecipesSize}</span>
                        <span class="name">Favourite recipes</span>
                    </div>
                </div>
                <div class="tabs">
                    <span class="tab"><i class="fas fa-plus"></i></span>
                    <span class="tab">Recipes</span>
                    <span class="tab">Favourites</span>
                </div>
            </div>
        </section>
    </section>
    <section class="container">

        <c:forEach var="recipe" items="${userRecipes}">
        <div class="recipe">
            <div class="img-el">
                <img class="img" src="${pageContext.servletContext.contextPath}/images/bck.jpg">
            </div>
            <div class="info-el">
                <span class="recipe-name">Name</span>
                <div class="main-info-el">
                    <div class="ingredients">
                        <span class="ing-title"><u>Ingredients:</u></span>
                        <ul class="list">
                            <%--<c:forEach var="ingredient" items="${recipe.getIngredients()}">--%>
                                <%--<li>${ingredient}</li>--%>
                            <%--</c:forEach>--%>
                        </ul>
                    </div>
                    <div class="cooking-info">
                        <div class="cooking-el">
                            <span>214</span>
                            <span>Calories</span>
                        </div>
                        <span class="del"></span>
                        <div class="cooking-el">
                            <span>1:20</span>
                            <span>Time</span>
                        </div>
                        <span class="del"></span>
                        <div class="cooking-el">
                            <span>4</span>
                            <span>Portions</span>
                        </div>
                    </div>
                </div>
                <div class="btn">
                    <div class="btn-name">See more</div>
                </div>
            </div>
        </div>
    </c:forEach>

    </section>
</main>
<section class="bottom-galery">
    <div></div>
    <div></div>
    <div></div>
    <div></div>
</section>
</tags:header_footer>
</html>