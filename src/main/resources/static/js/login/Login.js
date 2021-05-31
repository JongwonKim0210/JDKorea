function checkUser() {
    var data = {
        "id" : document.getElementById("id"),
        "password" : document.getElementById("password")
    }

    $.ajax({
        url : "/loginCheck",
        type : "post",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(data),
        success : function (data) {
            resultCheck(data);
        },
        error : function () {
            alert("오류가 발생하였습니다. 다시 시도하여주시기 바랍니다.");
        }
    });
}

function resultCheck(data) {
    var result = JSON.parse(data);
    if (result) {
        location.href = "/";
    } else {
        alert("아이디 또는 비밀번호가 잘못되었습니다.");
    }
}