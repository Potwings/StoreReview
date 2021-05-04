<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../reviewincludes/header.jsp"%>
<!-- Page Content -->

<!-- <style>				
.body {
	display: flex;
	flex-direction: row;
}
.context{
	display: flex;
	flex-direction: column;
}
.button{
	display:flex;
	flex-direction: row;
}
.pagination{
	height: 50px;
}
</style> -->
<style>
.info{
display:flex; 
flex-direction: column;
}
</style>

<div class="container">

	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">다운타우너 청담</h1>
		</div>
		<div class="col-lg-9">
			<div class="card mt-4">
				<div class="info">
					<img class="card-img-top img-fluid" style="margin: 20px; width: 400px; height: 400px;"
						src="/upload/store/32.jpg" alt="">
					<div>
						<div id="map" style="position:absolute; top: 20px; left:550px; width: 30%; height: 60vh;"></div>
					</div>
					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35443228fbad24b446253c354d0474b7"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div
						mapOption = {
							center : new kakao.maps.LatLng(37.523966,
									127.038557), // 지도의 중심좌표
							level : 3
						// 지도의 확대 레벨
						};

						// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
						var map = new kakao.maps.Map(mapContainer, mapOption);
					</script>


					<script>
						var markerPosition = new kakao.maps.LatLng(37.523966,
								127.038557);

						// 마커를 생성합니다
						var marker = new kakao.maps.Marker({
							position : markerPosition

						});

						// 마커가 지도 위에 표시되도록 설정합니다
						marker.setMap(map);

						var infowindow = new kakao.maps.InfoWindow({
							content : '다운타우너 청담' // 인포윈도우에 표시할 내용
						});

						(function(info, mk) {
							kakao.maps.event.addListener(mk, 'click',
									function() {
										info.open(map, mk);
									})

						})(infowindow, marker);
					</script>
					<div class="card-body">
						<h3 class="card-title">다운타우너 청담</h3>
						<h5>Downtown(도시 혹은 시내)에서 유래한 'Downtowner'는 이름에서 느낄 수 있듯 바쁜 도시인들이 빠르고 편하게 즐겨 먹을 수 있는 고품질의 Fast & Premium 수제 버거를 판매하고 있습니다.  또한 다양한 수제 맥주 라인업과 함께 준비되어 있는 후라이 및 치킨 메뉴는 간단한 식사 및 맥주 안주로 즐기실 수 있습니다. 언제든지 방문하시어 맛있는 버거를 즐겨보세요.</h5>
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Product Reviews</div>
					<c:forEach items="${reviews}" var="review">
						<div class="body">
							<a href="/review/view?rno=${review.rno}"> <img
								src="/upload/store/241.jpg'"
								style="width: 200px; height: 200px; object-fit: cover;"
								alt="...">

								<div class="context">
									<p>ID : ${review.mid}</p>
									<p>${review.context}</p>

									<c:choose>
										<c:when test="${review.score == 5}">
											<span class="text-warning">&#9733; &#9733; &#9733;
												&#9733; &#9733;</span>
										</c:when>
										<c:when test="${review.score == 4}">
											<span class="text-warning">&#9733; &#9733; &#9733;
												&#9733; &#9734;</span>
										</c:when>
										<c:when test="${review.score == 3}">
											<span class="text-warning">&#9733; &#9733; &#9733;
												&#9734; &#9734;</span>
										</c:when>
										<c:when test="${review.score == 2}">
											<span class="text-warning">&#9733; &#9733; &#9734;
												&#9734; &#9734;</span>
										</c:when>
										<c:when test="${review.score == 1}">
											<span class="text-warning">&#9733; &#9734; &#9734;
												&#9734; &#9734;</span>
										</c:when>
									</c:choose>
									<small class="text-muted">${review.regdate}</small></a>

						</div>
						<!-- context end -->


						<div class="button">
							<c:choose>
								<c:when test="${review.value == 0}">
									<form action="/review/like" method="post">
										<input type="hidden" name="rno" value="${review.rno}">
										<input type="hidden" name="mid" value="${mid }"> <input
											type="hidden" name="value" value="${review.value }">
										<button type="submit" class="btn btn-primary">좋아요</button>
									</form>
								</c:when>

								<c:when test="${review.value == 1}">
									<form action="/review/like" method="post">

										<input type="hidden" name="rno" value="${review.rno}">
										<input type="hidden" name="mid" value="${mid }"> <input
											type="hidden" name="value" value="${review.value }">
										<button type="submit" class="btn btn-danger">싫어요</button>

									</form>
								</c:when>
							</c:choose>


							<form action="/review/delete" method="post">
								<input type="hidden" name="rno" value="${review.rno }">
								<input type="hidden" name="sno" value="${review.sno }">
								<input type="hidden" name="mid" value="${review.mid }">
								<button type="submit" class="btn btn-danger">삭제</button>
							</form>

						</div>
						<!-- button end -->
				</div>
				<!-- body end -->
				</c:forEach>
				<a href="/store/list" class="btn btn-success">목록으로</a> <a
					href="/review/register?sno=${store.sno }" class="btn btn-success">리뷰
					등록</a>
			</div>
			<!-- /.card -->
		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- row -->


</div>
<!-- /.container -->

<ul class="pagination">
	<c:if test="${pageMaker.prev }">
		<li class="page-item"><a class="page-link"
			href="/store/info?sno=${review.sno }&page=${pageMaker.start -1 }"
			tabindex="-1">Prev</a></li>
	</c:if>

	<c:forEach begin="${pageMaker.start }" end="${pageMaker.end }"
		var="num">
		<li class="page-item ${num == pageMaker.currentPage ? 'active' : '' }"><a
			class="page-link" href="/storeinfo?sno=${review.sno }&page=${num }">${num }</a></li>
	</c:forEach>

	<c:if test="${pageMaker.next }">
		<li class="page-item"><a class="page-link"
			href="/store/info?sno=${review.sno }&page=${pageMaker.end +1 }">Next</a></li>
	</c:if>
</ul>

<%@ include file="../reviewincludes/footer.jsp"%>
