<%--
  Created by IntelliJ IDEA.
  User: stage
  Date: 2020-03-30
  Time: 오후 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>면접추가/수정</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/lib/bootstrap-datepicker.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/jquery.timepicker.css'/>" />
</head>
<body>
<form action="/updatemj.mdo" method="POST">
    <input type="hidden" name="mjSeq" value="${mj.mjSeq}">
    <div>회사명 : <input type="text" name="mjName" value="${mj.mjName}" required></div>
    <div>날짜 : <input type="text" id="mjdate" name="mjdate" readonly required></div>
    <div>시간 : <input type="text" id="mjtime" name="mjtime" required></div>
    <div><input type="text" id="addresss" value="${mj.mjLoc}"></div>
    <div>주소1 : <input type="text" id="mjloc1" name="mjloc1" readonly required> <input type="button" onclick="openDaumZipAddress()" value="찾기"></div>
    <div>주소2 : <input type="text" id="mjloc2" name="mjloc2" required></div>
    <div>기타코맨트 : <input type="text" name="mjComment" value="${mj.mjComment}"></div>
    <input type="hidden" id="lat" name="mjLat" value="${mj.mjLat}">
    <input type="hidden" id="lon" name="mjLng" value="${mj.mjLng}">
    <button>수정</button>&nbsp;&nbsp;&nbsp;<a href="/deletemj.mdo?mjSeq=${mj.mjSeq}">삭제</a>
</form>
<div style="margin: 10px;">
    <button onclick="history.back()">뒤로가기</button>
</div>

<script type="text/JavaScript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=56d66fb708db72842c6c188e866a48f7&libraries=services"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/jquery.timepicker.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/lib/bootstrap-datepicker.js'/>"></script>
<script type="text/javascript">
    var geocoder = new daum.maps.services.Geocoder();

    function openDaumZipAddress() {
        new daum.Postcode({

            oncomplete: function (data) {
                //console.log(data);
                $("#mjloc1").val(data.address);
                geocoder.addressSearch(data.address, function (results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        $("#lat").attr("value", result.y);
                        $("#lon").attr("value", result.x);
                        // console.log('lat: '+result.y+', lng: '+result.x);
                    }
                });
                $("#mjloc2").focus();
            }
        }).open();
    }

    var today = new Date("${mj.mjDate}");
    var hour = today.getHours();
    var ampm = '';
    hour *= 1;
    if(hour > 12)
    {
        hour -= 12;
        ampm = 'pm';
    }
    else
    {
        ampm = 'am';
    }
    if(hour < 10)
    {
        hour = '0'+hour;
    }

    var min = today.getMinutes();
    if(min < 10)
    {
        min = '0'+min;
    }

    var mon = today.getMonth()+1;
    if(mon < 10)
    {
        mon = '0'+mon;
    }

    var dd = today.getDate();
    if(dd < 10)
    {
        dd = '0'+dd;
    }

    $(document).ready(function () {
        $('#mjtime').timepicker({ 'scrollDefault': 'now' });
        $('#mjdate').datepicker({
            'format': 'yyyy-mm-dd',
            'autoclose': true
        });
        $("#mjdate").attr("value", today.getFullYear()+"-"+mon+"-"+dd);
        $("#mjtime").attr("value", hour+":"+min+ampm);
    })
</script>
</body>
</html>

