<%@ include file="/common/TagLibHeader.jsp" %>
<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="main.css" />
    </head>
    <body>
        <div id="rootContainer">
			<div id="bodyContent">
				<form action="" method="post">
					<table>
						<tr>
							<td>
								Quiz Name*
							</td>
							<td>
								<input type="text" name="quizName" size="50"/>
							</td>
						</tr>
						<tr>
							<td>
								Response Duration Per Question
							</td>
							<td>
								<input type="text" name="durationPerQuestion"/>&nbsp;(In secs)
							</td>
						</tr>
						<tr>
							<td>Category for Questions*
							</td>
							<td>
								<input type="text" name="questionCategories">
								<input type="button" name="" value="+"/>
								<input type="button" name="" value="-"/>
								<select multiple="multiple" size="2">
								  <option value="volvo">Volvo</option>
								  <option value="saab">Saab</option>
								  <option value="mercedes">Mercedes</option>
								  <option value="audi">Audi</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Skill Levels*
							</td>
							<td>
								<input type="text" name="skillLevel"/>
								<input type="button" name="" value="+"/>
								<input type="button" name="" value="-"/>
								<select multiple="multiple" size="2">
								  <option value="volvo">Volvo</option>
								  <option value="saab">Saab</option>
								  <option value="mercedes">Mercedes</option>
								  <option value="audi">Audi</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Question Ids
							</td>
							<td>
								<select>
								  <option value="Numeric">1 2 3 ...</option>
								  <option value="AlphaUpper">A B C ...</option>
								  <option value="AlphaLower">a b c ...</option>
								  <option value="RomanUpper">I II III IV V</option>
								  <option value="RomanLower">i ii iii iv v</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Question Id Display Style
							</td>
							<td>
								<select>
								  <option value="SquareBraces">[1] [b]</option>
								  <option value="CloseBraces">1) B)</option>
								  <option value="Dot">1. I. iv.</option>
								</select>
							</td>
						</tr>
					</table>
					<div id="formSubmit">
						<input type="submit" name="Next" value="Next">
					</div>
				</form>
			</div>
        </div>
    </body>
</html>