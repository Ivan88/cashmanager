<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Money Manager 1.0 - Expenses history</title>
<link href="includes/monman.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="85%" border="1" align="center" cellpadding="0"
	cellspacing="0">
<tr>
	<td>
	<table width="100%" border="0" align="center" cellpadding="4"
		cellspacing="0" bordercolor="#CCCCCC">
        <tr bgcolor="#C2DCEB" valign="middle">
			<td width="90%" height="60" valign="middle" bgcolor="#C2DCEB">
			<h1>Expenses history items list</h1>
			</td>
	        <td align="right" nowrap="nowrap"><a href="signout.htm">Sign out</a></td>
		</tr>
		<tr>
			<td colspan="2">
			<p align="center"><!-- status messages --> <c:if
			test="${not empty message}">
			<font color="green"><c:out value="${message}" /></font>
			<c:set var="message" value="" scope="session" />
		</c:if></p>
		<p align="center"><a href="enterexpenses.htm">Click here</a> to add a
		new expenses history item, or select one from the list below.</p>
			<table border="1" align="center" cellpadding="8" cellspacing="0">
				<tr>
					<th>Expenses item</th>
					<th>Amount</th>
					<th>Date</th>
				</tr>
				<c:forEach items="${expenseshistory}" var="expenseshistory">
					<tr>
						<td align="center">
						
						<div></div>
						</td>
						<td align="center"><c:out value="${expenseshistory.amount} }"/></td>
						<td align="center"><div></div></td>
						<td align="center"><div></div></td>
					</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
	</table>
	</td>
</tr>
</table>

</body>
</html>
