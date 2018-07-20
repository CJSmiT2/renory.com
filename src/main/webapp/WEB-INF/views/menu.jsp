<%-- 
    Document   : menu
    Created on : 28.07.2017, 9:25:50
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<nav class="navbar navbar-default navbar-static">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Renory</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/"><spring:message code="renory.home"/></a></li>
            <li><a href="${pageContext.request.contextPath}/manage/upload_amv"><spring:message code="renory.uploadAmv"/></a></li>
        </ul>
    </div>
  </div>
</nav>
        

