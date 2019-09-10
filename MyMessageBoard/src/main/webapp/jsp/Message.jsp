<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板界面</title>
<link rel="stylesheet" href="../css/message.css">
<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="../js/message.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
</head>
<body>
<!-- 下面语句是获取当前项目名称 -->
<%-- <%=this.getServletContext().getContextPath() %><br/> --%>
<a href="../retnLongin">安全退出</a><br/>
<h3><input type="button" value="发布信息" id="deploye"></h3>
留言信息：
<table width="500px">
<tr><td>发送人</td><td>发送时间</td><td>接收人</td><td>信息内容</td></tr>
<c:forEach var="Message"  items="${showInfo}">
<tr><td>${Message.senderId }</td><td>${ Message.messageTime}</td><td>${Message.getterId }</td><td>${Message.conetent }</td></tr>
</c:forEach>
</table>


<!-- 幕布 -->
<div class="fubull"></div>

<!-- 添加界面 -->
<div class="addView">
<div class="addCont">
接收人： <input type="text" name="receve" id="receve"><br/>
发送内容<input type="text" name="send" id="sendContext"><br/>

<div class="Butn">
<input type="button" value="发布" id="deploy"> 
<input type="button" value="取消" id="cancel" >
</div>
</div>
</div>




</body>
</html>