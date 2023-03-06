<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>카카오톡으로 문의 보내기</title>
        <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
            integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx"
            crossorigin="anonymous"></script>
        <script>Kakao.init('933fdb3f5c64bf38bb66bc3494744435'); // 사용하려는 앱의 JavaScript 키 입력</script>
    </head>

    <body>
        <div id="kakao-talk-channel-chat-button" data-channel-public-id="_RTXDxj" data-title="question"
            data-size="large" data-color="yellow" data-shape="pc" data-support-multiple-densities="true"></div>

        <script>
            window.kakaoAsyncInit = function () {
                Kakao.Channel.createChatButton({
                    container: '#kakao-talk-channel-chat-button',
                });
            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = 'https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.channel.min.js';
                js.integrity = 'sha384-MEvxc+j9wOPB2TZ85/N6G3bt3K1/CgHSGNSM+88GoytFuzP4C9szmANjTCNfgKep';
                js.crossOrigin = 'anonymous';
                fjs.parentNode.insertBefore(js, fjs);
            })(document, 'script', 'kakao-js-sdk');
        </script>
    </body>

    </html>