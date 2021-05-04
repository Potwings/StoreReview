<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../reviewincludes/header.jsp" %>
<!DOCTYPE html>
<!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">
        <h1 class="my-4">${review.mid}</h1>
      </div>
      <!-- /.col-lg-3 -->
 <div class="col-lg-9">

        <div class="card mt-4">
          <img class="card-img-top img-fluid" src="/fileView/?name=${review.img}" alt="">
          <div class="card-body">
          
            <h3 class="card-title">${review.context}</h3>
          </div>
        </div>
  <!-- /.card -->

      </div>
      <!-- /.col-lg-9 -->

    </div>

  </div>
  <!-- /.container -->

<%@ include file="../reviewincludes/footer.jsp" %>