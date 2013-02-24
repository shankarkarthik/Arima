<%@ include file="/common/TagLibHeader.jsp" %>
<%@ include file="/common/JQuery.jsp"%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value='${styleSheet}'/>" />
        <script type="text/javascript">        
            $(function() {
                $("#tabs").tabs().addClass('ui-tabs-vertical ui-helper-clearfix');
                $("#tabs li").removeClass('ui-corner-top').addClass('ui-corner-left');
                //$( "#tabs" ).tabs();
            });
        </script>
        <style type="text/css">    
            /* Vertical Tabs */ 
            #tabs { 
                width:auto;
                
            } 
            .ui-tabs-vertical { 
                width: 55em;
            }
            .ui-tabs-vertical .ui-tabs-nav { 
                padding: .2em .1em .2em .2em; 
                float: left; 
                width: 12em; 
                vertical-align:middle;
            }
            .ui-tabs-vertical .ui-tabs-nav li { 
                clear: left; 
                width: 100%;
                height: 10%;  
                border-bottom-width: 1px !important; 
                border-right-width: 0 !important; 
                margin: 0 -1px .2em 0;
                /* added */
                vertical-align:middle; 
            }
            .ui-tabs-vertical .ui-tabs-nav li a { 
                display:block; 
                vertical-align:middle;
            }
            .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-selected { 
                padding-bottom: 0; 
                padding-right: .1em; 
                border-right-width: 1px; 
                border-right-width: 1px; 
            }
            .ui-tabs-vertical .ui-tabs-panel { 
                padding: 1em;
                /* added */
                display:inline; 
                /*float: right;*/ 
                width: 40em;
            }            
        </style>
    </head>
    <body>
        <div id="rootContainer">
            <div id="bodyContent" style="width:100%;display:inline;">
                <%@ include file="/common/Header.jsp" %>
                    <div id="tabs">
                        <ul>
                            <li><a href="#MultipleChoice">Multiple Choice</a></li>
                            <li><a href="#TrueOrFalse">True or False</a></li>
                            <li><a href="#FillInTheBlanks">Fill in the blanks</a></li>
                            <li><a href="#WordList">WordList</a></li>
                            <li><a href="#Matching">Matching</a></li>
                            <li><a href="#Ordering">Ordering</a></li>
                            <li><a href="#Descriptive">Descriptive</a></li>
                        </ul>                        
                        <div id="MultipleChoice">
                            <%@ include file="/createQuiz/MultipleChoiceQuestion.jsp"%>
                        </div>
                        <div id="TrueOrFalse">
                            <%@ include file="/createQuiz/TrueOrFalseQuestion.jsp"%>
                        </div>
                        <div id="FillInTheBlanks">
                            <%@ include file="/createQuiz/FillInTheBlanksQuestion.jsp"%>
                        </div>
                        <div id="WordList">
                            <%@ include file="/createQuiz/DescriptiveQuestion.jsp"%>
                        </div>
                        <div id="Matching">
                            <%@ include file="/createQuiz/DescriptiveQuestion.jsp"%>
                        </div>
                        <div id="Ordering">
                            <%@ include file="/createQuiz/DescriptiveQuestion.jsp"%>
                        </div>
                        <div id="Descriptive">
                            <%@ include file="/createQuiz/DescriptiveQuestion.jsp"%>
                        </div>
                    </div>
                    <div id="formSubmit">
                        <html:submit property="submitAction" value="Next" styleClass="ui-button"/>&nbsp;
                        <html:submit property="submitAction" value="Complete" styleClass="ui-button"/>&nbsp;&nbsp;&nbsp;
                        <html:submit property="submitAction" value="Cancel" styleClass="ui-button"/>                    
                    </div>                    
            </div>
        </div>
    </body>
</html>