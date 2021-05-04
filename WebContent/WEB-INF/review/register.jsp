<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../reviewincludes/header.jsp"%>

<!DOCTYPE html>
<form class="form-horizontal" action="/review/register" method="POST" enctype="multipart/form-data">

	<div class="form-group">
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="sno" value="${sno }">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="mid" value="${mid}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">CONTEXT</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="context">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">IMAGE</label>
		<div class="col-sm-10">
		<input type = "file" name="file" multiple>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">SCORE</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" name="score">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">등록</button>
		</div>
	</div>
</form>
<%@ include file="../reviewincludes/footer.jsp"%>