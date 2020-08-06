$(document).ready(function(){
	
	// 리뷰 작성 후 카운트
	function reviewCount(){
		var ifn = $('#c_ifno').val();
		var memid = $('#sid').val();
		// 카테고리 주소값 가져오기
		var url = window.location.href;
		var urlArray = url.split("/");
		if(urlArray[5] === 'infoCT.pro'){
			var infourl ='/pro/info/infoCT_Detail.pro';
		} else if(urlArray[5] === 'infoAC.pro'){
			infourl ='/pro/info/infoAC_Detail.pro';
		} else if(urlArray[5] === 'infoDT.pro'){
			infourl ='/pro/info/infoDT_Detail.pro';
		}
		
		$.ajax({
			url: infourl,
			type: 'post',
			dataType: 'json',
			data:{
				'ifno':ifn,
				'memid':memid
			},
			success: function(obj){
				$('#ifrcnt').text('('+obj.ifrcnt+')');
			},
			error: function(){
				alert('리뷰카운트 전송실패');
			}
	});
	
}	
	
// 글 삭제후 리스트 다시 호출	
function reList(){
		var ifn = $('#c_ifno').val();
		var url = window.location.href;
		var urlArray = url.split("/");
		if(urlArray[5] === 'infoCT.pro'){
			var infourl ='/pro/info/infoCT_ReviewList.pro';
		} else if(urlArray[5] === 'infoAC.pro'){
			infourl ='/pro/info/infoAC_ReviewList.pro';
		} else if(urlArray[5] === 'infoDT.pro'){
			infourl ='/pro/info/infoDT_ReviewList.pro';
		}
			$.ajax({
				url: infourl,
				type: 'post',
				dataType: 'json',
				data:{
					'ifno':ifn
				},
				success: function(obj){
					var len = obj.length;
					for(var i = 0 ; i < len ; i++){
						if(id === obj[i].memid){
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div value="gdgdgd" id="rlist'+obj[i].ifno+'" class="line">'+
									'<div>'+
									'<span><b>작성일 : <span id="rdate">'+ obj[i].rdate + '</span></b></span><br>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].name + '</span><br>'+
									'<span id="rrtt">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span id="rrbd">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									'<a class="modbtn" value="'+obj[i].ifrno+'" id="modbtn">수정</a>'+
									'<a class="delbtn" value="'+obj[i].ifrno+'" id="delbtn" onclick="remove()">삭제</a>'+
									'</div>' +
							'</div>' +
							'<br>')
						} else {
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div id="rlist'+obj[i].ifno+'" class="line">'+
									'<div>'+
									'<span><b>작성일 : <span id="rrst">'+ obj[i].rdate + '</span></b></span><br>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].name + '</span><br>'+
									'<span id="rrtt">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span id="rrbd">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									'</div>'+
							'</div>'+
							'<br>')
						}
					}
				},
				error: function(){
					alert('리뷰뽑기 통신실패');
				}
			});
		
		};
	
	// 글 삭제 ajax 클릭시
$(document).on('click','.delbtn', function remove(){
	var ifrno = $(this).attr('value');
	cifno = $('#c_ifno').val();
	
	// 카테고리 주소값 가져오기
	var url = window.location.href;
	var urlArray = url.split("/");
	// CT, AC, DT 구별 위한 인덱스 가져오기
	if(urlArray[5] === 'infoCT.pro'){
		var infourl ='/pro/info/infoCT_ReviewDel.pro';
	} else if(urlArray[5] === 'infoAC.pro'){
		infourl ='/pro/info/infoAC_ReviewDel.pro';
	} else if(urlArray[5] === 'infoDT.pro'){
		infourl ='/pro/info/infoDT_ReviewDel.pro';
	}
	
	$.ajax({
		url: infourl,
		type:'post',
		dataType:'json',
		data:{
			'ifrno':ifrno
		},
		success: function(obj){
			
			if(obj == 1){
				$('#'+'rlist'+ifrno).remove();
			} else{
				alert("실패");
			}
		},
		error: function(request, error){
			alert('삭제실패!!');
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	reList(); // 리뷰 목록 다시 불러오는 함수
	reviewCount(); //리뷰 카운트 다시 불러오는 함수
});


// 글 수정
$(document).on('click','.modbtn', function modi(){
	var ifrno = $(this).attr('value');
	var modbtn = $(this).html();
	var rttt = $('#'+'rtt'+ifrno).html();
	var rtbd = $('#'+'rbd'+ifrno).html();
	
	if(modbtn === '수정'){
		$('#'+'rtt'+ifrno).replaceWith('<textarea id="rtt'+ifrno+'" style="resize: none;">'+rttt+'</textarea>');
		$('#'+'rbd'+ifrno).replaceWith('<textarea id="rbd'+ifrno+'" style="resize: none;">'+rtbd+'</textarea>');
		$(this).text('등록');
	} else {
		var modirt = $('#'+'rtt'+ifrno).val();
		var modibd = $('#'+'rbd'+ifrno).val();
		
		$(this).text('수정');
		
		// 카테고리 주소값 가져오기
		var url = window.location.href;
		var urlArray = url.split("/");
		if(urlArray[5] === 'infoCT.pro'){
			var infourl ='/pro/info/infoCT_ReviewMod.pro';
		} else if(urlArray[5] === 'infoAC.pro'){
			infourl ='/pro/info/infoAC_ReviewMod.pro';
		} else if(urlArray[5] === 'infoDT.pro'){
			infourl ='/pro/info/infoDT_ReviewMod.pro';
		}
		
		$.ajax({
			url: infourl,
			type:'post',
			dataType:'json',
			data:{
				'ifrno':ifrno,
				'ifrtt':modirt,
				'ifrbd':modibd
			},
			success: function(obj){
				if(obj == 1){
				$('#'+'rtt'+ifrno).replaceWith('<span id="rtt'+ifrno+'">'+modirt+'</span>');
				$('#'+'rbd'+ifrno).replaceWith('<span id="rbd'+ifrno+'">'+modibd+'</span>');
				$(this).text('수정');
				} else {
					alert('수정처리 실패');
				}
			},
			error: function(request, error){
				alert('수정실패!!');
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}
	
});

	// 리스트목록 상세보기 ajax
	$('td').click(function (){
		var ifno = $(this).attr('id');
		var memid = $('#sid').val();
		$('#c_ifno').val(ifno);
		// 카테고리 주소값 가져오기
		var url = window.location.href;
		var urlArray = url.split("/");
		if(urlArray[5] === 'infoCT.pro'){
			var infourl ='/pro/info/infoCT_Detail.pro';
		} else if(urlArray[5] === 'infoAC.pro'){
			infourl ='/pro/info/infoAC_Detail.pro';
		} else if(urlArray[5] === 'infoDT.pro'){
			infourl ='/pro/info/infoDT_Detail.pro';
		}
		$.ajax({
			url: infourl,
			type: 'post',
			dataType: 'json',
			data:{
				'ifno':ifno,
				'memid':memid
			},
			success: function(obj){
				var name = obj.ifname;
				var tel = obj.iftel;
				var addr = obj.ifaddr;
				var price = obj.ifpri;
				var link = obj.iflink;
				var strp = obj.ifrst;
				var like = obj.iflike;
				var clike = obj.clike;
				
				if(strp == 5){
					$('#strpoint').html('★★★★★');
				} else if(strp == 4){
					$('#strpoint').html('★★★★');
				} else if(strp == 3){
					$('#strpoint').html('★★★');
				} else if(strp == 2){
					$('#strpoint').html('★★');
				} else if(strp == 1){
					$('#strpoint').html('★');
				} else {
					$('#strpoint').html(' ');
				}
				
				$('#like').val(clike);
				if(clike == 0){
					$('#like').attr('src','/pro/img/icons8-good-quality-64 default.png');
				} else {
					$('#like').attr('src','/pro/img/icons8-good-quality-64 like.png');
				}
				$('#ifrcnt').text('('+obj.ifrcnt+')');  // 리뷰 갯수 반환
				$('#acname').html(name);
				$('#actel').html(tel);
				$('#acaddr').html(addr);
				$('#acpri').html(price);
				$('#likecnt').html(like);
				$('#hplink').attr('href', link);
				$('#search').attr('href','https://map.kakao.com/link/search/' + addr);
				$('.detail_card').css('display', '');
				$('#reviewbt').text('리뷰');
				$('#addReview').text('리뷰작성');
				$('#reviewList *').remove();          
				$('#rWrite').css('display','none');
				$('#infoct').val(obj.ifct);   
			},
			error: function(request, error){
				alert('### Detail 통신에러 ###');
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
	
	// 리뷰 보기 ajax 처리
	$('#reviewbt').click(function(){
		var btnname = $('#reviewbt').text();
		var ifn = $('#c_ifno').val();
		var id = $('#sid').val();
		if(btnname === '닫기'){
			
			// 카테고리 주소값 가져오기
			var url = window.location.href;
			var urlArray = url.split("/");
			if(urlArray[5] === 'infoCT.pro'){
				var infourl ='/pro/info/infoCT_ReviewList.pro';
			} else if(urlArray[5] === 'infoAC.pro'){
				infourl ='/pro/info/infoAC_ReviewList.pro';
			} else if(urlArray[5] === 'infoDT.pro'){
				infourl ='/pro/info/infoDT_ReviewList.pro';
			}
			
			$.ajax({
				url: infourl,
				type: 'post',
				dataType: 'json',
				data:{
					'ifno':ifn
				},
				success: function(obj){
					var len = obj.length;
					
					for(var i = 0 ; i < len ; i++){
						if(id === obj[i].memid){
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div id="rlist'+obj[i].ifrno+'" class="line">'+
									'<div>'+
									'<span><b>작성일 : <span id="rdate">'+ obj[i].rdate + '</span></b></span><br>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].name + '</span><br>'+
									'<span><b>제목 : </b></span><span id="rtt'+obj[i].ifrno+'">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span><b>내용 : </b></span><span id="rbd'+obj[i].ifrno+'">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									'<a class="modbtn" value="'+obj[i].ifrno+'" id="modbtn">수정</a>'+
									'<a class="delbtn" value="'+obj[i].ifrno+'" id="delbtn" onclick="remove()">삭제</a>'+
									'</div>' +
							'</div>' +
							'<br>')
						} else {
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div id="rlist'+obj[i].ifrno+'" class="line">'+
									'<div>'+
									'<span><b>작성일 : <span id="rrst">'+ obj[i].rdate + '</span></b></span><br>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].name + '</span><br>'+
									'<span><b>제목 : </b></span><span id="rtt'+obj[i].ifrno+'">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span><b>내용 : </b></span><span id="rbd'+obj[i].ifrno+'">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									'</div>'+
							'</div>'+
							'<br>')
						}
					}
				},
				error: function(){
					alert('리뷰뽑기 통신실패');
				}
			});
		} else {
			$('#reviewList *').remove();
		}
	
	});
	
	// 리뷰 작성 ajax 처리
	$('#inputreview').click(function(){
		var ifno = $('#c_ifno').val();
		var strp = $('#rstSelect').val();
		var rtt = $('#rett').val();
		var rbd = $('#rebd').val();
		var sid = $('#sid').val();
		
		// 카테고리 주소값 가져오기
		var url = window.location.href;
		var urlArray = url.split("/");
		if(urlArray[5] === 'infoCT.pro'){
			var infourl ='/pro/info/infoCT_ReviewWrite.pro';
		} else if(urlArray[5] === 'infoAC.pro'){
			infourl ='/pro/info/infoAC_ReviewWrite.pro';
		} else if(urlArray[5] === 'infoDT.pro'){
			infourl ='/pro/info/infoDT_ReviewWrite.pro';
		}
			$.ajax({
				url: infourl,
				type: 'post',
				dataType: 'json',
				data:{
					'ifrst':strp,
					'ifrtt':rtt,
					'ifrbd':rbd,
					'ifno': ifno,
					'memid': sid
				},
				success: function(obj){
					$('#reviewList').prepend('<div id="remove_point">'+
							'<div id="rlist'+obj.ifno+'" class="line">'+
							'<div>'+
							'<span><b>작성일 : <span id="rrst">'+ obj.rdate + '</span></b></span><br>'+
							'<span><b>평점 : <span id="rrst">'+ obj.ifrst + '</span></b></span><br>'+
							'<span id="rname">작성자 : '+ obj.name + '</span><br>'+
							'<span id="rrtt">제목 : '+ obj.ifrtt + '</span>'+
							'</div>'+
							'<div>'+
							'<span id="rrbd">내용 : '+ obj.ifrbd + '</span>'+
							'</div>'+
							'</div>'+
					'</div>'+
					'<br>')
					document.getElementById('rett').value=" ";
					document.getElementById('rebd').value=" ";
				},
				error: function(request, error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
			reList(); // 리뷰 목록 다시 불러오는 함수
			reviewCount(); //리뷰 카운트 다시 불러오는 함수
	});
	
	// 좋아요 관련 처리 ajax
	$('img').click(function(){
		var clike = $(this).val();
		var ifno = $('#c_ifno').val();
		var sid = $('#sid').val();
		var ifct = $('#infoct').val();
		
			$.ajax({
				url:'/pro/info/infoLike.pro',
				type:'post',
				dataType:'json',
				data:{
					'ifno':ifno,
					'memid':sid,
					'ifct':ifct
				},
				success: function(obj){
					$('#like').val(obj.clike);
					if(clike == 1){
						$('#like').attr('src','/pro/img/icons8-good-quality-64 default.png');
					} else {
						$('#like').attr('src','/pro/img/icons8-good-quality-64 like.png');
					}
					$('#likecnt').html(obj.iflike);
				},
				error: function(){
					alert('좋아요 통신실패');
				}
			});
	});
	
});