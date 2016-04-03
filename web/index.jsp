
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" />

    <div class="head">
      Табуляция функции
    </div>
  </head>
  <body>
  <title>Запрос функций</title>
  <div class="body">
  <form action="funcList" method="get" id="test">
    <input class="button" type="submit" name="test" form="test" value="Получить лист функций">
  </form>
  </div>
  </body>
</html>
