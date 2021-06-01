var imgSrc = ["@{/images/main01.jpg}", "@{/images/main02.jpg}", "@{/images/main03.jpg}", "@{/images/main04.jpg}"];
var srcProbe = 0;

$(document).ready(function () {
    var target = document.getElementById("presentation_area");
    var imgElement = document.createElement("img");
    imgElement.id = "presentation_img";
    imgElement.src = imgSrc[srcProbe];
    target.appendChild(imgElement);
});

// TODO : 도메인 주소 필요? 이미지 소스 어떻게 가져올꺼?
function setPresentation() {
    if (srcProbe >= 4) {
        srcProbe = 0;
    }

    var target = document.getElementById("presentation_img");
    target.src = imgSrc[srcProbe];
    srcProbe++;
}