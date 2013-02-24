<%@ include file="/common/TagLibHeader.jsp" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value='${styleSheet}'/>"/>
    </head>
    <body>
        <div id="rootContainer">
            <div id="bodyContent">
                <html:form action="${form.processAction}" method="post">
                    <h1>Password Reset</h1>
                    <p>
                        Select your new password and enter it below.
                    </p>
                    <table>
                        <tr>
                        	<td><strong>New Password:</strong></td>
                        	<td><input type="text" name="password"/><br><span class="helperText">Minimum 8 characters length</span></td>
                       	</tr>
                        <tr>
                        	<td><strong>Re-enter password:</strong></td>
                        	<td><input type="text" name="confirmPassword"/></td>
                        </tr>
                        <tr>
                        	<td>&nbsp</td>
                        	<td><button type="submit" name="Reset Password" value="Reset Password">Reset Password</button></td>
                        </tr>
                    </table>
                </html:form>
            </div>
        </div>
    </body>
</html>