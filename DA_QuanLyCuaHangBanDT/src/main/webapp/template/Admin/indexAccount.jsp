<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/template/Admin/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Account</title>
<%@ include file="/template/Admin/common/head.jsp" %>
</head>
<body>
	<!-- ======= Header ======= -->
    <%@ include file="/template/Admin/common/header.jsp" %>
  
  <!-- ======= Sidebar ======= -->
  <%@ include file="/template/Admin/common/sidebar.jsp" %>
  
	<jsp:include page="formAccount.jsp" />
	<hr>
	<jsp:include page="account.jsp" />
	
	<!-- ======= Footer ======= -->
   <%@ include file="/template/Admin/common/footer.jsp" %>

    <!-- JS Files -->
    <%@ include file="/template/Admin/common/jsfile.jsp" %>
</body>
</html>