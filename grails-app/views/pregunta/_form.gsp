<%@ page import="CarInsurance.Pregunta" %>



<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="pregunta.code.label" default="Code" />
		
	</label>
	<g:textField name="code" value="${preguntaInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'position', 'error')} required">
	<label for="position">
		<g:message code="pregunta.position.label" default="Position" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="position" type="number" value="${preguntaInstance.position}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'question', 'error')} ">
	<label for="question">
		<g:message code="pregunta.question.label" default="Question" />
		
	</label>
	<g:textField name="question" value="${preguntaInstance?.question}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'typeWeight', 'error')} ">
	<label for="typeWeight">
		<g:message code="pregunta.typeWeight.label" default="Type Weight" />
		
	</label>
	
</div>

