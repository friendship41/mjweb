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
<form action="/insertmj.mdo" method="POST">
    <div>회사명 : <input type="text" name="mjName" required></div>
    <div>날짜 : <input type="text" id="mjdate" name="mjdate" readonly required></div>
    <div>시간 : <input type="text" id="mjtime" name="mjtime" required></div>
    <div>주소1 : <input type="text" id="mjloc1" name="mjloc1" readonly required> <input type="button" onclick="openDaumZipAddress()" value="찾기"></div>
    <div>주소2 : <input type="text" id="mjloc2" name="mjloc2" required></div>
    <div>기타코맨트 : <input type="text" name="mjComment"></div>
    <input type="hidden" id="lat" name="mjLat">
    <input type="hidden" id="lon" name="mjLng">
    <button>긔긔긔</button>
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

    $(document).ready(function () {
        $('#mjtime').timepicker({ 'scrollDefault': 'now' });
        $('#mjdate').datepicker({
            'format': 'yyyy-mm-dd',
            'autoclose': true
        });
    })
</script>
</body>
</html>

