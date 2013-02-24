<%@ include file="/common/TagLibHeader.jsp" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value='${styleSheet}'/>"/>
        <link rel="stylesheet" type="text/css" href="css/pepper-grinder/jquery-ui-1.8.16.custom.css"/>
        <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
        <script type="text/javascript">
            function addSkill(){
                newSkillLevel = $('#skillLevelTxt').val();
                $('#skillLevel').append(new Option(newSkillLevel, newSkillLevel, false, false));
            }
            function removeSkill(){
                $("#skillLevel option:selected").remove();
            }
            function addCategory(){
                newQuestionCategory = $('#questionCategoryTxt').val();
                $('#questionCategory').append(new Option(newQuestionCategory, newQuestionCategory, false, false));
            }
            function removeCategory(){
                $("#questionCategory option:selected").remove();
            }
            $(document).ready(function() {
                $("input#quizGroup").autocomplete({
                    source: ["c++", "java", "php", "coldfusion", "javascript", "asp", "ruby","group"]
                });
             });
        </script>
    </head>
    <body>
        <div id="rootContainer">
            <div id="bodyContent">
                <%@ include file="/common/Header.jsp" %>                
                <html:form action="${form.processAction}" method="post" onsubmit="return selectCategoriesAndSkillLevels()">
                <html:errors bundle="vinavidai"/>
                    <table id="formTable">
                        <tr>
                            <td>
                                Quiz Name*
                            </td>
                            <td>
                                <html:text name="${form.formName}" 
                                    property="quizName"
                                    styleId="quizName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Quiz Description*
                            </td>
                            <td>
                                <html:textarea name="${form.formName}" 
                                    property="quizDescription"
                                    styleId="quizDescription"/>                        
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Quiz Duration*
                            </td>
                            <td>
                                <label><input type="radio" name="quizDurationType" value="Timed"/>Timed</label>&nbsp;
                                Hours:
                                <select name="fixedDurationHours">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="24">24</option>
                                </select>&nbsp;
                                Minutes:
                                <select name="fixedDurationHours">
                                    <option value="0">0</option>
                                    <option value="59">59</option>
                                    <option value="60">60</option>
                                </select>
                                <br/>
                                <label><input type="radio" name="quizDurationType" value="Indefinite" checked="true"/>Indefinite</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Quiz Group
                            </td>
                            <td>
                                <input type="text" name="quizGroup" id="quizGroup"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Quiz Access Time*
                            </td>
                            <td>
                                <label><input type="radio" name="quizAccessTime" value="Timed"/>Timed</label>&nbsp;
                                Start Time:<input type="text" name="startTime" size="10">
                                End Time:<input type="text" name="endTime" size="10">
                                <br/>
                                <label><input type="radio" name="quizAccessTime" value="Any Time" checked/>Any Time</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Response Duration Per Question
                            </td>
                            <td>
                                Hours:
                                <html:select name="${form.formName}"
                                    property="responseDurationPerQuestionHours"
                                    styleId="responseDurationPerQuestionHours">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="24">24</option>
                                </html:select>&nbsp;
                                Minutes:
                                <html:select name="${form.formName}"
                                    property="responseDurationPerQuestionMinutes"
                                    styleId="responseDurationPerQuestionMinutes">
                                    <option value="0">0</option>
                                    <option value="59">59</option>
                                    <option value="60">60</option>
                                </html:select>&nbsp;
                                Seconds:
                                <html:select name="${form.formName}"
                                    property="responseDurationPerQuestionSeconds"
                                    styleId="responseDurationPerQuestionSeconds">
                                    <option value="0">0</option>
                                    <option value="59">59</option>
                                    <option value="60">60</option>
                                </html:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Pass Percentile
                            </td>
                            <td>
                                <html:text name="${form.formName}"
                                    property="passPercentile"
                                    styleId="passPercentile"/>&nbsp;(defaults to 60%)
                            </td>
                        </tr>
                        <tr>
                            <td>Category for Questions*
                            </td>
                            <td>
                                <input type="text" name="questionCategoryTxt" id="questionCategoryTxt">
                                <input type="button" name="addCategoryButton" value="+" onclick="addCategory();"/>
                                <input type="button" name="removeCategoryButton" value="-" onclick="removeCategory();"/>
                                <logic:notEmpty name="${form.formName}" property="categories">
                                <html:select name="${form.formName}"
                                    property="categories"
                                    multiple="multiple" 
                                    size="5"
                                    styleId="categories">
                                    <html:options name="${form.formName}" property="categories"/>
                                </html:select>                              
                                </logic:notEmpty>
                                <logic:empty name="${form.formName}" property="categories">
                                    <html:select name="${form.formName}"
                                        property="categories"
                                        multiple="multiple" 
                                        size="5"
                                        styleId="categories">
                                    </html:select>                                
                                </logic:empty>
                            </td>
                        </tr>
                        <tr>
                            <td>Skill Levels*
                            </td>
                            <td>
                                <input type="text" name="skillLevelTxt" id="skillLevelTxt"/>
                                <input type="button" name="addSkillLevel" value="+" onclick="addSkill();"/>
                                <input type="button" name="removeSkillLevel" value="-" onclick="removeSkill();"/>
                                <logic:notEmpty name="${form.formName}" property="skillLevels">
                                    <html:select name="${form.formName}"
                                        property="skillLevels"
                                        styleId="skillLevels"
                                        multiple="multiple" 
                                        size="5">
                                        <html:options name="${form.formName}" property="skillLevels"/>
                                   </html:select>
                                </logic:notEmpty>      
                                <logic:empty name="${form.formName}" property="skillLevels">
                                    <html:select name="${form.formName}"
                                        property="skillLevels"
                                        styleId="skillLevels"
                                        multiple="multiple" 
                                        size="5">
                                    </html:select>
                                </logic:empty>
                            </td>
                        </tr>
                        <tr>
                            <td>Option List Style
                            </td>
                            <td>
                                <html:select name="${form.formName}" 
                                    property="selectedListStyle" 
                                    size="1">
                                    <html:options name="${form.formName}" 
                                        property="listStyleSet"/> 
                                </html:select>  
                            </td>
                        </tr>
                        <tr>
                            <td>Option Display Style
                            </td>
                            <td>
                                <html:select name="${form.formName}" 
                                    property="selectedDisplayStyle" 
                                    size="1">
                                    <html:options name="${form.formName}" 
                                        property="displayStyleSet"/> 
                                </html:select>
                            </td>
                        </tr>
                    </table>
                    <div id="formSubmit">
                        <html:submit property="submitAction" value="Next" styleClass="submitButton"/>
                    </div>
                </html:form>
            </div>
        </div>
    </body>
</html>