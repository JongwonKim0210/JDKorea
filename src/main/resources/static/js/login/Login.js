function checkUser() {
    $.ajax({
        url : "/loginCheck",
        type : "post",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            "id" : document.getElementById("id"),
            "password" : document.getElementById("password")
        }),
        success : function (data) {
            resultCheck(data);
        },
        error : function () {
            alert("오류가 발생하였습니다. 다시 시도하여주시기 바랍니다.");
        }
    });
}

function resultCheck(data) {
    if (JSON.parse(data)) {
        location.href = "/";
    } else {
        alert("아이디 또는 비밀번호가 잘못되었습니다.");
    }
}

function logout() {
    $.ajax({
        url : '/logout',
        type : 'post',
        dataType: 'json',
        contentType: 'application/json',
        data : JSON.stringify(''),
        success : function (data) {
            if (JSON.parse(data)) {
                alert("안전하게 로그아웃 되었습니다.");
                location.href = "/";
            } else {
                alert("로그아웃 중 오류가 발생하였습니다.");
            }
        },
        error : function () {
            alert("로그아웃 중 오류가 발생하였습니다.");
        }
    });
}