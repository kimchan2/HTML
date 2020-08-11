/**
 *
 */
currentPage = 1;

replyDeleteServer = function(idx) {
	$.ajax({
		url: "/jqpro/ReplyDelete",
		method: "get",
		data: {"renum" : idx},
		success: function(res) {
			alert(res.sw);
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType: "JSON"
		
	});
};

replyUpdateServer = function(but) {
	$.ajax({
		url: "/jqpro/ReplyUpdate",
		method: "post",
		data: reply,
		success: function(res) {
			alert(res.sw);
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType: "JSON"
	});
};

replyListServer = function(but) {
	$.ajax({
		url: "/jqpro/ReplyList",
		method: "post",
		data: "bonum=" + reply.bonum,
		dataType: "JSON",
		success: function(res) {
			
			$(but).parents(".panel").find(".rep").remove();
			
			code = "";
			$.each(res, function(i, v) {
	            code += `<div class="panel-body rep">`;
	            code += `  <p style="width:80%; float:left;">&nbsp;&nbsp;&nbsp;`;
	            code += `    <span>`;
	            code += `      ${v.name} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${v.redate}`;
	            code += `    </span><br><br>`;
	            code += `    <span class="cont"> ${v.cont}`;
	            code += `    </span>`;
	            code += `  </p>`;
	            code += `  <p style="float:right;">`;
	            code += `    <button idx="${v.renum}" type="button" name="r_modify" class="action">댓글수정</button>`;
	            code += `    <button idx="${v.renum}" type="button" name="r_delete" class="action">댓글삭제</button>`;
	            code += `  </p>`;
	            code += `</div>`;
			});
			$(but).parents(".panel").find(".pbody").append(code);
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status);
		}
	});
}

replySaveServer = function(but) {
	$.ajax({
		url: "/jqpro/ReplySave",
		method: "post",
		data: reply,
		dataType: "JSON",
		success: function(res) {
			//alert(res.sw)
			replyListServer(but);
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status)
		}
	});
}

// 글쓰기
writeServer = function() {
	$.ajax({
		url: "/jqpro/Write",
		method: "post",
		data: $("#wform").serializeArray(),
		success: function(res) {
			alert(res.sw);
			readServer(1);
			$("#wModal").close();
		},
		error: function(xhr) {
			alert("상태 : " + xhr.status); 
		},
		dataType: "JSON"
 			
	});
};


readServer = function(page) {

   $.ajax({
      url : "/jqpro/List.do",
      method : "post",
      data : "page=" + page,
      success : function(res) {
         $('#result1').empty();
         
         tp = res.totalPage;
         sp = res.startPage;
         ep = res.endPage;
         currentPage = res.currentPage;
         
         code = `<div class="panel-group" id="parent">`;
         $.each(res.listdata,function(i, v) {
            code += `<div class="panel panel-default">`;
            code += `  <div class="panel-heading">`;
            code += `    <h4 class="panel-title">`;
            code += `      <a idx="${v.seq}" class="action" name="list" data-toggle="collapse" data-parent="#parent" href="#collapse${v.seq}">${v.subject}</a>`;
            code += `    </h4>`;
            code += `  </div>`;
            code += `  <div id="collapse${v.seq}" class="panel-collapse collapse">`;
            code += `    <div class="panel-body pbody">`;
            code += `      <p style="width:80%; float:left;"> 작성자 : ${v.writer} &nbsp;&nbsp;&nbsp;`;
            code += `      이메일 : ${v.mail} &nbsp;&nbsp;&nbsp;`;
            code += `      조회수 : ${v.hit}`;
            code += `      </p>`;
            code += `      <p style="float:right;">`;
            code += `        <button idx="${v.seq}" type="button" name="modify" class="action">수정</button>`;
            code += `        <button idx="${v.seq}" type="button" name="delete" class="action">삭제</button>`;
            code += `      </p><hr style="clear:both;">`;
            code += `	   <p>${v.content}</p>`;
            code += `	   <p>`;
            code += `      <textarea class="area" cols="60"></textarea>`;
            code += `      <button type="button" idx="${v.seq}" style="height:45px; vertical-align:top;"
            					   name="reply" class="action">등록</button>`;
            code += `      </p>`;
            code += `    </div>`;
            code += `  </div>`;
            code += `</div>`;
         })
         code += `</div>`;
         $('#result1').html(code);
         
         $("#pagegroup").empty();
         
         pager = "";
         // 이전
         if(sp > 1){
        	pager += '<ul class="pager">';
        	pager += '  <li class="previous"><a href="#">Previous</a></li>';
        	pager += '</ul>';
        	$(pager).appendTo("#pagegroup");
         }
         
         // 페이지번호
         pager = '<ul class="pagination">';
         for(i=sp; i <= ep; i++){
        	 if(currentPage == i){
        		 // 색상
        		 pager += `<li class="active"><a class="paging" href="#">${i}</a></li>`;
        		 
        	 }else{
        		 // 링크
        		 pager += `<li><a class="paging" href="#">${i}</a></li>`;
        		 
        	 }
         }
         pager += '</ul>';
         $(pager).appendTo("#pagegroup");
         
         // 다음
         if(ep < tp){
        	 pager = '<ul class="pager">';
        	 pager += '  <li class="next"><a href="#">Next</a></li>';
        	 pager += '</ul>';
        	 $(pager).appendTo("#pagegroup");
         }
         
         
      },
      error : function(xhr) {
         alert("상태 : " + xhr.status)
      },
      dataType : "JSON"
   });

};