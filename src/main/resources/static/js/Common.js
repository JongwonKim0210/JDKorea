function moveBlog() {
    var newTab = window.open("http://blog.naver.com/jdkorea1974", '_blank');
    newTab.focus();
}

function moveCategory(index) {
    var targetPage;
    switch (index) {
        case 1 :    // index page
            targetPage = "/home";
            break;
        case 2 :    // about
            targetPage = "/about";
            break;
        case 3 :    // business
            targetPage = "/business";
            break;
        case 4 :    // gallery
            targetPage = "/gallery";
            break;
        case 5 :    // online
            targetPage = "/online";
            break;
        case 6 :    // customer
            targetPage = "/customer";
            break;
    }

    location.href = targetPage;
}

function bannerClick() {
    footerMoveCategory(4);
}

function footerMoveCategory(index) {
    var targetPage;
    switch (index) {
        case 1 :    // 회사소개
            targetPage = "/about";
            break;
        case 2 :    // 사업분야
            targetPage = "/business";
            break;
        case 3 :    // 갤러리
            targetPage = "/gallery";
            break;
        case 4 :    // 온라인문의
            targetPage = "/online";
            break;
        case 5 :    // 고객센터
            targetPage = "/customer";
            break;
        case 6 :    // 로그인
            targetPage = "/login";
            break;
    }

    location.href = targetPage;
}