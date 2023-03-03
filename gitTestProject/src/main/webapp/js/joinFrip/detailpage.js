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
            header: true, 
            modal: true, 
            footer: true 
		});
});
  

//호스트에게 연락하기 모달 
const open = document.querySelector(".contact-host");
        const close = document.querySelector(".modal__closeBtn");
        const modal = document.querySelector(".modal-wrap");
        function init(){
            open.addEventListener("click", function(){
                console.log("1");
                modal.classList.remove("hidden");
            });
            close.addEventListener("click", function(){
                modal.classList.add("hidden");
            });
        }
        init();

        //조회하기 
        function func1(){
            //ajax로 날짜, 인원  정보보내기
            $("#seemore-button").on("click", function(){
                    const calendar = $(".calendar").children().text();
                    const attendNumber = $(".attend-number").val();
                    const fripNo = $("").val();
                    
                    console.log(calendar);
                    console.log(attendNumber);
//                    $.ajax({
//                        url : "/joinFrip.do",
//                        type : "get",
//                        data : {calendar : calendar, attendNumber: attendNumber},
//                        dataType: "JSON", //이거 적거나 아니면 서블릿에서 response.setContentType("application/json"); 이라고 적어준다.
//                        success : function(data){
//                            console.log(data, typeof data)
//                            if(data==null){
//                                result.append("해당하는 날짜에 가능한 스프립이 없습니다.");
//                            }else{
//                                for(let i=0; i<data.length; i++){
//                                    result.append("날짜 : "+data.memberId+"<br>");
//                                    result.append("시간 : "+data.memberName+"<br>");
//                                    result.append("가격 : "+data.memberPhone+"<br>");
//                                }
//                            }
//                        },
//                        error : function(){
//                            console.log("서버 호출 실패");
//                        }
//                    });
                });
        }
      
       


