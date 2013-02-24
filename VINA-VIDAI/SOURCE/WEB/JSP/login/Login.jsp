<%@ include file="/common/TagLibHeader.jsp" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value='${styleSheet}'/>"/>
    </head>
    <body>
        <div id="rootContainer">
            <div id="bodyContent">
                <html:form action="${form.processAction}" method="post">
                    <table id="base-table">
                        <tr>g
                            <td>
                                <table id="message-table">
                                    <tr>
                                        <td>
                                        Messages goes here
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                            <html:errors bundle="login"/>
                                <table id="login-table">
                                    <tr>
                                        <td>Existing Users</td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <html:text name="${form.formName}"
                                                property="loginName"
                                                styleId="loginName"
                                                styleClass="loginTextField"/>
                                         </td>
                                    </tr>
                                    <tr>
                                        <td>Password</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <html:password name="${form.formName}"
                                                property="password"
                                                styleId="password"
                                                styleClass="loginTextField"/>                            
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <html:submit 
                                                property="submitAction" 
                                                value="Login"
                                                styleClass="loginButton"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td><a href="../recovery/AccountRecovery.html">Forgot Password?</a></td>
                                    </tr>
                                    <tr>
                                        <td><hr></td>
                                    </tr>
                                    <tr>
                                        <td>New Users</td>
                                    </tr>
                                    <tr>
                                        <td><a href="#">Register Now</a></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </html:form>
            </div>
        </div>
    </body>
</html>