function addRule() {
	$('#ruleDialog').dialog("option", "title", 'Add Rule');
	$('#ruleDialog').dialog('open');
}

function editRule(id) {

	$.get("get/" + id, function(result) {

		$("#ruleDialog").html(result);

		$('#ruleDialog').dialog("option", "title", 'Edit Rule');

		$("#ruleDialog").dialog('open');

		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#ruleDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#ruleForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ruleForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
