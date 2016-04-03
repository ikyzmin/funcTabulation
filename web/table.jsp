<%@ page import="func.Functions" %><%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 03.04.2016
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css"/>
    <div class="head">
        Табуляция функции
    </div>
</head>
<body>
<div class="body">
    <table class="tabulation" width="25%" border="1">
        <%
            Functions functions = (Functions) request.getAttribute("functions");

            for (int i = 0; i < functions.getLength(); i++) {
        %>
        <tr class="tabulation">
            <td class="tabulation"><%=i + 1%>.</td>
            <td class="tabulation">
                <%= functions.getFunctionNameAtIndex(i)%>
            </td>
            <%
                }
            %>
        </tr>
    </table>
    <form action="tabulation" id="tabulation" method="post">
        <table class="input">
            <tr>
                <td>
                    <p class="text">Выберите номер функции</p>
                </td>
                <td>
                    <select name="index" form="tabulation" class="styled-select blue">
                        <%
                            for (int i = 0; i < functions.getLength(); i++) {
                        %>
                        <option><%=i + 1%>
                        </option>
                        <%}%>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <p class="text">Нижняя граница:</p>
                </td>
                <td>
                    <input type="text" class="textField" name="min" form="tabulation">
                </td>
            </tr>
            <tr>
                <td>
                    <p class="text"> Верхняя граница:</p>
                </td>
                <td>
                    <input type="text" class="textField" name="max" form="tabulation">
                </td>
            </tr>
            <tr>
                <td>
                    <p class="text">Шаг:</p>
                </td>
                <td>
                    <input type="text" class="textField" name="delta" form="tabulation">
                </td>
            </tr>
            <tr>
                <td>
                    <input class="button" type="submit" form="tabulation" value="Табулировать">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
