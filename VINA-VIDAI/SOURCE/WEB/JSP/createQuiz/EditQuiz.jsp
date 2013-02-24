<%@ include file="/common/TagLibHeader.jsp" %>
<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="/vinavidai/css/vv-main.css"/>
    	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
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
    	</script>
    </head>
    <body>
        <div id="rootContainer">
			<div id="bodyContent">
				<html:form action="${form.processAction}" method="post">
					<table>
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
								Quiz Duration
							</td>
							<td>
                                <html:text name="${form.formName}" 
                                    property="quizDuraion"
                                    styleId="quizDuration"/>								
                                &nbsp;(In secs)
							</td>
						</tr>
						<tr>
							<td>
								Response Duration Per Question
							</td>
							<td>
                                <html:text name="${form.formName}" 
                                    property="questionDuration"
                                    styleId="questionDuration"/>
                                &nbsp;(In secs)
							</td>
						</tr>
						<tr>
							<td>Category for Questions*
							</td>
							<td>
								<input type="text" name="questionCategoryTxt" id="questionCategoryTxt">
								<input type="button" name="" value="+" onclick="addCategory();"/>
								<input type="button" name="" value="-" onclick="removeCategory();"/>
								<select multiple="multiple" size="2" name="questionCategory" id="questionCategory">
                                  <option value="Servlet General">Servlet General</option>
                                  <option value="Session Management">Session Management</option>
                                  <option value="Request/Response">Request/Response</option>
								  <option value="Filters">Filters</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Skill Levels*
							</td>
							<td>
								<input type="text" name="skillLevelTxt" id="skillLevelTxt"/>
								<input type="button" name="" value="+" onclick="addSkill();"/>
								<input type="button" name="" value="-" onclick="removeSkill();"/>
								<select multiple="multiple" size="2" name="skillLevel" id="skillLevel">
								  <option value="volvo">Beginner</option>
								  <option value="saab">Intermediate</option>
								  <option value="mercedes">Advanced</option>
								  <option value="audi">Expert</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Option List Style
							</td>
							<td>
                                <html:select name="{form.formName}" 
                                    property="tradingPartnerType" 
                                    size="1">
                                    <html:optionsCollection name="{form.formName}" 
                                        property="listStyle"
                                        label="type" 
                                        value="typeId"/> 
                                </html:select>                            
								<select name="optionListStyle">
								  <option value="Numeric">1 2 3 ...</option>
								  <option value="AlphaUpper">A B C ...</option>
								  <option value="AlphaLower">a b c ...</option>
								  <option value="RomanUpper">I II III IV V</option>
								  <option value="RomanLower">i ii iii iv v</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Option Display Style
							</td>
							<td>
								<select name="optionDisplayStyle">
								  <option value="SquareBraces">[1] [b]</option>
								  <option value="CloseBraces">1) B)</option>
								  <option value="Dot">1. I. iv.</option>
								</select>
							</td>
						</tr>
					</table>
					<div id="formSubmit">
						<html:submit name="submitAction" 
                            value="Next"/>
					</div>
				</html:form>
			</div>
        </div>
    </body>
</html>