<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../reviewincludes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Store List Page</h1>

<c:if test="${mid != null }">
	<h1>ID : ${mid }</h1>
</c:if>

<c:forEach items="${stores}" var="store"> 
<div class="card mb-3" style="max-width: 100%;">
  <div class="row g-0">
    <div class="col-md-4">
    <a href='/store/info?sno=${store.sno}'>
      <img src="/upload/store/${store.sno}.jpg" style = "width: 100%; height: 200px; object-fit: cover;"  alt="...">
    </a>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${store.name}</h5>
        <p class="card-text">${store.address}</p>
        <p class="card-text"><small class="text-muted">${store.updateDate}</small></p>
         <p class="card-text"><small class="text-muted">리뷰수 : ${store.rcount}</small></p>
      </div>
    </div>
  </div>
</div>
 </c:forEach>

<ul class="pagination">
	<c:if test="${pageMaker.prev }">
		<li class="page-item"><a class="page-link" href="/store/list?page=${pageMaker.start -1 }" tabindex="-1">Prev</a>
		</li>
	</c:if>

	<c:forEach begin="${pageMaker.start }" end="${pageMaker.end }" var="num">
		<li class="page-item ${num == pageMaker.currentPage ? 'active' : '' }"><a class="page-link" href="/store/list?page=${num }">${num }</a></li>
	</c:forEach>

	<c:if test="${pageMaker.next }">
		<li class="page-item"><a class="page-link" href="/store/list?page=${pageMaker.end +1 }">Next</a></li>
	</c:if>
</ul>

<%@include file="../reviewincludes/footer.jsp"%>