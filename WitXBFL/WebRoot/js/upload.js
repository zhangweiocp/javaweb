function addElement(){
	//得到隐藏input里面的value值
	var index = document.getElementById("hidden").getAttribute("value");
	if(index > 4){
		alert("最大同时上传4个文件");
		return false;
	}
	
	//创建一个input类型的节点
	var inputElement = document.createElement("input");
	//设置新创建的节点的属性，类别为file，name值递增
	inputElement.setAttribute("type","file");
	inputElement.setAttribute("name", "file"+index);
	
	//创建文本节点
	var fontElement = document.createTextNode("选择文件：");
	//将创建的文本节点添加到div中
	document.getElementById("upload_div").appendChild(fontElement);
	//将创建的input类型的节点添加到div中
	document.getElementById("upload_div").appendChild(inputElement);
	//创建一个换行
	var brElement = document.createElement("br");
	//添加到div中
	document.getElementById("upload_div").appendChild(brElement);
	//将隐藏input里面的value值加1
	document.getELementById("hidden").setAttribute("value",parseInt(index) + 1);
}

function deleteElement(){
	//因为add方法添加了3个节点循环了3次
	for(var i = 0; i < 3; i++){
		//删除最后一个节点
		document.getElementById("upload_div").removeChild(document.getElementById("upload_div").lastChild);
	}
	//将隐藏在input里面的value值设为1
	document.getElementById("hidden").setAttribute("value", "1");
}