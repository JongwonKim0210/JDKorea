$(document).ready(function () {
    getMapData();
});

function getMapData() {
    var staticMapContainer = document.getElementById("map");
    var centerPosition = new kakao.maps.LatLng(37.538464, 126.737664);

    var marker = [
        {position : centerPosition},
        {position : centerPosition, text : "레드몰 5층 501호 JDKorea"}
    ];

    var staticMapOption = {
        center : centerPosition,
        level : 3,
        marker : marker
    };

    new kako.maps.StaticMap(staticMapContainer, staticMapOption);
}
