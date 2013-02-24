                <html:form action="${form.processAction}" method="post">
                    <html:errors bundle="vinavidai"/>            
                    <table>
                        <tr>
                            <td>
                                Question {id} Description*
                            </td>
                            <td>
                                <html:textarea name="${form.formName}"
                                               property="questionDescription"
                                               rows="5" 
                                               cols="100"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Question objective
                            </td>
                            <td>
                                <html:textarea name="${form.formName}"
                                    property="questionObjective"
                                    rows="5" 
                                    cols="100"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Question Category*
                            </td>
                            <td>
                                <html:select name="${form.formName}" 
                                    property="selectedQuestionCategory" 
                                    size="1">
                                    <html:option value="">Select Question Category</html:option>
                                    <html:optionsCollection name="${form.formName}" 
                                        property="categories"
                                        label="category" 
                                        value="categoryId"/>                                        
                                </html:select>  
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Skill Level
                            </td>
                            <td>
                                <html:select name="${form.formName}" 
                                    property="selectedQuestionSkillLevel" 
                                    size="1">
                                    <html:option value="">Select Question SkillLevel</html:option>
                                    <html:optionsCollection name="${form.formName}" 
                                        property="skillLevels"
                                        label="skillLevel" 
                                        value="skillLevelId"/>                                        
                                </html:select> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Duration
                            </td>
                            <td>
                                <html:text name="${form.formName}" property="duration" size="5"/>&nbsp;&nbsp;(in minutes)
                            </td>
                        </tr>
                        <tr>
                            <td>Description
                            </td>
                            <td>
                                <textarea rows="3" cols="50"></textarea>
                            </td>
                        </tr>
                    </table>
                </html:form>                    