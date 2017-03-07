<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Patient details here</title>
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<h2>Edit Patient</h2>
<form action="/hospital/update" method="post">
    <input type="hidden" name="id" value="${patient.id}">
    <table class="table table-bordered">
        <tbody>
         <tr><th>Patient  Name</th><td><input type="text" name="name" required="required" value="${patient.name}"></td></tr>
         <tr><th>Personnel Id</th><td><input type="text" name="ssn" required="required" value="${patient.ssn}"></td></tr>
         <tr><th>Email</th><td><input type="email" name="email" required="required" value="${patient.email}"></td></tr>
         <tr><th>Mobile</th><td><input type="number" name="mobile" required="required" value="${patient.mobile}"></td></tr>
         <tr><th>Doctor</th><td><input type="text" name="doctor" required="required" value="${patient.doctor}"></td></tr>
         <tr><th>Radiograph Description</th><td><input type="text" name="radiographDesc" required="required" value="${patient.radiographDesc}"></td></tr>
         <tr><th>Reason to conduct</th><td><input type="text" name="reasonToConduct" required="required" value="${patient.reasonToConduct}"></td></tr>
        <tr><td colspan="2"><input type="submit" value="Update" class="btn btn-success"></tr>
        </tbody>
    </table>
</form>
<a href="/hospital/index" class="btn btn-success">Back</a>

<script type="application/javascript" src="js/jquery.js"></script>
<script type="application/javascript" src="js/bootstrap.js"></script>


</body>
</html>