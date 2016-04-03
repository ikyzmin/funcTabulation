<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 03.04.2016
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css"/>
    <div class="head">
        Табуляция функции <%=request.getAttribute("functionName")%>
    </div>
</head>
<body>
<div class="body">
    <table class="tabulation" width="25%" border="1">
        <tr class="tabulation">
            <td class="tabulation">
                Функция <%=request.getAttribute("functionName")%>
            </td>
            <td class="tabulation">
                Значение
            </td>
        </tr>
        <%
            String[] tabulation = (String[]) request.getAttribute("tabulation");
            String[] values = (String[]) request.getAttribute("values");
            for (int i = 0; i < tabulation.length; i++) {
                if (tabulation[i]!=null) {
        %>

        <tr class="tabulation">
            <td class="tabulation"><%=tabulation[i]%>
            </td>
            <td class="tabulation">
                <%= values[i]%>
            </td>
            <%
                    }
                }
            %>
        </tr>
    </table>
</div>
</body>
</html>
