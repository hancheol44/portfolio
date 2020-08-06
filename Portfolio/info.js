$(document).ready(function(){
	$('.detail_card').css('display', 'none');
	$('#reviewWrite').css('display', 'none');
	$('#rWrite').css('display', 'none');
	
	// 리뷰 보기 
	$('#reviewbt').click(function(){
		var updown = $('#reviewbt').text();
		if(updown === '리뷰'){
			$('#reviewWrite').css('display', '');
			$('#reviewbt').text('닫기');
		} else {
			$('#reviewWrite').css('display', 'none');
			$('#reviewbt').text('리뷰');
		}
	});
	
	// 리뷰 작성 보기
	$('#addReview').click(function(){
		var wupdown = $('#addReview').text();
		if(wupdown === '리뷰작성'){
			$('#rWrite').css('display', '');
			$('#addReview').text('작성취소');
		} else {
			$('#rWrite').css('display','none');
			document.getElementById('rett').value=" ";
			document.getElementById('rebd').value=" ";
			$('#addReview').text('리뷰작성');
		}
		
		
	});
	
	// 상세보기 ifno 담기
	$('th').click(function(){
		var url = window.location.href;
		var urlArray = url.split("/");
		if(urlArray[5] === 'infoCT.pro'){
			location.href="http://localhost/pro/info/infoCT.pro";
		} else if(urlArray[5] === 'infoAC.pro'){
			location.href="http://localhost/pro/info/infoAC.pro";
		} else if(urlArray[5] === 'infoDT.pro'){
			location.href="http://localhost/pro/info/infoDT.pro";
		}
	});
	
});