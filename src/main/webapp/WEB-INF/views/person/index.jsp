<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
    <link type="text/css" rel="stylesheet" src="/css/dygraph.css" />
</head>
<body>
	<script type="application/javascript" src="/js/jquery.js"></script>
    <script type="application/javascript" src="/js/bootstrap.js"></script>
    <script type="application/javascript" src="/js/dygraph.js"></script>
    <script type="application/javascript" src="/js/dygraph.min.js"></script>
    
    
    Here comes graph
    <div id="graphdiv2"
  style="width:1500px; height:1000px;"></div>
<script type="text/javascript">
  g2 = new Dygraph(
    document.getElementById("graphdiv2"),
    "temperatures", 
    {}          // options
  );
</script>

    


</body>
</html>