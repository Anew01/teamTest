$(".sub-menu").prev().append("<span class='more'>+</span>");
$(".more").on("click", function (event) {
    $(this).parent().next().slideToggle();
    $(this).toggleClass("active");
    // 버블링 막음
    event.stopPropagation();
});
$(".more").parent().on("click", function () {
    // 이벤트 버블링
    // 부모가 클릭되면 자식이 클릴될때
    // 부모랑 자식이 끝없이 클릭될때가 있음
    $(this).children().last().click();
});