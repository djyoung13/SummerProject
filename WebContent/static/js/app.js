$("#printMenu").click(function(){
	$.ajax({
		type: 'GET',
		dataType: "text/html",
		url:"/SummerProject/all",
	success: function(data){
		$("responseHeader").html(data.responseText);
	},
	error: function(data, status, xhr){
		$("#responseHeader").html(data.responseText);
	},
	});
});

$("#placeOrder").click(function(){
	var iID = $("#itemID").val();
	var cName = $("customerName").val();
	var cAddress = $("#customerAddress").val();
	var cType = $("custCardType").val();
	var cNum = $("custCardNum").val();
	var sCode = $("custSecCode").val();
	var data = {
				item:iID,
				custName:cName,
				custAddress:cAddress,
				cardType:cType,
				cardNumber:cNum,
				securityCode:sCode
	};
	$.ajax({
		type: 'POST',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType: "text/html",
		url:"SummerProject/order",
		data:data,
		success: function(data){
			$("#responseHeader").html(data.responseText);
		},
		error: function(data,status,xhr){
			$("#responseHeader").html(data.responseText);
		},
	});
});
