<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="ruleForm" commandName="rule" method="post"
	action="${actionUrl }" class="form-horizontal">

	<div class="form-group">
		<label for="name" class="col-xs-4 control-label">Name</label>
		<div class="col-xs-8">
			<form:input name="customerId" path="name" placeholder="Rule Name"
				class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="conf1" class="col-xs-4 control-label">Configuration1</label>
		<div class="col-xs-8">
			<form:input name="merocode" id="merocode" path="conf1"
				placeholder="Configuration1" maxlength="15" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="conf2" class="col-xs-4 control-label">Configuration2</label>
		<div class="col-xs-8">
			<form:input path="conf2" placeholder="Configuration2" maxlength="10"
				class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="conf3" class="col-xs-4 control-label">Configuration3</label>
		<div class="col-xs-8">
			<form:input path="conf3" placeholder="Configuration3" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="publishedOn" class="col-xs-4 control-label">Published
			On</label>
		<div class="col-xs-8">
			<form:input path="publishedOn" placeholder="YYYY-MM-DD"
				class="datepicker form-control" />
		</div>
	</div>

	<form:input path="id" type="hidden" />
</form:form>