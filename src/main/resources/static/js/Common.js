function moveBlog() {
    var newTab = window.open("http://blog.naver.com/jdkorea1974", '_blank');
    newTab.focus();
}

function moveCategory(index) {
    switch (index) {
        case 1 :    // index page
            break;
        case 2 :    // about
            break;
        case 3 :    // business
            break;
        case 4 :    // gallery
            break;
        case 5 :    // online
            break;
        case 6 :    // customer
            break;
    }
}

function bannerClick() {
    footerMoveCategory(4);
}

function footerMoveCategory(index) {
    switch (index) {
        case 1 :    // 회사소개
            break;
        case 2 :    // 사업분야
            break;
        case 3 :    // 갤러리
            break;
        case 4 :    // 온라인문의
            break;
        case 5 :    // 고객센터
            break;
        case 6 :    // 로그인
            break;
    }
}