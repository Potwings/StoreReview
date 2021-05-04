<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../reviewincludes/header.jsp"%>
<!DOCTYPE html>

<form class="form-horizontal" action="/member/login" method="POST">


	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">referer</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="referer" value="${referer }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">ID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="mid">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">PW</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" name="mpw">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">로그인</button>
		</div>
	</div>
</form>

<%@ include file="../reviewincludes/footer.jsp"%>