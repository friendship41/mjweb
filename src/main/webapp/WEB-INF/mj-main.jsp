<%--
  Created by IntelliJ IDEA.
  User: stage
  Date: 2020-03-30
  Time: 오전 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>면접기록소</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/lib/bootstrap-datepicker.css'/>" />
</head>
<body>
<div style="margin-bottom: 10px;">
    <div style="margin-bottom: 5px;"><button onclick="location.href = '/insertmj.mdo'">새 면접 작성</button></div>
    <form action="/mjmain.mdo" method="get">
        <span><input type="text" id="mjdate" name="startDate" value="${nowDate}" required></span>
        <span><button>조회</button><a href="javascript:location.href='/mjmain.mdo'">전체조회</a></span>
    </form>
</div>
<div class="item" id="map" style="height:1000px; width: 100%;"></div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=56d66fb708db72842c6c188e866a48f7"></script>
<script type="text/javascript" src="<c:url value='/resources/lib/bootstrap-datepicker.js'/>"></script>
<script type="text/javascript">

    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(37.554, 126.9696), //지도의 중심좌표.
        level: 9 //지도의 레벨(확대, 축소 정도)
    };
    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    var mapList = new Array();

    <c:forEach items="${mjList}" var="mapList">
        var obj = new Object();
        obj.mjSeq = "${mapList.mjSeq}";

        obj.customerTbNo = "${mapList.customerTbNo}";

        obj.mjName = "${mapList.mjName}";

        var tempDate = new Date("${mapList.mjDate}");
        console.log(tempDate);
        obj.mjDate = (tempDate.getMonth()+1)+'월 '+tempDate.getDate()+'일';
        obj.mjTime = '${mapList.hour}시 ${mapList.min}분';

        obj.mjLoc = "${mapList.mjLoc}";

        obj.mjComment = "${mapList.mjComment}";

        obj.mjLat = "${mapList.mjLat}";
        obj.mjLat *= 1;
        obj.mjLng = "${mapList.mjLng}";
        obj.mjLng *= 1;
        mapList.push(obj);
    </c:forEach>
    console.log(mapList);

    var seq;

    for(var i = 0; i<mapList.length; i++)
    {
        var latlng = new kakao.maps.LatLng(mapList[i].mjLat, mapList[i].mjLng);
        var marker = new kakao.maps.Marker({
           map: map,
           position: latlng
        });

        var infoHTML = '';
        infoHTML += '<div><h1>'+mapList[i].mjName+'</h1></div>';
        infoHTML += '<div>날짜: '+mapList[i].mjDate+'</div>';
        infoHTML += '<div>시간: '+mapList[i].mjTime+'</div>';
        infoHTML += '<div>장소: '+mapList[i].mjLoc+'</div>';
        infoHTML += '<div>etc: '+mapList[i].mjComment+'</div>';


        var infowindow = new kakao.maps.InfoWindow({
            content: infoHTML
        });


        var smallInfoHTML = '';
        smallInfoHTML += '<div>'+mapList[i].mjDate+'</div>';

        var smallInfoWindow = new kakao.maps.InfoWindow({
            content : smallInfoHTML
        });




        // 마커에 이벤트를 등록하는 함수 만들고 즉시 호출하여 클로저를 만듭니다
        // 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        (function(marker, infowindow, smallInfoWindow) {
            // 마커에 mouseover 이벤트를 등록하고 마우스 오버 시 인포윈도우를 표시합니다
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                smallInfoWindow.close();
                infowindow.open(map, marker);
            });

            // 마커에 mouseout 이벤트를 등록하고 마우스 아웃 시 인포윈도우를 닫습니다
            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
                smallInfoWindow.open(map, marker)
            });

        })(marker, infowindow, smallInfoWindow);

        kakao.maps.event.addListener(marker, 'click', clickEvent(mapList[i].mjSeq));


        smallInfoWindow.open(map, marker);
    }

    function clickEvent(seq) {
        return function() {
            location.href = '/updatemj.mdo?mjSeq='+seq;
        }
    }

    $(document).ready(function () {
        $('#mjdate').datepicker({
            'format': 'yyyy-mm-dd',
            'autoclose': true
        });
    })

</script>
</body>
</html>
