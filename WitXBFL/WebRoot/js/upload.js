function addElement(){
	//�õ�����input�����valueֵ
	var index = document.getElementById("hidden").getAttribute("value");
	if(index > 4){
		alert("���ͬʱ�ϴ�4���ļ�");
		return false;
	}
	
	//����һ��input���͵Ľڵ�
	var inputElement = document.createElement("input");
	//�����´����Ľڵ�����ԣ����Ϊfile��nameֵ����
	inputElement.setAttribute("type","file");
	inputElement.setAttribute("name", "file"+index);
	
	//�����ı��ڵ�
	var fontElement = document.createTextNode("ѡ���ļ���");
	//���������ı��ڵ���ӵ�div��
	document.getElementById("upload_div").appendChild(fontElement);
	//��������input���͵Ľڵ���ӵ�div��
	document.getElementById("upload_div").appendChild(inputElement);
	//����һ������
	var brElement = document.createElement("br");
	//��ӵ�div��
	document.getElementById("upload_div").appendChild(brElement);
	//������input�����valueֵ��1
	document.getELementById("hidden").setAttribute("value",parseInt(index) + 1);
}

function deleteElement(){
	//��Ϊadd���������3���ڵ�ѭ����3��
	for(var i = 0; i < 3; i++){
		//ɾ�����һ���ڵ�
		document.getElementById("upload_div").removeChild(document.getElementById("upload_div").lastChild);
	}
	//��������input�����valueֵ��Ϊ1
	document.getElementById("hidden").setAttribute("value", "1");
}