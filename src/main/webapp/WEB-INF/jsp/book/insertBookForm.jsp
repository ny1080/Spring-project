<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>도서 추가 페이지</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/common.css" rel="stylesheet">
<script src="/resources/js/jquery/jquery.js"></script>
</head>
<body>
	<div class="container">
		<div class="left">
			<h2>도서 추가 페이지</h2>
		</div>
		<div id="insertForm" class=" col-xs-12 col-sm-12">
			<div class="panel panel-default ">
				<form action="/insertbook" method="post" class="panel-body"
					enctype="multipart/form-data" name="insertForm">
					<input type="hidden" id="type" value="isbn">
					<div class="form-group">
						<label style="width:10%;" for="exampleInputEmail1">ISBN</label> 
						<input style="width:70%; display:-webkit-inline-box;"
							 class="form-control" type="text" id="isbn"
							name="isbn" required="required">
					<button style="width:10%" class="btn btn-default" type="submit" id="getBookFromISBN">
						<span class="glyphicon glyphicon-search"></span>
					</button>

					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">도서번호</label> <input type="text"
							class="form-control" id="bookCode" name="bookCode"
							required="required">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">도서명</label> <input type="text"
							class="form-control" id="title" name="title" placeholder="도서명"
							required="required">
					</div>
					<div class="col-md-7 col-sm-7	col-xs-7 left">
						<label for="exampleInputPassword1">대분류</label> <select
							class="selectpicker form-control"
							style="font-size: 14px; margin-top: 10px; vertical-align: baseline;"
							id="group1" name="group1">
							<c:forEach items="${BCodeList}" var="code">
								<option value="${code.code}-${code.desc}">${code.code}-${code.desc}
							</c:forEach>
						</select>
					</div>
					<div class="col-md-5 col-sm-5	col-xs-5 right">
						<label for="exampleInputPassword1">소분류</label> <select
							class="selectpicker form-control"
							style="font-size: 14px; margin-top: 10px; vertical-align: baseline;"
							id="group2" name="group2">
							<c:forEach items="${CCodeList}" var="code">
								<option value="${code.code}-${code.desc}">${code.code}-${code.desc}
							</c:forEach>
						</select>
					</div>
					<div class="col-md-6 col-sm-6	col-xs-6">
						<label for="exampleInputPassword1">출판사</label> <input type="text"
							class="form-control" id="publish" name="publish"
							placeholder="출판사" required="required">
					</div>
					<div class="col-md-6 col-sm-6	col-xs-6">
						<label for="exampleInputPassword1">저자</label> <input type="text"
							class="form-control" id="author" name="author" placeholder="저자">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">요약</label> <input type="text"
							class="form-control" id="summary" name="summary" placeholder="요약">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">가격</label><input type="number"
							class="form-control" name="price" id="price" placeholder="0"
							required="required">
					</div>
					<div class="form-group file">
						<label for="exampleInputPassword1">파일</label> <input type="file"
							class="form-control" id="file" name="file" placeholder="파일">
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button type="submit" class="btn btn-default"
							onClick="formChk(); opener.focus(); self.close(); ">확인</button>
					</div>
				</form>
			</div>
		</div> 
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.file').hide();
		});
		function formChk() {
			var bookCode = $('#bookCode').val();
			var title = $('#title').val();
			var isbn = $('#isbn').val();
			var author = $('#author').val();
			var publish = $('#publish').val();
			var price = $('#price').val(); 

			if (bookCode == '') {
				alert('도서번호을 입력하시기 바랍니다.');
				bookCode.focus();
				return false;
			} else if (title == '') {
				alert('도서명을 입력하시기 바랍니다.');
				title.focus();
				return false;
			} else if (author == '') {
				alert('저자를 입력하시기 바랍니다.');
				author.focus();
				return false;
			} else if (publish == '') {
				alert('출판사를 입력하시기 바랍니다.');
				publish.focus();
				return false;
			} else if (price == '') {
				alert('가격을 입력하시기 바랍니다.');
				price.focus();
				return false;
			} else {
				document.requestForm.submit();
				return true;
			}
		}
		$('#group1').change(
				function() {
					var bookCode = this.value.substr(0, 1)
							+ $('#group2').val().substr(0, 3) + '-';
					$('#bookCode').val(bookCode);
					$('#bookCode').focus();
					if ($('#group1').val().substr(0, 1) == "F") {
						$('.file').show();
					} else {
						$('.file').hide();
					}
				})
		$('#group2').change(
				function() {
					var bookCode = $('#group1').val().substr(0, 1)
							+ this.value.substr(0, 3) + '-';
					$('#bookCode').val(bookCode);
					$('#bookCode').focus();
				})
	</script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/jquery/jquery.js"></script>
	<script src="/resources/js/common.js"></script>
	<script src="/resources/js/book.js"></script>
</body>
</html>