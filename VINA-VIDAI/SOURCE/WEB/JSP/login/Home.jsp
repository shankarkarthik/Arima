<%@ include file="/common/TagLibHeader.jsp" %>
<%@ include file="/common/JQuery.jsp" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value='${styleSheet}'/>"/>
    </head>
    <body>
        <div id="rootContainer">
            <%@ include file="/common/Header.jsp" %>
			<div id="bodyContent">
                <div>
                    <h1>Administer your Quiz</h1>
                    <p>
                        <html:link page="/ProcessCreateQuiz.do">Create Quiz</html:link>
                    </p>
                </div>
			</div>
        </div>
    </body>
</html>