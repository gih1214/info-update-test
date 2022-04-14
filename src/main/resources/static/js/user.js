// 1. 회원정보 수정 이벤트 리스너
$("#btn-update").click(() => {
    update();
});

// 2. 회원정보 수정 함수
async function update() {
    let id = $("#id").val();
    let updateDto = {
        userName: $("#user-name").val(),
        password: $("#password").val(),
        phoneNum: $("#phone-num").val()
    }

    let response = await fetch(`/s/api/user/${id}`, {
        method: "PUT",
        body: JSON.stringify(updateDto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    });
    let responseParse = await response.json();

    if (responseParse.code == 1) {
        alert("업데이트 성공");
        location.href = `/s/user/${id}`;
    } else {
        alert("업데이트 실패");
    }
}