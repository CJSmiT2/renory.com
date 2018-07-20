<%-- 
    Document   : upload_amv
    Created on : 20.07.2018, 11:15:00
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="renory.uploadAmv"/></title>
        <jsp:include page="../headLinks.jsp" />
    </head>
    <body>
        <jsp:include page="../menu.jsp" />
        
        <h2 class="text-center"><spring:message code="renory.uploadAmvSelectMode"/></h2>
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <a href="upload_amv_simple_mod" class="btn btn-primary btn-lg btn-block">
                    <spring:message code="renory.uploadAmvSimpleMode"/> <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
                <a href="" class="btn btn-primary btn-lg btn-block">
                    <spring:message code="renory.uploadAmvAdvancedMode"/> <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
            <div class="col-sm-4"></div>
        </div>
    </body>
</html>
