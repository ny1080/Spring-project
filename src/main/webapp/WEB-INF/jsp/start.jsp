<%@ page language="java" session="false" isErrorPage="false"
	pageEncoding="euc-kr"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>����ڷ��</title>

<script type="text/javascript">
	/* function winClose() {
		self.close();
		window.close(); 
		} */
	function doOnload(url, name, width, height) {
		window
				.open(
						url,
						name,
						"width="
								+ width
								+ ",height="
								+ height
								+ ",status=no,toolbar=no,menubar=no,scrollbars=yes,location=no");
	}
</script>
</head>

<body onload="doOnload('index', 'login', 1500, 840); window.close();">
	<div class="left">
		<h2>�α��� ������</h2>
	</div>
	<div id="insertForm" class=" col-xs-12 col-sm-12">
		<div class="panel panel-default ">
			<form action="/" method="post" class="panel-body"
				enctype="multipart/form-data" name="insertForm">
				<input type="hidden" id="type" value="isbn"> 
				<div class="form-group">
					<label for="exampleInputEmail1">���̵�</label> <input type="text"
						class="form-control" id="id" name="id"
						required="required">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">��й�ȣ</label> <input type="password"
						class="form-control" id="password" name="password" placeholder="������"
						required="required">
				</div> 
				<div class="col-md-12 col-sm-12 col-xs-12">
					<button type="submit" class="btn btn-default"
						onClick="formChk(); opener.focus(); self.close(); ">Ȯ��</button>
				</div>
			</form>
		</div>

	</div>



</body>
</html>