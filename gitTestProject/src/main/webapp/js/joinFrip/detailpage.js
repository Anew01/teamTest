	//달력 기능
	$( function() {
    //     $.datepicker.setDefaults({
    //     nextText: "다음",
    //     prevText: "이전",
    //     monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
    //     dayNames: ["일", "월", "화", "수", "목", "금", "토" ],
    //     dayNamesShort: ["일", "월", "화", "수", "목", "금", "토" ],
    //     dayNamesMin: ["일", "월", "화", "수", "목", "금", "토" ]
    // });
    //   $( "#datepicker" ).datepicker();
    $('#gijgo').datepicker(
        { 
        	format:'yyyy-mm-d',
            header: true, 
            modal: true, 
            footer: true 
		});
});
		//호스트에게 연락하기 모달 
		window.onload=function(){
		const open = document.querySelector(".contact-host");
		const close = document.querySelector(".modal__closeBtn");
		const modal = document.querySelector(".modal-wrap");
		function init(){
			open.addEventListener("click", function(){
			console.log("hidden사라져랏!");
			modal.classList.remove("hidden");
			});
			close.addEventListener("click", function(){
			modal.classList.add("hidden");
			});
		}
			init();
		}

        //조회하기 
        function func1(fripNo){
        //ajax로 날짜, 인원  정보보내기
    	const calendar = $("#gijgo").val();
        const attendNumber = $(".attend-count").val();
                    
        console.log(fripNo);
        console.log(calendar);
        console.log(attendNumber);
        $.ajax({
            url : "/checkSchedule.do",
            type : "get",
            data : {fripNo : fripNo ,calendar : calendar, attendCount: attendCount},
            dataType: "JSON", //이거 적거나 아니면 서블릿에서 response.setContentType("application/json"); 이라고 적어준다.
            success : function(data){
                console.log(data, typeof data);
                if(data==0){
                	//data == 0 이면 예약불가
                	//날짜와 인원수를 조정해주세요 라는 alert뜬다
                	alert("날짜와 인원수를 조정해주세요.");
                	$("#reserve-button").hide();
                }else if(data==1){
                	//data == 1 이면 예약가능 
                	//-> 내가 지정한 날짜와 인원수 정보가 밑에 text로 다시한번 뜬다.
                	const a = $("<a>");
                	a.text(calendar);
                	$(".search-result").append(a);
                	/*
                	$(".search-result").append(calendar);
                	$(".search-result").append(attendCount);
                	 */
                	//-> '예약하기' 버튼이 생기고 payment.do로 넘어간다.(checkJoin.jsp 에서 버튼기능 구현하자!)
                	$("#reserve-button").show()
                	//-> 이 때, 내가 지정했던 날짜와 인원수 정보가 저장돼서 같이 넘어가야한다.
                }
            },
            error : function(){
            console.log("서버 호출 실패");
                }
            });
       
}
      
       


