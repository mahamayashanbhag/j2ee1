<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sx:head />
</head>
<body>
<s:form action="BookACar" method="post">
<sx:datetimepicker name="dateOfHire" label="Date Of Hire" displayFormat="dd-MMM-yyyy"/>
<s:select name="carType" label="Car Type" list="{'small','medium','luxury'}"></s:select>
<s:textfield name="customerName" label="Customer Name"/>
<s:textfield name="phoneNumber" label="Phone Number"/>
<s:submit value="Submit"/>
</s:form>
</body>
</html>