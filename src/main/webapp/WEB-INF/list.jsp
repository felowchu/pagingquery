<%--
  Created by IntelliJ IDEA.
  User: bestchu
  Date: 2017/7/16
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" isELIgnored="false" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>分页查询数据</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
    <table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>密码</td>
        </tr>
        <c:choose>
            <c:when test="${not empty requestScope.pageBean.pageDate}">
                <c:forEach var="admin" items="${requestScope.pageBean.pageDate}" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${admin.name}</td>
                        <td>${admin.password}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="3">
                        对不起,没有你要的数据
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="3" align="center">
                当前${requestScope.pageBean.currentPage}/${requestScope.pageBean.totalPage}页 &nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/admin?currentPage=1">首页</a>
                <a href="${pageContext.request.contextPath}/admin?currentPage=${requestScope.pageBean.currentPage-1}">上一页</a>
                <a href="${pageContext.request.contextPath}/admin?currentPage=${requestScope.pageBean.currentPage+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/admin?currentPage=${requestScope.pageBean.totalPage}">末页</a>
            </td>
        </tr>
    </table>
</body>
</html>
