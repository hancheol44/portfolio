<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/info.css" />
<link rel="stylesheet" href="/pro/css/side.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/info.js"></script>
<style>

</style>
<script type="text/javascript">

</script>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
<jsp:include page="/left.pro" flush="true" />
  <!-- form 태그 영역 -->
  <input type="hidden" id="sid" name="SID" value="${SID}" />
  <!-- 클릭된 캠핑장 ifno -->
  <input type="hidden" id="c_ifno" name="ifno"/>
  <input type="hidden" id="infoct" name="ifct"/>
  <!-- 가운데 영역 (주내용 담길 곳) -->
  <div class="centercolumn w3-center">
    <div class="card">
      <h1>승차 검진소</h1>
      <!-- 자동차 극장 리스트 위치 -->
      <div id="List">
		<table class="cp" id="autoCP">
			  <tr>
			    <th style="width: 300px;"><h2>승차 검진소 List</h2></th>
			  </tr>
			  <c:forEach var="data" items="${DT_NAME_LIST}">
				  <tr>
				  	<td id="${data.ifno}">${data.ifname}</td>
				  </tr>
			  </c:forEach>
		</table>
      </div>
	  <div id="map"></div>
	  <div class='w3-row'><p></p></div>
	  <div class="detail_card">
	  	<div class="detail">
			<span> 승차검진소 이름 : </span> 
			<span id="acname"></span><img width="30" height="30" src="/pro/img/icons8-good-quality-64 default.png" alt="Noimg" id="like" value="0"/><span id="likecnt"></span><br><br>
			<span> 연락처 : </span> <span id="actel"></span><br><br>
			<span> 주소 : </span> <span id="acaddr"></span><br><br>
			<span> 길찾기 바로가기 : </span> <a id="search" href="" target="_blank"><span>링크</span></a><br><br>
		</div>
	  	<div class="mgbottom">
		  	<div class="avgstr">평점 : </div>
		  	<div id="strpoint"></div>
	  	</div>
	  	<br>
	  	<button class="rebtn" id="reviewbt" >리뷰</button><span id="ifrcnt"></span>
	  	<div id="reviewWrite">
   		<br><br>
        <div>
            <div>
                <span><h4><strong>리뷰</strong></h4></span>
            </div>
            <div>
                <div>                    
                    <div id="reviewhidden">
                    <button id="addReview">리뷰작성</button>
                        <div id="rWrite">
                        	 <div id="rst"><h6><b>평점</b></h6>
								<select id="rstSelect" name="rst">
									<option value="5">★★★★★
									<option value="4">★★★★
									<option value="3">★★★
									<option value="2">★★
									<option value="1">★
								</select>
								<br>
							</div>
	                            <textarea id="rett" placeholder="리뷰제목을 입력해주세요."></textarea>
	                            <textarea id="rebd" placeholder="리뷰내용을 입력해주세요."></textarea>
                            <br>
                                <button id="inputreview">등록</button>
					            
                               </div>
					            <div id="reviewList">
					            <!-- 리뷰 들어갈 위치 -->
					            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	  </div>
	  
      <!-- 자동차 캠핑 리스트 위치 끝 -->
	  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dd8f721c7ccf9b1ba7c336d64d77a8aa&libraries=services"></script>
	  <script type="text/javascript">
		var mapContainer = document.getElementById('map');
		var mapOption = {
		    center: new kakao.maps.LatLng(37.503672, 126.999805), // 지도의 중심좌표
		    level: 12 // 지도의 확대 레벨
		}// 지도를 표시할 div 
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		 $.ajax({
			 url: '/pro/info/infoDT_Addr.pro',
				type: 'post',
				dataType: 'json',
				success: function(obj){
				console.log(obj);
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
				var imageSrc = "/pro/img/icons8-old-car-48.png";
				// 주소로 좌표를 검색합니다
				for(var i = 0 ; i < obj.length ; i++){
					let tmp = obj[i].ifname;
					let str = '<div style="width:150px;text-align:center;padding:6px 0;">'+ tmp +'</div>';
					
					var imageSize = new kakao.maps.Size(40, 40); 	
					var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
					geocoder.addressSearch(obj[i].ifaddr , function(result, status) {
					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {
					    	 var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					        
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords,
					            image : markerImage
					        });
					        // 인포윈도우를 생성합니다
					        var infowindow = new kakao.maps.InfoWindow({
					            content : str
					        });
							
					        
					        kakao.maps.event.addListener(marker,'click', function(){
								// 마커 위에 인포 윈도우를 표시합니다.
								infowindow.open(map, marker);
							}); 
							
							 kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
						     kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
							// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
							function makeOverListener(map, marker, infowindow) {
							    return function() {
							        infowindow.open(map, marker);
							    };
							}
			
							// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
							function makeOutListener(infowindow) {
							    return function() {
							        infowindow.close();
							    };
							} 
					       
					     }
				       
					});
				}
				
				
			},
			error: function(request, error){
				alert('### 통신 에러 ###');
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		 });
		
		
		 
		 
		 $('td').click(function(){
			 var ifno = $(this).attr('id');
			 var memid = $('#sid').val();
			 var mapContainer = document.getElementById('map');
				var mapOption = {
				    center: new kakao.maps.LatLng(37.503672, 126.999805), // 지도의 중심좌표
				    level: 3 // 지도의 확대 레벨
				}// 지도를 표시할 div 
				
				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption); 
		 
		 $.ajax({
			 url: '/pro/info/infoDT_Detail.pro',
				type: 'post',
				dataType: 'json',
				data:{
					'ifno':ifno,
					'memid':memid
				},
				success: function(obj){
				var ifaddr = obj.ifaddr;
				var ifname = obj.ifname;
				
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
				 
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(ifaddr , function(result, status) {
				
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
				     
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				        
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
				        
				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        var infowindow = new kakao.maps.InfoWindow({
				            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+ifname+'</div>'
				        });
				        infowindow.open(map, marker);
				        
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        
				        map.setCenter(coords);
				     }
				});
				
			},
			error: function(request, error){
				alert('### 에러 ###');
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		 });
	  });
	  </script>
    </div>
  </div>
  
<jsp:include page="/right.pro" flush="true" />

<!-- footer -->
<div class="footer">
	
</div>

</body>
<script type="text/javascript" src="/pro/js/info_ajax.js"></script>
</html>