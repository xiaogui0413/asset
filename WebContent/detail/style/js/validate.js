$(function() {
	/*
	 * 1. 得到所有的错误信息，循环遍历之。调用一个方法来确定是否显示错误信息！
	 */
	$(".errorClass").each(function() {
		showError($(this));//遍历每个元素，使用每个元素来调用showError方法
	});
	/*
	 * 2. 表单提交时进行校验
	 */
//	$("#assetsForm").submit(function() {
//		var bool = true;//表示校验通过
//		if(!validateUser()) {
//			bool = false;
//		}
//		if(!validateP_type()) {
//			bool = false;
//		}
//		if(!validateAmount()) {
//			bool = false;
//		}
//		if(!validateModel()) {
//			bool = false;
//		}
//		if(!validatePrice()) {
//			bool = false;
//		}
//		if(!validateConfigration()) {
//			bool = false;
//		}
//		if(!validateSerial_number()) {
//			bool = false;
//		}
//		if(!validateP_status()) {
//			bool = false;
//		}
//		if(!validateNumber()) {
//			bool = false;
//		}
//		if(!validateRemark()) {
//			bool = false;
//		}
//		return bool;
//
//	});

	/*
	 * 3. 输入框得到焦点隐藏错误信息
	 */
	$(".InputStyle").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
		showError($("#" + labelId));//隐藏没有信息的label
	});

	/*
	 * 4. 输入框失去焦点进行校验
	 */
	$(".InputStyle").blur(function() {
		var id = $(this).attr("id");//获取当前输入框的id
		var funName = "validate" + id.substring(0,1).toUpperCase() + id.substring(1) + "()";//得到对应的校验函数名
		eval(funName);//执行函数调用
	});
});

function validateUser() {
	var id = "user";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 2 || value.length > 10) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("姓名长度必须在2 ~ 10之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateP_type() {
	var id = "p_type";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("类型不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("用户名长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateAmount() {
	var id = "amount";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("数量不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}

}

function validateModel() {
	var id = "model";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("型号不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}


function validatePrice() {
	var id = "price";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("价格不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 2 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在2 ~ 10之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateConfigration() {
	var id = "configration";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("配置不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("用户名长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}


function validateSerial_number() {
	var id = "serial_number";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("类型不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateBuy_time() {
	var id = "buy_time";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("类型不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateReceive_time() {
	var id = "receive_time";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("类型不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateP_status() {
	var id = "p_status";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("类型不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateNumber() {
	var id = "number";
	var value = $("#" + id).val();//获取输入框内容
	if(!value) {
		$("#" + id + "Error").text("类型不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	if(value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
}

function validateRemark() {
	var id = "remark";
	var value = $("#" + id).val();//获取输入框内容

	if(value.length > 20) {
		$("#" + id + "Error").text("长度必须在20以下！");
		showError($("#" + id + "Error"));
		false;
	}
}
/*
 * 判断当前元素是否存在内容，如果存在显示，不页面不显示！
 */
function showError(ele) {
	var text = ele.text();//获取元素的内容
	if(!text) {//如果没有内容
		ele.css("display", "none");//隐藏元素
	} else {//如果有内容
		ele.css("display", "");//显示元素
	}
}



